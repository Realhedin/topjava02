package ru.javawebinar.topjava.web.mock;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.exception.NotFoundException;
import ru.javawebinar.topjava.web.meal.UserMealRestController;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * Created by Dmitrii on 3/14/15.
 */
public class UserMealMockTest {
    private static ConfigurableApplicationContext context;
    private static UserMealRestController controller;

    @BeforeClass
    public static void beforeClass() {
        context = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println("\n" + Arrays.toString(context.getBeanDefinitionNames()) + "\n");
        controller = context.getBean(UserMealRestController.class);
    }

    @AfterClass
    public static void afterClass() {
        context.close();
    }


    @Test
    public void mealCreate() {
        UserMeal meal = controller.create(new UserMeal(LoggedUser.id(), LocalDateTime.now(), "soup", 1 ));
        Assert.assertEquals(meal,new UserMeal(LoggedUser.id(), LocalDateTime.now(), "soup", 3 ));
        System.out.println();
    }

    @Test(expected = AssertionError.class)
    public void mealCreateFalse() {
        UserMeal meal = controller.create(new UserMeal(LoggedUser.id(), LocalDateTime.now(), "soup", 1 ));
        meal.setId(3);
        Assert.assertEquals(meal,new UserMeal(LoggedUser.id(), LocalDateTime.now(), "soup", 3 ));
        System.out.println();
    }

    @Test
    public void mealGet() {
        UserMeal meal = controller.get(0);
        Assert.assertEquals((long)meal.getId(),0);
        System.out.println();
    }

    @Test(expected = NotFoundException.class)
    public void mealGet2() {
        UserMeal meal = controller.get(1);
        Assert.assertEquals((long)meal.getId(),0);
        System.out.println();
    }

}
