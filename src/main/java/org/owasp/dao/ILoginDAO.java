package org.owasp.dao;

import org.owasp.beans.Login;

import java.util.List;

/**
 * @author Sam Theys
 */
public interface ILoginDAO {

    void addLogin(Login login);
    List<Login> getLogins();
    void deleteAll();

}
