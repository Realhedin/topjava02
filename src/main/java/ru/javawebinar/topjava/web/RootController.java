package ru.javawebinar.topjava.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: gkislin
 * Date: 22.08.2014
 */
@Controller
public class RootController {

    @RequestMapping(value = "/meals", method = RequestMethod.GET)
    public String mealList(Model model) {
        return "mealList";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userList() {
        return "userList";
    }
}
