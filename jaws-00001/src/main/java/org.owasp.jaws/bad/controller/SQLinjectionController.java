package org.owasp.jaws.bad.controller;

import org.owasp.jaws.good.utility.NavigationConstants;
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

    @RequestMapping(method = RequestMethod.POST, value = NavigationConstants.INJECTION_SQL + NavigationConstants.BAD)
    public ModelAndView badExample() {
        ModelAndView view = new ModelAndView(NavigationConstants.INJECTION_SQL + NavigationConstants.INDEX);
        view.addObject(NavigationConstants.NAVIGATION, NavigationConstants.INJECTION_SQL);

        return view;
    }

}
