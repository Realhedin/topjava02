package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.Date;
import java.util.List;

/**
 * GKislin
 * 09.03.2015.
 */
public interface UserMealService {

    /**
     * save meal
     * @param meal
     * @return
     */
    public UserMeal save(UserMeal meal);

    /**
     * update meal by id
     * @param id
     * @return
     */
    public boolean update(int id);

    /**
     * delete meal by id
     * @param id
     * @return
     */
    public boolean delete(int id);

    /**
     * delete all meals for current user by id
     * @param userId
     * @return
     */
    public boolean deleteAllMeals(int userId);

    /**
     * get meal by id
     * @param id
     * @return
     */
    public UserMeal getMeal(int id);

    /**
     * get all meals for current user by id
     * @param userId
     * @return
     */
    public List<UserMeal> getAllMeals(int userId);

    /**
     * get all meals between dates for current user
     * @param startDate
     * @param endDate
     * @param userId
     * @return
     */
    public List<UserMeal> getAllMealsBetweenDates(Date startDate, Date endDate, int userId);

    /**
     * get all meals between dates for existing list for current user
     * @param startDate
     * @param endDate
     * @param list
     * @return
     */
    public List<UserMeal> filterByBetweenDates(Date startDate, Date endDate, List<UserMeal> list);
}
