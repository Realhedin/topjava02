package ru.javawebinar.topjava.repository;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.UserMeal;

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
    UserMeal save(UserMeal meal);


    /**
     * update existing meal
     * @param id
     * @return
     */
    boolean update(int id);

    /**
     * delete meal by id
     * @param id
     * @return
     */
    boolean delete(int id);

    /**
     * delete all meals for user
     * @param userId
     * @return
     */
    boolean deleteAllMeals(int userId);

    /**
     * get meal by its id
     * @param id
     * @return
     */
    UserMeal getMeal(int id);

    /**
     * get all meals
     * @return
     */
    List<UserMeal> getAllMeals(int userId);



}
