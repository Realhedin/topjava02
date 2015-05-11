package ru.javawebinar.topjava.web.meal;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.to.DateTimeFilter;
import ru.javawebinar.topjava.util.TimeUtil;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

/**
 * User: javawebinar.topjava
 */
@RestController
@RequestMapping("/ajax/profile/meals")
public class UserMealAjaxController extends AbstractMealController {

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserMeal> getAll() {
        return super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        super.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> update(@Valid UserMeal meal, BindingResult result) {
        if (result.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            result.getFieldErrors().forEach(fe -> sb.append(fe.getField()).append(" ").append(fe.getDefaultMessage()).append("<br>"));
            return new ResponseEntity<>(sb.toString(), HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            if (meal.getId() == 0) {
                super.create(meal);
            } else {
                super.update(meal, meal.getId());
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserMeal get(@PathVariable("id") int id) {
        return super.get(id);
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserMeal> filterList(DateTimeFilter filter) {
        if (StringUtils.isEmpty(filter.getStartDate()) || StringUtils.isEmpty(filter.getEndDate())) {
            return super.getAll();
        }

        if (StringUtils.isEmpty(filter.getStartTime())) {
            filter.setStartTime("00:00");
        }
        LocalDateTime start = TimeUtil.toDateTime(filter.getStartDate() + " " + filter.getStartTime());
        if (StringUtils.isEmpty(filter.getEndTime())) {
            filter.setEndTime("00:00");
        }
        LocalDateTime end = TimeUtil.toDateTime(filter.getEndDate() + " " + filter.getEndTime());
        return super.getBetween(start, end);
    }

}
