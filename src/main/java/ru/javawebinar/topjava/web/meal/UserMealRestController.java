package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserMealServiceImpl;

import java.util.List;

/**
 * Controller for UserMeal to get request from GUI
 *
 * GKislin
 * 06.03.2015.
 */
@Controller
public class UserMealRestController {

    @Autowired
    private UserMealServiceImpl service;

    /*
    * methods
    */
    public UserMeal save(UserMeal meal) {
        return service.save(meal);
    }

    public boolean delete(int id) {
        return service.delete(id);
    }

    public UserMeal getMeal(int id) {
        return service.getMeal(id);
    }

    public List<UserMeal> getAllMeals() {
        return service.getAllMeals();
    }

}
