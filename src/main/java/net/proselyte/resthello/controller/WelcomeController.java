package net.proselyte.resthello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for Welcome page.
 *
 * @@author Eugene Suleimanov
 */

@Controller
public class WelcomeController {
    @RequestMapping("/")
    public ModelAndView home() {
        return new ModelAndView("welcome");
    }
}
