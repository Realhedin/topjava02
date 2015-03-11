package ru.javawebinar.topjava.model;

import java.util.Date;

/**
 * Entity for Meal
 *
 * GKislin
 * 06.03.2015.
 */
public class UserMeal extends BaseEntity {

    private String name;

    private User user;

    private int calories;

    private Date fromDate;

    private Date toDate;


    public UserMeal() {
    }

    public UserMeal(String name, User user, int calories, Date fromDate, Date toDate) {
        this.name = name;
        this.user = user;
        this.calories = calories;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
