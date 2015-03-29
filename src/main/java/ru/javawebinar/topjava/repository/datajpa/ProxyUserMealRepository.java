package ru.javawebinar.topjava.repository.datajpa;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Dmitrii on 3/29/15.
 */
public interface ProxyUserMealRepository extends JpaRepository<UserMeal, Integer> {


    @Override
    UserMeal save(UserMeal userMeal);
//    @Transactional
//    @Modifying
//    @Query()
//    UserMeal save(@Param("userMeal") UserMeal userMeal, @Param("userId") int userId);


    //List<UserMeal> findAll(Sort sort);
    @Query("SELECT m FROM UserMeal m WHERE m.user.id=:userId ORDER BY m.dateTime DESC")
    List<UserMeal> getAll(@Param("userId") int userId);
    //    @Query(UserMeal.ALL_SORTED)
//    List<UserMeal> getAll(@Param("userId") int userId);


    @Query("SELECT m FROM UserMeal m WHERE m.id=:id and m.user.id=:userId")
    UserMeal getByIdAndUser(@Param("id") int id, @Param("userId") int userId);


    @Transactional
    @Modifying
//    @Query(UserMeal.DELETE)
      @Query("DELETE FROM UserMeal m WHERE m.id=:id AND m.user.id=:userId")
    int delete(@Param("id")int id, @Param("userId")int userId);


    @Transactional
    @Modifying
    @Query("DELETE FROM UserMeal i WHERE i.user.id=:userId")
    void deleteAll(@Param("userId") int userId);


    @Query("SELECT m from UserMeal m WHERE m.user.id=:userId AND m.dateTime>=:after and m.dateTime<:before ORDER BY m.dateTime DESC")
    List<UserMeal> getBetween(@Param("after") LocalDateTime startDate, @Param("before") LocalDateTime endDate, @Param("userId") int userId);
}
