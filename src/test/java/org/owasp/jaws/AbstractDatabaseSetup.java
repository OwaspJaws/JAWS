package org.owasp.jaws;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.owasp.dao.ILoginDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * @author Sam Theys
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/test-configuration/applicationContext.xml"})
@Ignore
public class AbstractDatabaseSetup {

    protected Logger LOG = LoggerFactory.getLogger(AbstractDatabaseSetup.class);

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ILoginDAO loginDAO;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public ILoginDAO getLoginDAO() {
        return loginDAO;
    }

    public void setLoginDAO(ILoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }
}
