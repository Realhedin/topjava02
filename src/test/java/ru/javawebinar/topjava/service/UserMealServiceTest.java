package ru.javawebinar.topjava.service;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.MealTestData.*;
import ru.javawebinar.topjava.model.BaseEntity;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.DbPopulator;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static ru.javawebinar.topjava.MealTestData.*;

/**
 * Created by Dmitrii on 3/18/15.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMealServiceTest {

    @Autowired
    protected UserMealService service;

    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() throws Exception {
        dbPopulator.execute();
    }

    @After
    public void after() {
        System.out.println();
    }



    @Test
    public void testSave() throws Exception {
        TestMeal tm = new TestMeal(100000, LocalDateTime.now(), "break",100);
        UserMeal created = service.save(tm.asMeal(), 100000);
        tm.setId(created.getId());
        MATCHER.assertListEquals(Arrays.asList(tm, MEAL), service.getAll(100000));
    }


    @Test(expected = DataAccessException.class)
    public void testDuplicateMailSave() throws Exception {
        service.save(new TestMeal(1111, LocalDateTime.now(), "No user", 1111).asMeal(),1111);
    }

    @Test
    public void testDelete() throws Exception {
        service.save(new TestMeal(100001, LocalDateTime.now(), "for Delete", 1111).asMeal(),100001);
        System.out.println(service.get(BaseEntity.START_SEQ+4,100001).toString());
        service.delete(BaseEntity.START_SEQ+4,100001);
        MATCHER.assertListEquals(Collections.singletonList(MEAL_TO_DELETE), service.getAll(100001));
    }


    @Test(expected = NotFoundException.class)
    public void testDeleteForeign() throws Exception {
        service.delete(BaseEntity.START_SEQ+2,100001);
    }

    @Test
    public void testDeleteAll() throws Exception {
        service.deleteAll(100000);
        Assert.assertTrue(service.getAll(100000).size() == 0);
    }

    @Test
    public void testGet() throws Exception {
        MATCHER.assertEquals(MEAL_TO_DELETE,service.get(BaseEntity.START_SEQ+3,100001));
    }


    @Ignore
    @Test
    public void testGetForeign() throws Exception {
        MATCHER.assertEquals(MEAL_TO_DELETE,service.get(BaseEntity.START_SEQ+3,100000));
    }

    @Test
    public void testGetAll() throws Exception {
        TestMeal tm = new TestMeal(100000, LocalDateTime.now(), "break", 100);
        UserMeal created = service.save(tm.asMeal(), 100000);
        tm.setId(created.getId());
        MATCHER.assertListEquals(Arrays.asList(tm, MEAL), service.getAll(100000));
    }

    @Test
    public void testGetBetween() throws Exception {
        LocalDateTime now = LocalDateTime.now();
        List<UserMeal> meals = service.getBetween(now.minusDays(1),now.plusDays(1),100000);
        ArrayList<UserMeal> userMeals = new ArrayList<>();
        userMeals.add(MEAL);
        MATCHER.assertListEquals(userMeals,meals);
    }
}
