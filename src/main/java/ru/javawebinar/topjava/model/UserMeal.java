package ru.javawebinar.topjava.model;

import java.util.Date;

/**
 * GKislin
 * 06.03.2015.
 */
public class UserMeal extends BaseEntity {

    private String name;

    private int calories;

    private Date date;


    public UserMeal() {
    }

    public UserMeal(String name, int calories, Date date) {
        this.name = name;
        this.calories = calories;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
