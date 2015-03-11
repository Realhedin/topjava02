package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.List;

/**
 * GKislin
 * 09.03.2015.
 */
public interface UserMealService {

    public UserMeal save(UserMeal meal);

    public boolean update(int id);

    public boolean delete(int id);

    public boolean deleteAllMeals(int userId);

    public UserMeal getMeal(int id);

    public List<UserMeal> getAllMeals(int userId);


}
