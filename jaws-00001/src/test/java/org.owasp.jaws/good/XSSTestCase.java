package org.owasp.jaws.good;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.owasp.jaws.good.bean.Fish;
import org.owasp.jaws.good.dao.IFishDAO;
import org.owasp.jaws.good.utility.EncoderWrapper;
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
        if (xssCount > 0) {
            String message = String.format("Some XSS issues are not neutralized: %s vs %s !", xssCount, xssFish);
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
        return EncoderWrapper.encodeForHTML(fishBreed);
    }

}
