package org.owasp.jaws.bad.controller;

import org.owasp.jaws.bad.dao.IFishDAO;
import org.owasp.jaws.good.bean.Fish;
import org.owasp.jaws.good.utility.NavigationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Sam Theys
 */
@Controller(value = "bad-cross-site-scripting-controller")
public class XSSController {

    @Autowired
    private IFishDAO badFishDAO;

    @RequestMapping(method = RequestMethod.GET, value = NavigationConstants.XSS_STORED + NavigationConstants.BAD)
    public ModelAndView index() {
        List<Fish> fishList = badFishDAO.getFishes();

        ModelAndView view = new ModelAndView(NavigationConstants.XSS_STORED + NavigationConstants.INDEX);
        view.addObject(NavigationConstants.NAVIGATION, NavigationConstants.XSS_STORED);
        view.addObject(NavigationConstants.TAB, NavigationConstants.BAD);
        view.addObject("badFishList", fishList);

        return view;
    }

}
