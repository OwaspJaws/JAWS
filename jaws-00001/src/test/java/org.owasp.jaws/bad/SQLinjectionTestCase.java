package org.owasp.jaws.bad;

import org.hamcrest.CoreMatchers;
import org.hibernate.NonUniqueResultException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.owasp.jaws.setup.AbstractSQLInjectionSetup;
import org.owasp.jaws.good.bean.Fish;
import org.owasp.jaws.good.dao.IFishDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.is;

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
            String message = String.format("Not as many SQL injection counted as expected: %s vs %s !",sqlInjectionCount,maliciousFishBreeds.size());
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

            try {
                Fish fish = badFishDAO.getFishByBreed(sharkBreed);

                // check that we selected a fish
                Assert.assertThat(fish, CoreMatchers.notNullValue());

                // check that the breed we selected is the breed we got
                if (!sharkBreed.equalsIgnoreCase(fish.getBreed())) {
                    LOG.error("SQL injection detected");
                    sqlInjectionCount++;
                }
            } catch (NonUniqueResultException nue) {
                LOG.error("SQL injection detected");
                sqlInjectionCount++;
            }

        }

    }

}
