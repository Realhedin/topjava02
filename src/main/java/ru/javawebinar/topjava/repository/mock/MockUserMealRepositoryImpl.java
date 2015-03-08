package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* Mock file for UserMeal test work of layers
*
* Created by Dmitrii on 3/7/15.
*/
@Repository
public class MockUserMealRepositoryImpl implements UserMealRepository {

    private static final LoggerWrapper LOG = LoggerWrapper.get(MockUserMealRepositoryImpl.class);

    @Override
    public UserMeal save(UserMeal meal) {
        LOG.info("Meal saved: " + meal);
        return meal;
    }

    @Override
    public boolean delete(int id) {
        LOG.info("Meal deleted");
        return true;
    }

    @Override
    public UserMeal getMeal(int id) {
        UserMeal temp = new UserMeal("name",123,new Date());
        LOG.info("Here is your meal: " + temp.getName());
        return temp;
    }

    @Override
    public List<UserMeal> getAllMeals() {
        List<UserMeal> list = new ArrayList<>();
        list.add(new UserMeal("salad",1,new Date()));
        list.add(new UserMeal("soup",2,new Date()));
        list.add(new UserMeal("second dish",3,new Date()));
        LOG.info("List is: " + list);
        return list;
    }
}
