package org.owasp.jaws.good;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.owasp.jaws.good.bean.Fish;
import org.owasp.jaws.good.dao.IFishDAO;
import org.owasp.jaws.setup.AbstractSQLInjectionSetup;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.Matchers.is;

/**
 * @author Sam Theys
 */
public class SQLInjectionTestCase extends AbstractSQLInjectionSetup {

    @Autowired
    protected IFishDAO goodFishDAO;

    @Test
    public void testDefendAgainstSQLInjection() {

        lookupByBreed(validFishBreeds, true);
        lookupByBreed(maliciousFishBreeds, false);

    }

    public void lookupByBreed(List<String> sharkBreeds, boolean status) {

        for (String sharkBreed : sharkBreeds) {

            Fish fish = goodFishDAO.getFishByBreed(sharkBreed);

            if (status) {
                // check that we selected a fish
                Assert.assertThat(fish, CoreMatchers.notNullValue());

                // check that the breed we selected is the breed we got
                Assert.assertThat(sharkBreed, is(fish.getBreed()));
            } else {
                Assert.assertThat(null, is(fish));
            }

        }

    }

}
