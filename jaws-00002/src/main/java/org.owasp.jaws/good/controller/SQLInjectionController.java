package org.owasp.jaws.good.controller;

import org.owasp.jaws.good.bean.Fish;
import org.owasp.jaws.good.dao.IFishDAO;
import org.owasp.jaws.good.utility.NavigationConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Sam Theys
 */
@Controller(value = "good-sql-injection-controller")
public class SQLInjectionController {

    @Autowired
    private IFishDAO goodFishDAO;

    @RequestMapping(method = RequestMethod.GET, value = {NavigationConstants.INJECTION_SQL, NavigationConstants.INJECTION_SQL + NavigationConstants.GOOD})
    public ModelAndView index() {
        ModelAndView view = new ModelAndView(NavigationConstants.INJECTION_SQL + NavigationConstants.INDEX);
        view.addObject(NavigationConstants.NAVIGATION, NavigationConstants.INJECTION_SQL);
        view.addObject(NavigationConstants.TAB, NavigationConstants.GOOD);

        return view;
    }

    @RequestMapping(method = RequestMethod.POST, value = NavigationConstants.INJECTION_SQL + NavigationConstants.GOOD)
    public ModelAndView goodExample(@RequestParam("breed") String breed) {

        Fish fish = goodFishDAO.getFishByBreed(breed);

        ModelAndView view = new ModelAndView(NavigationConstants.INJECTION_SQL + NavigationConstants.INDEX);
        view.addObject(NavigationConstants.NAVIGATION, NavigationConstants.INJECTION_SQL);
        view.addObject(NavigationConstants.TAB, NavigationConstants.GOOD);
        view.addObject("goodFish", fish);

        return view;
    }

}
