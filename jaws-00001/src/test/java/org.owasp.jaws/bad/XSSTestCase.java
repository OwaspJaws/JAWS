package org.owasp.jaws.bad;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.owasp.jaws.bad.dao.IFishDAO;
import org.owasp.jaws.good.bean.Fish;
import org.owasp.jaws.setup.AbstractXSSSetup;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Sam Theys
 */
public class XSSTestCase extends AbstractXSSSetup {

    @Autowired
    protected IFishDAO badFishDAO;
    private int xssCount = 0;

    @Before
    public void doBefore() {
        xssCount = 0;
    }

    @After
    public void doAfter() {
        if (xssCount != 1) {
            String message = String.format("Not as many cross site scripting issues counted as expected: %s vs %s !", xssCount, xssFish);
            Assert.fail(message);
        }
    }

    @Test
    public void testDefendAgainstXSS() {
        getContaminatedFishById(4);
    }

    public void getContaminatedFishById(long id) {

        Fish contaminatedFish = badFishDAO.getFishById(id);
        String outputOnTheWebsite = throwTheFishOnTheLand(contaminatedFish.getBreed());

        LOG.info("Comparing for XSS: {} and {}", outputOnTheWebsite, contaminatedFish.getBreed());

        if (outputOnTheWebsite.equals(contaminatedFish.getBreed())) {
            xssCount = 1;
        }

    }

    public String throwTheFishOnTheLand(String fishBreed) {
        return fishBreed;
    }

}
