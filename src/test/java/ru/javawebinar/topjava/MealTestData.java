package ru.javawebinar.topjava;

import ru.javawebinar.topjava.matcher.ModelMatcher;
import ru.javawebinar.topjava.model.BaseEntity;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.TimeUtil;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.function.Function;

/**
 * GKislin
 * 13.03.2015.
 */
public class MealTestData {
    
    private static final LoggerWrapper LOG = LoggerWrapper.get(MealTestData.class);

    public static final UserMeal MEAL = new UserMeal(BaseEntity.START_SEQ+2,  LocalDateTime.now(), 100000,  "soup", 123);

    public static final UserMeal MEAL_TO_DELETE = new UserMeal(BaseEntity.START_SEQ+3,  LocalDateTime.now(), 100001, "salad", 321);

    public static final ModelMatcher<UserMeal, String> MATCHER = new ModelMatcher<>(
            new Function<UserMeal, String>() {
                @Override
                public String apply(UserMeal meal) {
                    return meal.toString();
                }
            });

}
