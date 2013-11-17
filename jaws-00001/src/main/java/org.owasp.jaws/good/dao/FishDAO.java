package org.owasp.jaws.good.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.owasp.jaws.good.bean.Fish;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Sam Theys
 */
@Repository(value = "goodFishDAO")
@Transactional
public class FishDAO implements IFishDAO {

    private static final Logger LOG = LoggerFactory.getLogger(FishDAO.class);

    private static String GET_FISHES = "FROM Fish";
    private static String DELETE_FISHES = "DELETE FROM Fish";
    private static String GET_FISH_BY_BREED = "FROM Fish f where f.breed = :breed";

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Fish> getFishes() {
        Query query = getCurrentSession().createQuery(GET_FISHES);
        return query.list();
    }

    @Override
    public void insert(Fish fish) {
        getCurrentSession().persist(fish);
    }

    @Override
    public void update(Fish fish) {
        getCurrentSession().merge(fish);
    }

    @Override
    public void deleteAllFishes() {
        Query query = getCurrentSession().createQuery(DELETE_FISHES);
        query.executeUpdate();
    }

    @Override
    public Fish getFishByBreed(String breed) {
        LOG.debug("Looking for breed: {}",breed);
        Query query = getCurrentSession().createQuery(GET_FISH_BY_BREED)
                .setString("breed", breed);

        return (Fish) query.uniqueResult();
    }
}
