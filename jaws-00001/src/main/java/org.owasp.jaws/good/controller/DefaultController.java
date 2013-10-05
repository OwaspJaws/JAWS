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

    @RequestMapping(method = RequestMethod.GET,value = "/index")
    public ModelAndView homepage () {
        return new ModelAndView("index");
    }

}
