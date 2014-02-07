package org.owasp.jaws.bad.dao;

import org.owasp.jaws.good.bean.Fish;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
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
    public Fish getFishById(long id) {
        PreparedStatement preparedStatement = getPreparedStatement("select * from fish where id = ?");
        preparedStatementSetLong(preparedStatement, 1, id);

        ResultSet resultSet = executePreparedStatement(preparedStatement);
        resultSet = setResultSetToFirstRow(resultSet);

        if (resultSet != null) {
            return toBean(resultSet, Fish.class);
        } else {
            return null;
        }
    }

    @Override
    public List<Fish> getFishByBreed(String breed) {
        getLog().debug("Looking for breed: {}", breed);
        ResultSet resultSet = executeQuery("SELECT * FROM fish where breed = '" + breed + "'");
        if (resultSet != null) {
            return toBeanList(resultSet, Fish.class);
        } else {
            return null;
        }
    }

}
