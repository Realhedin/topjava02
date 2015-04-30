package ru.javawebinar.topjava.web.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.service.UserService;
import ru.javawebinar.topjava.to.UserTo;
import ru.javawebinar.topjava.util.PasswordUtil;

import java.util.List;

/**
 * User: gkislin
 */
@Component
public class UserHelper {
    private static final LoggerWrapper LOG = LoggerWrapper.get(UserHelper.class);

    @Autowired
    private UserService service;

    public List<User> getAll() {
        LOG.info("getAll");
        List<User> all = service.getAll();
        all.forEach(u -> u.setPassword(null));
        return all;
    }

    public User get(int id) {
        LOG.info("get " + id);
        User user = service.get(id);
        user.setPassword(null);
        return user;
    }

    public User create(User user) {
        LOG.info("create " + user);
        return service.save(PasswordUtil.getEncoded(user));
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        service.delete(id);
    }

    public void update(User user, int id) {
        LOG.info("update " + user);
        user.update(id);
        service.update(PasswordUtil.getEncoded(user));
    }

    public User getByMail(String email) {
        LOG.info("getByEmail " + email);
        return service.getByEmail(email);
    }

    public void enable(int id, boolean enable) {
        LOG.info("enable " + id);
        service.enable(id, enable);
    }

    public static User updateUser(User oldUser, User user) {
        oldUser.setName(user.getName());
        oldUser.setEmail(user.getEmail().toLowerCase());
        if (user.getPassword() != null) {
            oldUser.setPassword(user.getPassword());
        }
        oldUser.setRoles(user.getRoles());
        oldUser.setEnabled(user.isEnabled());
        return user;
    }

    public static User updateUser(User oldUser, UserTo userTo) {
        PasswordUtil.getEncoded(userTo);
        oldUser.setName(userTo.getName());
        oldUser.setEmail(userTo.getEmail().toLowerCase());
        oldUser.setPassword(userTo.getPassword());
        return oldUser;
    }

    public static User asNewUser(UserTo userTo) {
        PasswordUtil.getEncoded(userTo);
        return new User(null, userTo.getName(), userTo.getEmail().toLowerCase(), userTo.getPassword(), true, Role.ROLE_USER);
    }
}
