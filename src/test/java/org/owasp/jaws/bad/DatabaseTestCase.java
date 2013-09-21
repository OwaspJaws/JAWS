package org.owasp.jaws.bad;

import org.apache.commons.dbutils.DbUtils;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.owasp.jaws.AbstractDatabaseSetup;
import org.owasp.jaws.beans.Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.greaterThan;

/**
 * User: massoo
 */
public class DatabaseTestCase extends AbstractDatabaseSetup {

    private String email = "bademail@owasp.org' or 1=1--";
    private String password = "password";

    @Before
    public void doBefore() {
        for (Map.Entry entry: getValidEmailPasswords().entrySet()) {
            Login login = new Login();
            login.setEmail(entry.getKey().toString());
            login.setPassword(entry.getValue().toString());

            getLoginDAO().addLogin(login);
        }
    }

    @After
    public void doAfter() {
        getLoginDAO().deleteAll();
    }

    @Test
    public void testSQLInjection() {
        Connection connection = null;

        try {
            connection = getDataSource().getConnection();

            // BAD: there is no validation step as in the good example
            runEmailPasswordTest(connection);
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

    public void runEmailPasswordTest(Connection connection) throws SQLException {
        ResultSet resultSet = doLogin(connection, email, password);
        Assert.assertThat(resultSet, CoreMatchers.notNullValue());

        int rowcount = 0;
        while (resultSet.next()) {
            LOG.info(resultSet.getString("email"));
            rowcount++;
        }

        // NOTICE: if more logins are returned than a successful SQL injection attack has taken place
        Assert.assertThat("SQL injection: more rows selected than intended", rowcount, greaterThan(1));
    }


    public ResultSet doLogin(Connection connection, String email, String password) throws SQLException {
        Statement statement = connection.createStatement();

        // BAD: Dynamic SQL queries build with string concatenation which can be exploited by an attacker
        return statement.executeQuery("SELECT * FROM login WHERE email = '" + email + "' AND password = '" + password + "'");
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


}
