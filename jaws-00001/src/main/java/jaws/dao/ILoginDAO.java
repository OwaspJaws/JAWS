package org.owasp.jaws.dao;

import org.owasp.jaws.beans.Login;

import java.util.List;

/**
 * @author Sam Theys
 */
public interface ILoginDAO {

    void addLogin(Login login);
    List<Login> getLogins();
    void deleteAll();

}
