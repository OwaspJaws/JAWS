package org.owasp.jaws.setup;

import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sam Theys
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/test-configuration/applicationContext.xml"})
@Ignore
public class AbstractXSSSetup {

    protected int xssFish = 1;
    protected Logger LOG = LoggerFactory.getLogger(AbstractXSSSetup.class);

}
