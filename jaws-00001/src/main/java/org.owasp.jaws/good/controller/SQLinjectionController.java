package org.owasp.jaws.good.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sam Theys
 */
@Controller
public class SQLinjectionController {

    @RequestMapping(method = RequestMethod.GET,value = "/sql-injection")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("sql-injection/sql-injection");
        view.addObject("navigation","sql-injection");

        return view;
    }

}
