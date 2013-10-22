package org.owasp.jaws.good.controller;

import org.owasp.jaws.good.utility.NavigationConstants;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sam Theys
 */
@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ModelAndView methodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        ModelAndView view = new ModelAndView(NavigationConstants.ERROR_NOTSUPPORTED);
        view.addObject(NavigationConstants.NAVIGATION, NavigationConstants.ERROR);

        return view;
    }
}
