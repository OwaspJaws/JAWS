package org.owasp.jaws.bad.dao;

import org.apache.commons.dbutils.BeanProcessor;
import org.apache.commons.dbutils.DbUtils;
import org.owasp.jaws.good.exception.FatalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Sam Theys
 */
public abstract class BadDAO {

    private final Logger LOG = LoggerFactory.getLogger(BadDAO.class);

    @Autowired
    private DataSource dataSource;
    private BeanProcessor beanProcessor = new BeanProcessor();

    protected BeanProcessor getBeanProcessor() {
        return beanProcessor;
    }

    protected Logger getLog() {
        return LOG;
    }

    protected Statement getStatement() {

        try {
            return dataSource.getConnection().createStatement();
        } catch (SQLException ex) {
            throw new FatalException("Can't create SQL Statement !", ex);
        } finally {
            try {
                if (dataSource != null) {
                    DbUtils.closeQuietly(dataSource.getConnection());
                }
            } catch (SQLException ex) {
                // give up
            }
        }

    }

    protected PreparedStatement getPreparedStatement(String query) {
        try {
            return dataSource.getConnection().prepareStatement(query);
        } catch (SQLException ex) {
            throw new FatalException("Can't create SQL Statement !", ex);
        }
    }

    protected ResultSet executeQuery(String query) {
        try {
            return getStatement().executeQuery(query);
        } catch (SQLException ex) {
            return null;
        }
    }

    protected void execute(String query) {
        try {
            getStatement().execute(query);
        } catch (SQLException se) {
            LOG.error("Error inserting query", se);
        }
    }

    protected <T> T toBeanList(ResultSet resultSet, Class clazz) {
        try {
            return (T) getBeanProcessor().toBeanList(resultSet, clazz);
        } catch (SQLException se) {
            LOG.error("Error processing ResulSet to bean", se);
            return null;
        }
    }

    protected <T> T toBean(ResultSet resultSet, Class clazz) {
        try {
            return (T) getBeanProcessor().toBean(resultSet, clazz);
        } catch (SQLException ex) {
            LOG.error("Error processing ResulSet to bean", ex);
            return null;
        }
    }

    protected void preparedStatementSetLong(PreparedStatement preparedStatement, int order, Long value) {
        try {
            preparedStatement.setLong(order, value);
        } catch (SQLException ex) {
            LOG.error("Can't prepare statement!", ex);
        }
    }

    protected ResultSet executePreparedStatement(PreparedStatement preparedStatement) {
        try {
            return preparedStatement.executeQuery();
        } catch (SQLException ex) {
            LOG.error("Can't execute prepared statement!", ex);
            return null;
        }
    }

    protected ResultSet setResultSetToFirstRow(ResultSet resultSet) {
        try {
            resultSet.next();
            return resultSet;
        } catch (SQLException ex) {
            LOG.error("Can't set ResultSet to first row!", ex);
            return null;
        }
    }

}
