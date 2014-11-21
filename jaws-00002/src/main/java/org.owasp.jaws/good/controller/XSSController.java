package org.owasp.jaws.good.controller;

import org.owasp.jaws.good.bean.Fish;
import org.owasp.jaws.good.dao.IFishDAO;
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
@Controller(value = "good-cross-site-scripting-controller")
public class XSSController {

    @Autowired
    private IFishDAO goodFishDAO;

    @RequestMapping(method = RequestMethod.GET, value = {NavigationConstants.XSS_STORED,NavigationConstants.XSS_STORED + NavigationConstants.GOOD})
    public ModelAndView index() {
        List<Fish> fishList = goodFishDAO.getFishes();

        ModelAndView view = new ModelAndView(NavigationConstants.XSS_STORED + NavigationConstants.INDEX);
        view.addObject(NavigationConstants.NAVIGATION, NavigationConstants.XSS_STORED);
        view.addObject(NavigationConstants.TAB, NavigationConstants.GOOD);
        view.addObject("goodFishList", fishList);

        return view;
    }

}
