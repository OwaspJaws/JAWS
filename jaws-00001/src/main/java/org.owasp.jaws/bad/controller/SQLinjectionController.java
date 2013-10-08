package org.owasp.jaws.bad.controller;

import org.owasp.jaws.good.utility.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sam Theys
 */
// TODO: handle method not supported exception
@Controller(value = "bad-sql-injection-controller")
public class SQLinjectionController {

    @RequestMapping(method = RequestMethod.POST,value = "/sql-injection/bad-example")
    public ModelAndView goodExample() {
        ModelAndView view = new ModelAndView("sql-injection/sql-injection");
        view.addObject(Constants.NAVIGATION, Constants.NAVIGATION_SQL_INJECTION);

        return view;
    }

}
