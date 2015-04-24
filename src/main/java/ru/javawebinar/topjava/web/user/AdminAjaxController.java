package ru.javawebinar.topjava.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.UserService;
import ru.javawebinar.topjava.to.UserTo;

import java.util.List;

/**
 * User: javawebinar.topjava
 */
@RestController
@RequestMapping("/ajax/admin/users")
public class AdminAjaxController {

    @Autowired
    private UserHelper helper;

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getAll() {
        return helper.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User get(@PathVariable("id") int id) {
        return helper.get(id);
    }

    @RequestMapping(value = "/{id}/enable", method = RequestMethod.POST)
    public void updateValue(@PathVariable("id") int id, @RequestParam("enabled") boolean enabled) {
        helper.enable(id, enabled);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        helper.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void update(UserTo userTo) {
        service.save(userTo);
    }
}
