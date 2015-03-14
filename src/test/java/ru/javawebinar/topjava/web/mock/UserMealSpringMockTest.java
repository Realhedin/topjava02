package ru.javawebinar.topjava.web.mock;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.model.TestTimedOutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.exception.NotFoundException;
import ru.javawebinar.topjava.web.meal.UserMealRestController;

import java.time.LocalDateTime;

/**
 * Created by Dmitrii on 3/14/15.
 */
@ContextConfiguration("classpath:spring/spring-app.xml")
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMealSpringMockTest {

    @Autowired
    private UserMealRestController controller;


    @Before
    public void before() {
        System.out.println("Test begins...");
    }

    @After
    public void after() {
        System.out.println("Test end.\n" );
    }



    @Test
    public void mealCreate() {
        UserMeal meal = controller.create(new UserMeal(LoggedUser.id(), LocalDateTime.now(), "soup", 1 ));
        Assert.assertEquals(meal, new UserMeal(LoggedUser.id(), LocalDateTime.now(), "soup", 3));
    }

    @Test(expected = AssertionError.class)
    public void mealCreateFalse() {
        UserMeal meal = controller.create(new UserMeal(LoggedUser.id(), LocalDateTime.now(), "soup", 1 ));
        meal.setId(3);
        Assert.assertEquals(meal, new UserMeal(LoggedUser.id(), LocalDateTime.now(), "soup", 3));
    }

    @Test(timeout = 1000)
    public void mealGet() {
        UserMeal meal = controller.get(0);
        Assert.assertEquals((long) meal.getId(), 0);
    }

    @Test(expected = NotFoundException.class)
    public void mealGet2() {
        UserMeal meal = controller.get(1);
        Assert.assertEquals((long) meal.getId(), 0);
    }

    @Ignore
    @Test(timeout = 1000)
    public void infinityTest() {
        while (true);
    }

}
