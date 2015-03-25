package ru.javawebinar.topjava.repository.jpa;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.List;

/**
 * GKislin
 * 20.03.2015.
 */
@Repository
@Transactional(readOnly = true)
public class JpaUserMealRepositoryImpl implements UserMealRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public UserMeal save(UserMeal userMeal, int userId) {


        if (userMeal.isNew()) {
            User user = em.getReference(User.class, userId);
            userMeal.setUser(user);
            em.persist(userMeal);
        } else {
            //first variant - 2 requests to DB
//            UserMeal testMeal = (UserMeal) em.createNamedQuery(UserMeal.GET_MEAL_WITH_USER_BY_ID).setParameter("id", userMeal.getId()).getSingleResult();
//            if (testMeal.getUser().getId() == userId) {
//                testMeal.setCalories(userMeal.getCalories());
//                testMeal.setDateTime(userMeal.getDateTime());
//                testMeal.setDescription(userMeal.getDescription());
//                em.merge(testMeal);
                //second varian - 1 complex request
                if (em.createNamedQuery(UserMeal.UPDATE)
                        .setParameter("datetime",userMeal.getDateTime())
                        .setParameter("calories",userMeal.getCalories())
                        .setParameter("desc",userMeal.getDescription())
                        .setParameter("id",userMeal.getId())
                        .setParameter("userId",userId).executeUpdate() == 0) {
                    return null;
                }
//            } else {
//                throw new NotFoundException("User is wrong");
//            }
        }

        return userMeal;
    }

    @Override
    @Transactional
    public boolean delete(int id, int userId) {
        return em.createNamedQuery(UserMeal.DELETE).setParameter("id",id).setParameter("userId",userId).executeUpdate() != 0;
    }

    @Override
    public UserMeal get(int id, int userId) {
        List<UserMeal> resultList = (List<UserMeal>)em.createNamedQuery(UserMeal.GET_BY_ID).setParameter("id", id).setParameter("userId", userId).getResultList();
        return CollectionUtils.isEmpty(resultList) ? null : DataAccessUtils.requiredSingleResult(resultList);
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return em.createNamedQuery(UserMeal.GET_ALL, UserMeal.class).setParameter("userId",userId).getResultList();
    }

    @Override
    @Transactional
    public void deleteAll(int userId) {
//        TypedQuery<UserMeal> query = em.createQuery("DELETE FROM UserMeal um WHERE um.user.id=:userId", UserMeal.class);
//        query.setParameter("userId", userId).executeUpdate();
        em.createNamedQuery(UserMeal.DELETE_ALL).setParameter("userId",userId).executeUpdate();
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        return em.createNamedQuery(UserMeal.GET_BETWEEN)
                .setParameter("userId",userId)
                .setParameter("after",startDate)
                .setParameter("before",endDate).getResultList();
    }
}
