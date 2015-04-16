package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ru.javawebinar.topjava.model.UserMeal;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Controller for UserMeal to get request from GUI
 *
 * GKislin
 * 06.03.2015.
 */
@RestController
@RequestMapping("/rest/meals")
public class UserMealRestController {


    @Autowired
    private MealHelper helper;

    /*
    * methods
    */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserMeal> create(@RequestBody UserMeal meal) {
        UserMeal created = helper.create(meal);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/rest/meal/{id}")
                .buildAndExpand(created.getId()).toUri();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriOfNewResource);

        return new ResponseEntity<>(created, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserMeal update(@RequestBody UserMeal meal, @PathVariable("id") int id) {
        return helper.update(meal);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        helper.delete(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAll() {
        helper.deleteAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserMeal get(@PathVariable("id") int id) {
        return helper.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserMeal> getAll() {
        return helper.getAll();
    }

    @RequestMapping(value = "/between", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
   public List<UserMeal> getBetween(@RequestParam("startDate") final LocalDateTime startDate,
                                    @RequestParam("endDate") final LocalDateTime endDate) {
//    public List<UserMeal> getBetween(@RequestParam("startDate")  String startDate, @RequestParam("endDate") String endDate) {
//        LocalDateTime sD = TimeUtil.toDateTime(startDate);
//        LocalDateTime eD = TimeUtil.toDateTime(endDate);
//        return helper.getBetween(sD,eD);
        return helper.getBetween(startDate,endDate);
    }

}
