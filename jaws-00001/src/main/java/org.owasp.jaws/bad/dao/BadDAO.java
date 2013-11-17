package org.owasp.jaws.bad.dao;

import org.apache.commons.dbutils.BeanProcessor;
import org.owasp.jaws.good.exception.FatalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Sam Theys
 */
public abstract class BadDAO {

    protected Logger LOG = LoggerFactory.getLogger(BadDAO.class);

    @Autowired
    private DataSource dataSource;
    private BeanProcessor beanProcessor = new BeanProcessor();

    protected BeanProcessor getBeanProcessor () {
        return beanProcessor;
    }

    protected Statement getStatement() {

        try {
            return dataSource.getConnection().createStatement();
        } catch (SQLException ex) {
            throw new FatalException("Can't create SQL Statement !",ex);
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
            LOG.error("Error inserting query",se);
        }
    }

    protected <T> T toBeanList(ResultSet resultSet,Class clazz) {
        try {
            return (T) getBeanProcessor().toBeanList(resultSet,clazz);
        } catch (SQLException se) {
            LOG.error("Error processing ResulSet to bean",se);
            return null;
        }
    }

}
