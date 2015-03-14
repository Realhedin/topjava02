package ru.javawebinar.topjava.repository.mock;

import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.LocalDateTime;
import java.util.List;

/**
 * GKislin
 * 09.03.2015.
 */
@Repository
public class MockUserMealRepositoryImpl implements UserMealRepository {

    private static final LoggerWrapper LOG = LoggerWrapper.get(MockUserMealRepositoryImpl.class);

    @PostConstruct
    public void postConstruct() {
        LOG.info("PostConstruct");
    }

    @PreDestroy
    public void preDestroy() {
        LOG.info("PreDestroy");
    }


    @Override
    public UserMeal save(UserMeal userMeal, int userId) {
        LOG.info("save: " + userMeal + userId );
        return userMeal;
    }

    @Override
    public boolean delete(int id, int userId) {
        LOG.info("delete "+userId +id);
        return true;
    }

    @Override
    public UserMeal get(int id, int userId) {
        LOG.info("get: " + id + userId);
        if (id == 0) {
            return new UserMeal(0,LocalDateTime.now(), "salad", 104);
        } else {
            return null;
        }
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        LOG.info("getAll: " + userId);
        return null;
    }

    @Override
    public void deleteAll(int userId) {
        LOG.info("deleteAll: " + userId);
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        LOG.info("getBetween time : "+startDate +"  "+endDate);
        return null;
    }
}
