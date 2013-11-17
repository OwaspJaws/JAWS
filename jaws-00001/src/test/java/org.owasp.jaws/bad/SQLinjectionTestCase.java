package org.owasp.jaws.bad;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.owasp.jaws.bad.dao.IFishDAO;
import org.owasp.jaws.good.bean.Fish;
import org.owasp.jaws.setup.AbstractSQLInjectionSetup;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Sam Theys
 */
public class SQLInjectionTestCase extends AbstractSQLInjectionSetup {

    @Autowired
    protected IFishDAO badFishDAO;
    private int sqlInjectionCount = 0;

    @Before
    public void doBefore() {
        sqlInjectionCount = 0;
    }

    @After
    public void doAfter() {
        if (sqlInjectionCount != maliciousFishBreeds.size()) {
            String message = String.format("Not as many SQL injection counted as expected: %s vs %s !", sqlInjectionCount, maliciousFishBreeds.size());
            Assert.fail(message);
        }
    }

    @Test
    public void testDefendAgainstSQLInjection() {

        lookupByBreed(validFishBreeds);
        lookupByBreed(maliciousFishBreeds);

    }

    public void lookupByBreed(List<String> sharkBreeds) {

        for (String sharkBreed : sharkBreeds) {

            List<Fish> fishList = badFishDAO.getFishByBreed(sharkBreed);

            if (fishList != null) {

                if (fishList.size() > 1) {
                    LOG.error("SQL injection detected");
                    sqlInjectionCount++;

                    // we need to continue so we don't count this one twice
                    continue;
                }

                // check that the breed we selected is the breed we got
                if (!sharkBreed.equalsIgnoreCase(fishList.get(0).getBreed())) {
                    LOG.error("SQL injection detected");
                    sqlInjectionCount++;
                }
            }

        }

    }

}
