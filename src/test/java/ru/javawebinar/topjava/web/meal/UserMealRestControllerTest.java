package ru.javawebinar.topjava.web.meal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.MealTestData;
import ru.javawebinar.topjava.model.BaseEntity;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserMealService;
import ru.javawebinar.topjava.web.WebTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.javawebinar.topjava.Profiles.DATAJPA;
import static ru.javawebinar.topjava.Profiles.HSQLDB;

/**
 * Created by Dmitrii on 4/15/15.
 */
@ActiveProfiles({HSQLDB, DATAJPA})
public class UserMealRestControllerTest extends WebTest{

    public static final String REST_URL = "/rest/meals/";

    @Autowired
    UserMealService service;

    @Test
    public void testCreate() throws Exception {
        //Realize
    }

    @Test
    public void testUpdate() throws Exception {
        //realize
    }

    @Test
    public void testDelete() throws Exception {
        List<UserMeal> meals = new ArrayList<UserMeal>();
        meals.add(MealTestData.MEAL2);
        meals.add(MealTestData.MEAL3);
        meals.add(MealTestData.MEAL4);
        Collections.reverse(meals);
        mockMvc.perform(MockMvcRequestBuilders.delete(REST_URL + (BaseEntity.START_SEQ + 2)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
                MealTestData.MATCHER.assertListEquals(meals, service.getAll(LoggedUser.id()));
    }

    @Test
    public void testDeleteAll() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete(REST_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
                MealTestData.MATCHER.assertListEquals(new ArrayList<UserMeal>(),service.getAll(LoggedUser.id()));
    }

    @Test
    public void testGet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(REST_URL + (BaseEntity.START_SEQ + 2)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8"))
              //  .andExpect(MockMvcResultMatchers.content().encoding("UTF-8"))
                .andExpect(MealTestData.MATCHER.contentMatcher(MealTestData.MEAL1));
    }

    @Test
    public void testGetAll() throws Exception {
        List<UserMeal> meals = new ArrayList<UserMeal>();
        meals.add(MealTestData.MEAL1);
        meals.add(MealTestData.MEAL2);
        meals.add(MealTestData.MEAL3);
        meals.add(MealTestData.MEAL4);
        meals.add(MealTestData.ADMIN_MEAL);
        mockMvc.perform(MockMvcRequestBuilders.get(REST_URL))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_VALUE+";charset=UTF-8"))
                .andExpect(MealTestData.MATCHER.contentListMatcher(MealTestData.MEAL4, MealTestData.MEAL3, MealTestData.MEAL2,MealTestData.MEAL1));
    }

    @Test
    public void testGetBetween() throws Exception {
        //?
    }
}
