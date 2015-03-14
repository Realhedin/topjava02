package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.exception.ExceptionUtil;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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


    @Override
    public UserMeal save(UserMeal meal, int userId) {
        return repository.save(meal, userId);
    }

    @Override
    public UserMeal update(UserMeal meal, int userId) {
        return ExceptionUtil.check(repository.save(meal, userId), meal.getId());
    }

    @Override
    public void delete(int id, int userId) {
        ExceptionUtil.check(repository.delete(id, userId), id);
    }

    @Override
    public void deleteAll(int userId) {
        repository.deleteAll(userId);
    }

    @Override
    public UserMeal get(int id, int userId) {
        return ExceptionUtil.check(repository.get(id, userId), id);
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return repository.getAll(userId);
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return repository.getBetween(startDate, endDate.plus(1, ChronoUnit.DAYS), userId);
    }


    //additional
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
