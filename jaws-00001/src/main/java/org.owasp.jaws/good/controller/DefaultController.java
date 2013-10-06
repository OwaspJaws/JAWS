package org.owasp.jaws.good.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sam Theys
 */
@Controller
public class DefaultController {

    @RequestMapping(method = RequestMethod.GET,value = "/")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("index");
        view.addObject("navigation","index");

        return view;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/about")
    public ModelAndView about() {
        ModelAndView view = new ModelAndView("default/about");
        view.addObject("navigation","about");

        return view;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/contact")
    public ModelAndView contact() {
        ModelAndView view = new ModelAndView("default/contact");
        view.addObject("navigation","contact");

        return view;
    }

}
