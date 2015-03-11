package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Service implementation for UserMeal
 *
 * GKislin
 * 06.03.2015.
 */
@Service
public class UserMealServiceImpl implements UserMealService {

    @Autowired
    private UserMealRepository repository;

    /**
     * methods
     */
    public UserMeal save(UserMeal meal) {
        return repository.save(meal);
    }

    public boolean update(int id) {
        return repository.update(id);
    }

    public boolean delete(int id) {
        return repository.delete(id);
    }

    public boolean deleteAllMeals(int userId) {
        return repository.deleteAllMeals(userId);
    }

    public UserMeal getMeal(int id) {
        return repository.getMeal(id);
    }

    public List<UserMeal> getAllMeals(int userId) {
        return repository.getAllMeals(userId);
    }

    @Override
    public List<UserMeal> getAllMealsBetweenDates(Date startDate, Date endDate, int userId) {
        return repository.getAllMealsBetweenDates(startDate, endDate, userId);
    }

    @Override
    public List<UserMeal> filterByBetweenDates(Date startDate, Date endDate, List<UserMeal> list) {
        ArrayList<UserMeal> userMeals = new ArrayList<>();
            for (UserMeal meal : list) {
                if (meal.getFromDate().after(startDate) && meal.getToDate().before(endDate)) {
                    userMeals.add(meal);
                }
            }

        return userMeals;
    }
}
