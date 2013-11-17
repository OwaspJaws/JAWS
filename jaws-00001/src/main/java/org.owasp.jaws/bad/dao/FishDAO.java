package org.owasp.jaws.bad.dao;

import org.apache.commons.dbutils.BeanProcessor;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.owasp.jaws.good.bean.Fish;
import org.owasp.jaws.good.dao.IFishDAO;
import org.owasp.jaws.good.exception.FatalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            return toBeanList(resultSet,Fish.class);
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
    public Fish getFishByBreed(String breed) {
        LOG.debug("Looking for breed: {}",breed);
        ResultSet resultSet = executeQuery("SELECT * FROM fish where breed = '" + breed + "'");
        if (resultSet != null) {
            List<Fish> fishList = toBeanList(resultSet, Fish.class);
            if (fishList.size() > 1) {
                throw new NonUniqueResultException(fishList.size());
            } else {
                return fishList.get(0);
            }
        } else {
            return null;
        }
    }

}
