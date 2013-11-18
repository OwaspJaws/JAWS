package org.owasp.jaws.bad.controller;

import org.owasp.jaws.bad.dao.IFishDAO;
import org.owasp.jaws.good.bean.Fish;
import org.owasp.jaws.good.utility.NavigationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Sam Theys
 */
@Controller(value = "bad-sql-injection-controller")
public class SQLInjectionController {

    @Autowired
    private IFishDAO badFishDAO;

    @RequestMapping(method = RequestMethod.GET, value = NavigationConstants.INJECTION_SQL + NavigationConstants.BAD)
    public ModelAndView index() {
        ModelAndView view = new ModelAndView(NavigationConstants.INJECTION_SQL + NavigationConstants.INDEX);
        view.addObject(NavigationConstants.NAVIGATION, NavigationConstants.INJECTION_SQL);
        view.addObject(NavigationConstants.TAB,NavigationConstants.BAD);

        return view;
    }

    @RequestMapping(method = RequestMethod.POST, value = NavigationConstants.INJECTION_SQL + NavigationConstants.BAD)
    public ModelAndView badExample(@RequestParam("breed") String breed) {

        List<Fish> fishList = badFishDAO.getFishByBreed(breed);

        ModelAndView view = new ModelAndView(NavigationConstants.INJECTION_SQL + NavigationConstants.INDEX);
        view.addObject(NavigationConstants.NAVIGATION, NavigationConstants.INJECTION_SQL);
        view.addObject(NavigationConstants.TAB,NavigationConstants.BAD);
        view.addObject("badFishList",fishList);

        return view;
    }

}
