package org.owasp.jaws.bad.dao;

import org.owasp.jaws.good.bean.Fish;

import java.util.List;

/**
 * @author Sam Theys
 */
public interface IFishDAO {

    List<Fish> getFishes();

    void insert(Fish fish);

    void update(Fish fish);

    void deleteAllFishes();

    Fish getFishById(long id);

    List<Fish> getFishByBreed(String breed);

}
