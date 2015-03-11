package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.User;
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
    public boolean update(int id) {
        LOG.info("Meal was updated:" + id);
        return true;
    }

    @Override
    public boolean delete(int id) {
        LOG.info("Meal deleted: " + id);
        return true;
    }

    @Override
    public boolean deleteAllMeals(int userId) {
        LOG.info("All meals for user id:" +userId+ " were deleted");
        return true;
    }

    @Override
    public UserMeal getMeal(int id) {
        User user = new User();
        user.setId(0);
        UserMeal temp = new UserMeal("name",user,123,new Date(), new Date());
        LOG.info("Here is your meal: " + temp.getName());
        return temp;
    }

    @Override
    public List<UserMeal> getAllMeals(int userId) {
        List<UserMeal> list = new ArrayList<UserMeal>();
        ArrayList<UserMeal> userMeals = new ArrayList<>();
        User user = new User();
        user.setId(0);
        UserMeal salad1 = new UserMeal("salad",user, 1, new Date(),new Date());
        UserMeal salad2 = new UserMeal("soup", user,2, new Date(), new Date());
        user.setId(2);
        UserMeal salad3 = new UserMeal("second dish",user, 3, new Date(), new Date());
        list.add(salad1);
        list.add(salad2);
        list.add(salad3);

        for (UserMeal userMeal : list) {
           if (userMeal.getUser().getId() == userId) {
               userMeals.add(userMeal);
           }
        }

        LOG.info("List is: " + list);
        return list;
    }
}
