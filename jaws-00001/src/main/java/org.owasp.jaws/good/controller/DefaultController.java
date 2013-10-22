package org.owasp.jaws.good.controller;

import org.owasp.jaws.good.utility.NavigationConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sam Theys
 */
// TODO: handle method not supported exception
@Controller(value = "good-default-controller")
public class DefaultController {

    @RequestMapping(method = RequestMethod.GET,value = NavigationConstants.GENERIC_INDEX)
    public ModelAndView index() {
        ModelAndView view = new ModelAndView(NavigationConstants.GENERIC_INDEX + NavigationConstants.INDEX);
        view.addObject(NavigationConstants.NAVIGATION, NavigationConstants.GENERIC_INDEX);

        return view;
    }

    @RequestMapping(method = RequestMethod.GET,value = NavigationConstants.GENERIC_ABOUT)
    public ModelAndView about() {
        ModelAndView view = new ModelAndView(NavigationConstants.GENERIC_ABOUT);
        view.addObject(NavigationConstants.NAVIGATION, NavigationConstants.GENERIC_ABOUT);

        return view;
    }

    @RequestMapping(method = RequestMethod.GET,value = NavigationConstants.GENERIC_CONTACT)
    public ModelAndView contact() {
        ModelAndView view = new ModelAndView(NavigationConstants.GENERIC_CONTACT);
        view.addObject(NavigationConstants.NAVIGATION, NavigationConstants.GENERIC_CONTACT);

        return view;
    }

}
