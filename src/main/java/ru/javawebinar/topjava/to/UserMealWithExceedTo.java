package ru.javawebinar.topjava.to;

import ru.javawebinar.topjava.model.UserMeal;

/**
 * Created by Dmitrii on 5/12/15.
 */
public class UserMealWithExceedTo extends UserMeal {
    protected boolean exceed;

    public boolean isExceed() {
        return exceed;
    }

    public void setExceed(boolean exceed) {
        this.exceed = exceed;
    }
}
