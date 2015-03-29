package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Dmitrii on 3/29/15.
 */
public interface ProxyUserMealRepository extends JpaRepository<UserMeal, Integer> {

    /**
     * save or update method
     * @param userMeal - our new/existed meal
     * @return this meal
     */
    @Override
    UserMeal save(UserMeal userMeal);


    /**
     * get all userMeals by userId
     * @param user - User entity
     * @return list of UserMeal entities
     */
    //var 1 - use Query
//    @Query("SELECT m FROM UserMeal m WHERE m.user.id=:userId ORDER BY m.dateTime DESC")
//    List<UserMeal> getAll(@Param("userId") int userId);
    //var 2 - use JpaRepository method
//    List<UserMeal> findAllByUserOrderByDateTimeDesc(User user);
    //var 3 - use JpaRepository + sort
      List<UserMeal> findAllByUser(User user, Sort sort);


    /**
     * get meal by its id and userId
     * @param id - id of meal
     * @param userId - id of user
     * @return this userMeal
     */
        //var 1 - use Query
    @Query("SELECT m FROM UserMeal m WHERE m.id=:id and m.user.id=:userId")
    UserMeal getByIdAndUser(@Param("id") int id, @Param("userId") int userId);
        //var2 - use JpaRepository method
//      UserMeal getByIdAndUser(int id, User user);


    /**
     * delete userMeal by its id
     * @param id
     * @param userId
     * @return int: 1 - success, 0 - fault
     */
    @Transactional
    @Modifying
      @Query("DELETE FROM UserMeal m WHERE m.id=:id AND m.user.id=:userId")
    int delete(@Param("id")int id, @Param("userId")int userId);


    /**
     * delete all userMeals for current User
     * @param userId - - id of user
     */
    @Transactional
    @Modifying
    @Query("DELETE FROM UserMeal i WHERE i.user.id=:userId")
    void deleteAll(@Param("userId") int userId);


    /**
     * get list of UserMeal for current user entities between 2 dates
     * @param startDate - after this date
     * @param endDate - before this date
     * @param userId - - id of user
     * @return list of userMeals
     */
    @Query("SELECT m from UserMeal m WHERE m.user.id=:userId AND m.dateTime>=:after and m.dateTime<:before ORDER BY m.dateTime DESC")
    List<UserMeal> getBetween(@Param("after") LocalDateTime startDate, @Param("before") LocalDateTime endDate, @Param("userId") int userId);
}
