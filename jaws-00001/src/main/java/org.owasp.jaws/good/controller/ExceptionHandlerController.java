package org.owasp.jaws.good.controller;

import org.owasp.jaws.good.utility.Constants;
import org.springframework.stereotype.Controller;
import org.springframework.util.ErrorHandler;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sam Theys
 */
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ModelAndView methodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        ModelAndView view = new ModelAndView("error/not-supported");
        view.addObject(Constants.NAVIGATION,Constants.NAVIGATION_SQL_INJECTION);

        return view;
    }

}
