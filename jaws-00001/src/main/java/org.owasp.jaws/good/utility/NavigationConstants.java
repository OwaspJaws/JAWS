package org.owasp.jaws.good.utility;

/**
 * @author Sam Theys
 */
public class NavigationConstants {

    public static final String NAVIGATION = "navigation";
    public static final String TAB = "tab";
    public static final String GOOD = "/good-example";
    public static final String BAD = "/bad-example";
    public static final String INDEX = "/index";
    public static final String ERROR = "/error";

    public static final String ERROR_METHOD_NOT_SUPPORTED = "/error/method-not-supported";
    public static final String ERROR_PAGE_NOT_FOUND = "/error/page-not-found";

    public static final String GENERIC_INDEX = "/";
    public static final String GENERIC_ABOUT = "/generic/about";
    public static final String GENERIC_CONTACT = "/generic/contact";

    public static final String INJECTION_SQL = "/injection/sql-injection";
    public static final String INJECTION_LDAP = "/injection/ldap";

    public static final String XSS_STORED = "/cross-site-scripting/stored";
    public static final String XSS_DOM = "/cross-site-scripting/dom";


    /**
     * Getters are needed so that we can access the constants as beans in JSP
     */

    public String getGENERIC_INDEX() {
        return GENERIC_INDEX;
    }

    public String getGENERIC_ABOUT() {
        return GENERIC_ABOUT;
    }

    public String getGENERIC_CONTACT() {
        return GENERIC_CONTACT;
    }

    public String getINJECTION_SQL() {
        return INJECTION_SQL;
    }

    public String getINJECTION_LDAP() {
        return INJECTION_LDAP;
    }

    public String getXSS_STORED() {
        return XSS_STORED;
    }

    public String getXSS_DOM() {
        return XSS_DOM;
    }

    public String getGOOD() {
        return GOOD;
    }

    public String getBAD() {
        return BAD;
    }


}
