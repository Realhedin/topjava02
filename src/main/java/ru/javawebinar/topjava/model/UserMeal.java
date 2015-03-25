package ru.javawebinar.topjava.model;

import org.hibernate.validator.constraints.NotEmpty;
import ru.javawebinar.topjava.util.TimeUtil;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * GKislin
 * 06.03.2015.
 */
@Entity
@Table(name = "MEALS")
@NamedQueries({
        @NamedQuery(name = "UserMeal.getById",
                query = "select um from UserMeal um where um.id=:id and um.user.id=:userId"),
        @NamedQuery(name = "UserMeal.delete",
                query = "delete from UserMeal um where um.id=:id and um.user.id=:userId"),
        @NamedQuery(name = "UserMeal.deleteAll",
                query = "delete from UserMeal um where um.user.id=:userId"),
        @NamedQuery(name = "UserMeal.getAllByUserId",
                query = "select um from UserMeal um where um.user.id=:userId order by um.dateTime desc"),
        @NamedQuery(name = "UserMeal.getBetween",
                query = "select um from UserMeal um where um.user.id=:userId and um.dateTime>=:after" +
                        " and um.dateTime<:before order by um.dateTime desc"),
        @NamedQuery(name = "UserMeal.getMealWithUser",
                query = "select um from UserMeal um LEFT JOIN FETCH um.user where um.id=:id")
})
public class UserMeal extends BaseEntity {

    public static final String GET_BY_ID =  "UserMeal.getById";
    public static final String DELETE = "UserMeal.delete";
    public static final String DELETE_ALL = "UserMeal.deleteAll";
    public static final String GET_ALL = "UserMeal.getAllByUserId";
    public static final String SAVE = "UserMeal.save";
    public static final String GET_BETWEEN = "UserMeal.getBetween";
    public static final String GET_MEAL_WITH_USER_BY_ID = "UserMeal.getMealWithUser";

    @Column(name = "datetime", columnDefinition =  "timestamp default now()")
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    protected LocalDateTime dateTime;

    @Column(name = "description")
    protected String description;

    @Column(name = "calories")
    protected int calories;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    @NotEmpty
    private User user;

    public UserMeal() {
    }

    public UserMeal(UserMeal meal) {
        this(meal.id, meal.dateTime, meal.description, meal.calories);
    }

    public UserMeal(Integer id, LocalDateTime dateTime, String description, int calories) {
        super(id);
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String meal) {
        this.description = meal;
    }

    public int getCalories() {
        return calories;
    }

    public User getUser() {
        return user;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Meal(" + id + ", " + TimeUtil.toString(dateTime) + ", '" + description + "', calories:" + calories + ')';
    }

    public void setUser(User user) {
        this.user = user;
    }


}



