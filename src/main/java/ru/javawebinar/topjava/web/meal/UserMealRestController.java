package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserMealServiceImpl;

import java.util.Date;
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

    public boolean update(int id) {
        return service.update(id);
    }

    public boolean delete(int id) {
        return service.delete(id);
    }

    public boolean deleteAllMeals(int userId) {
        return service.deleteAllMeals(userId);
    }

    public UserMeal getMeal(int id) {
        return service.getMeal(id);
    }

    public List<UserMeal> getAllMeals(int userId) {
        return service.getAllMeals(userId);
    }

    public List<UserMeal> getAllMealsBetweenDates(Date startDate, Date endDate, int userId) {
        return service.getAllMealsBetweenDates(startDate,endDate,userId);
    }

}
