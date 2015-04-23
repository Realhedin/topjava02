package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Dmitrii on 4/23/15.
 */
@RestController
@RequestMapping("/ajax/meals")
public class UserMealAjaxController {

    @Autowired
    private UserMealHelper helper;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserMeal> getAll() {
        return helper.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        helper.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void update(@RequestParam("item_id") int id,
                       @RequestParam("description") String description,
                       @RequestParam("calories") int calories) {
        if (id == 0) {
            UserMeal meal = new UserMeal(null, LocalDateTime.now(),description,calories);
            helper.create(meal);
        } else {
            UserMeal meal = new UserMeal(id,LocalDateTime.now(),description,calories);
            helper.update(meal,id);
        }
    }
}
