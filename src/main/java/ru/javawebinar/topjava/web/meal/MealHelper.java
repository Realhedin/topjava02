package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserMealService;
import ru.javawebinar.topjava.service.UserService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Dmitrii on 4/15/15.
 */
@Controller
public class MealHelper {

    private static final LoggerWrapper LOG = LoggerWrapper.get(MealHelper.class);

    @Autowired
    private UserMealService service;

    /*
    * methods
    */
    public UserMeal create(UserMeal meal) {
        int userId = LoggedUser.id();
        LOG.info("create {} for User {}", userId);
        return service.save(meal, userId);
    }

    public UserMeal update(UserMeal meal) {
        int userId = LoggedUser.id();
        LOG.info("update {} for User {}",meal, userId);
        return service.update(meal, userId);
    }

    public void delete(int id) {
        int userId = LoggedUser.id();
        LOG.info("delete meal {} for User {}", id, userId);
        service.delete(id,userId);
    }

    public void deleteAll() {
        int userId = LoggedUser.id();
        LOG.info("delete for User {}", userId);
        service.deleteAll(userId);
    }

    public UserMeal get(int id) {
        int userId = LoggedUser.id();
        LOG.info("get meal {} for User {}", id, userId);
        return service.get(id, userId);
    }

    public List<UserMeal> getAll() {
        int userId = LoggedUser.id();
        LOG.info("getAll for User {}",  userId);
        return service.getAll(userId);
    }

    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate) {
        int userId = LoggedUser.id();
        LOG.info("getBetween {} and {} for User {}", startDate, endDate, userId);
        return service.getBetween(startDate,endDate,userId);
    }

}
