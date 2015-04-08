package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.javawebinar.topjava.model.BaseEntity;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserMealService;
import ru.javawebinar.topjava.service.UserService;

import java.util.List;

/**
 * Created by Dmitrii on 4/8/15.
 */
@Controller
public class UserMealController {

    @Autowired
    UserMealService service;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/meals", method = RequestMethod.GET)
    public String getAllUserMeals(Model model) {
        model.addAttribute("allMeals", service.getAll(BaseEntity.START_SEQ));
        model.addAttribute("userName", userService.get(BaseEntity.START_SEQ).getName());
        return "mealList";
    }
}
