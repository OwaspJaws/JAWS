package org.owasp.jaws.good.dao;

import org.owasp.jaws.good.bean.Login;

import java.util.List;

/**
 * @author Sam Theys
 */
public interface ILoginDAO {

    void addLogin(Login login);
    List<Login> getLogins();
    void deleteAll();

}
