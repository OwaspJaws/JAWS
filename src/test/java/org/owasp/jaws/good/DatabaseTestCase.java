package org.owasp.jaws.good;

import org.apache.commons.dbutils.DbUtils;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.owasp.jaws.AbstractDatabaseSetup;
import org.owasp.jaws.beans.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.not;

/**
 * @author Sam Theys
 */
public class DatabaseTestCase extends AbstractDatabaseSetup {

    // NOTICE: pattern used to white list trusted characters
    private static Pattern emailPattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    @Before
    public void doBefore() {
        for (Map.Entry entry : getValidEmailPasswords().entrySet()) {
            Login login = new Login();
            login.setEmail(entry.getKey().toString());
            login.setPassword(entry.getValue().toString());

            getLoginDAO().addLogin(login);
        }
    }

    @Test
    public void testDefendAgainstSQLInjection() {
        Connection connection = null;

        try {
            connection = getDataSource().getConnection();
            runEmailPasswordTest(connection, getValidEmailPasswords());
            runEmailPasswordTest(connection, getMaliciousEmailPasswords());
        } catch (SQLException e) {
            LOG.error("Could not execute query: {}", e.getMessage());
            Assert.fail();
        } catch (Exception e) {
            LOG.error("Error {}", e.getMessage());
            Assert.fail();
        } finally {
            // NOTICE: using DBUtils we are sure that the connection won't remain open
            DbUtils.closeQuietly(connection);
        }

    }

    public void runEmailPasswordTest(Connection connection, Map<String,String> emailPasswordMap) throws SQLException {

        for (Map.Entry entry : emailPasswordMap.entrySet()) {

            // NOTICE: We validate if the user input contains valid email to be passed to the SQL query
            if (validate(entry.getKey().toString())) {

                ResultSet resultSet = doLogin(connection, entry.getKey().toString(), entry.getValue().toString());
                Assert.assertThat(resultSet, CoreMatchers.notNullValue());

                int rowcount = 0;
                while (resultSet.next()) {
                    LOG.info(resultSet.getString("email"));
                    rowcount++;
                }

                // NOTICE: if more logins are returned than a successful SQL injection attack has taken place
                Assert.assertThat("SQL injection: more rows selected than intended", rowcount, not(greaterThan(1)));
            } else {
                LOG.error("SQLInjection mitigated through validation, please investigate");
            }

        }

    }

    public ResultSet doLogin(Connection connection, String email, String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM login WHERE email = ? AND password = ?");
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        return preparedStatement.executeQuery();
    }

    public boolean validate(String email) {
        Matcher matcher = emailPattern.matcher(email);
        if (!matcher.matches()) {
            return false;
        } else {
            return true;
        }
    }

    public Map<String, String> getValidEmailPasswords() {
        Map<String, String> emailPasswordMap = new HashMap<String, String>();
        emailPasswordMap.put("user1@owasp.org", "user1");
        emailPasswordMap.put("user2@owasp.org", "user2");
        emailPasswordMap.put("user3@owasp.org", "user3");
        emailPasswordMap.put("user4@owasp.org", "user4");
        emailPasswordMap.put("user5@owasp.org", "user5");

        return emailPasswordMap;
    }

    public Map<String, String> getMaliciousEmailPasswords() {
        Map<String, String> emailPasswordMap = new HashMap<String, String>();
        emailPasswordMap.put("bademail@owasp.org' or 1=1--", "user1");
        emailPasswordMap.put("user2@owasp.org", "user2' or 1=1--");

        return emailPasswordMap;
    }

    /**
     * EXTRA: If you only expect x-amount records to be returned we advise to limit this through the SQL query (e.g.: select top 5, limit, ..)
     */

}
