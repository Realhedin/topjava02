package ru.javawebinar.topjava.service;


import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.to.UserTo;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.List;

/**
 * Service interface for User
 *
 * User: gkislin
 * Date: 22.08.2014
 */
public interface UserService {

    public User save(User user);

    public void delete(int id) throws NotFoundException;

    public User get(int id) throws NotFoundException;

    public User getByEmail(String email) throws NotFoundException;

    public List<User> getAll();

    public void update(User user) throws NotFoundException;

    public void update(UserTo user) throws NotFoundException;

    public void evictCache();

    void enable(int id, boolean enable);
}
