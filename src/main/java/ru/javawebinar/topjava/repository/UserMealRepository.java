package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Interface for UserMeal DAO(Repository)
 *
 * GKislin
 * 06.03.2015.
 */
public interface UserMealRepository {

    /**
     * save new meal
     * @param meal
     * @return
     */
    UserMeal save(UserMeal meal, int userId);


    /**
     * delete meal by id
     * @param id
     * @return
     */
    boolean delete(int id, int userId);

    /**
     * delete all meals for user
     * @param userId
     * @return
     */
    void deleteAll(int userId);

    /**
     * get meal by its id
     * @param id
     * @return
     */
    UserMeal get(int id, int userId);

    /**
     * get all meals
     * @return
     */
    List<UserMeal> getAll(int userId);


    /**
     * filter between dates
     * @param startDate
     * @param endDate
     * @param userId
     * @return
     */
    List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId);



}
