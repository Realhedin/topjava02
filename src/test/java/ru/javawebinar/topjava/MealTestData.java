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

    public static final TestMeal MEAL = new TestMeal(BaseEntity.START_SEQ+2, 100000, LocalDateTime.now(), "soup", 123);

    public static class TestMeal extends UserMeal {

        public TestMeal(UserMeal u) {
            this(u.getId(), u.getUserId(), null, u.getDescription(), u.getCalories());
        }

        public TestMeal(Integer id, Integer userId, String desc, int calories) {
            this(id, userId,null, desc, calories);
        }

        public TestMeal(Integer userId, String desc, int calories) {
            this(null,userId,null,desc,calories);
        }

        public TestMeal(Integer userId, LocalDateTime dateTime, String desc, int calories) {
            this(null, userId, dateTime, desc, calories);
        }

        public TestMeal(Integer id, Integer userId, LocalDateTime dateTime, String desc, int calories) {
            super(id, userId, dateTime, desc, calories);
        }


        public UserMeal asMeal() {
            return new UserMeal(this);
        }

        @Override
        public String toString() {
            return "Meal(" + id + ", " + TimeUtil.toString(dateTime) + ", '" + description + "', calories:" + calories + ')';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TestMeal that = (TestMeal) o;

            return Objects.equals(this.description, that.description)
                    && Objects.equals(this.id, that.id)
                    && Objects.equals(this.calories, that.calories)
                    && Objects.equals(this.id, that.id)
                    && Objects.equals(this.getUserId(), that.getUserId());
        }
    }

    public static final ModelMatcher<UserMeal, String> MATCHER = new ModelMatcher<>(
            new Function<UserMeal, String>() {
                @Override
                public String apply(UserMeal meal) {
                    return meal.toString();
                }
            });

}
