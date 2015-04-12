package ru.javawebinar.topjava.web.meal;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.model.BaseEntity;
import ru.javawebinar.topjava.web.WebTest;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static ru.javawebinar.topjava.Profiles.DATAJPA;
import static ru.javawebinar.topjava.Profiles.POSTGRES;
import static ru.javawebinar.topjava.model.BaseEntity.START_SEQ;

/**
 * Created by Dmitrii on 4/12/15.
 */
@ActiveProfiles(value = {POSTGRES, DATAJPA})
public class UserMealControllerTest extends WebTest {

    @Test
    public void testUserMealList() throws Exception {
        mockMvc.perform(get("/meals"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("mealList"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/mealList.jsp"))
                .andExpect(model().attribute("mealList", Matchers.hasSize(4)))
                .andExpect(model().attribute("mealList", Matchers.hasItem(
                        allOf(
                                hasProperty("id", is(START_SEQ + 2)),
                                hasProperty("description", is("breakfast"))

                        )
                )))
                .andExpect(model().attribute("mealList", Matchers.hasItem(
                        allOf(
                                hasProperty("id", is(START_SEQ+5)),
                                hasProperty("dateTime", is(LocalDateTime.of(2015, 1, 7, 13, 0))),
                                hasProperty("calories", is(1300))
                         )
                )))
        ;
    }


    @Test
    public void getById() throws Exception {
        mockMvc.perform(get("/meals/{id}", BaseEntity.START_SEQ + 2))
                .andExpect(status().isOk())
                .andExpect(view().name("mealList"))
                .andExpect(forwardedUrl("/WEB-INF/jsp/mealList.jsp"))
                .andExpect(model().attribute("meal", hasProperty("id", is(START_SEQ + 2))))
                .andExpect(model().attribute("meal", hasProperty("description", is("breakfast"))))
                .andExpect(model().attribute("meal", hasProperty("dateTime", is(LocalDateTime.of(2015, 1, 6, 9, 0)))));
    }

}
