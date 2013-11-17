package org.owasp.jaws.bad.dao;

import org.owasp.jaws.good.bean.Fish;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author Sam Theys
 */
@Repository(value = "badFishDAO")
@Transactional
public class FishDAO extends BadDAO implements IFishDAO {

    @Override
    public List<Fish> getFishes() {
        ResultSet resultSet = executeQuery("SELECT * FROM fish");
        if (resultSet != null) {
            return toBeanList(resultSet, Fish.class);
        } else {
            return null;
        }
    }

    @Override
    public void insert(Fish fish) {
        // TODO: create insert statement
    }

    @Override
    public void update(Fish fish) {
        // TODO: create update statement
    }

    @Override
    public void deleteAllFishes() {
        String query = "DELETE * FROM fish";
        execute(query);
    }

    @Override
    public List<Fish> getFishByBreed(String breed) {
        LOG.debug("Looking for breed: {}", breed);
        ResultSet resultSet = executeQuery("SELECT * FROM fish where breed = '" + breed + "'");
        if (resultSet != null) {
            List<Fish> fishList = toBeanList(resultSet, Fish.class);
            return fishList;
        } else {
            return null;
        }
    }

}
