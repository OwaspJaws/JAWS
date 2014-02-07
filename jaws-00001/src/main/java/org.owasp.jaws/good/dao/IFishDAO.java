package org.owasp.jaws.good.dao;

import org.owasp.jaws.good.bean.Fish;

import java.util.List;

/**
 * @author Sam Theys
 */
public interface IFishDAO {

    public List<Fish> getFishes();

    public void insert(Fish fish);
    public void update(Fish fish);
    public void deleteAllFishes();

    public Fish getFishById(long id);

    public Fish getFishByBreed(String breed);

}
