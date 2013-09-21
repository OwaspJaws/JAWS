package org.owasp.jaws.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.owasp.jaws.beans.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: massoo
 */
@Repository
@Transactional
public class LoginDAO implements ILoginDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addLogin(Login login) {
        sessionFactory.getCurrentSession().persist(login);
    }

    public List<Login> getLogins() {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("getLogins");
        return query.list();
    }

    public void deleteAll() {
        Query query = sessionFactory.getCurrentSession().getNamedQuery("deleteAllLogins");
        query.executeUpdate();
    }
}
