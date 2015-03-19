package ru.javawebinar.topjava.repository.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * User: gkislin
 * Date: 26.08.2014
 */

@Repository
public class JdbcUserMealRepositoryImpl implements UserMealRepository {

    private static final BeanPropertyRowMapper<UserMeal> ROW_MAPPER = BeanPropertyRowMapper.newInstance(UserMeal.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    private SimpleJdbcInsert insertMeal;

    @Autowired
    public JdbcUserMealRepositoryImpl(DataSource dataSource) {
        this.insertMeal = new SimpleJdbcInsert(dataSource)
                .withTableName("MEALS")
                .usingGeneratedKeyColumns("id");
    }


    @Override
    public UserMeal save(UserMeal UserMeal, int userId) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", UserMeal.getId())
                .addValue("user_id", userId)
                .addValue("datetime", UserMeal.getDateTime())
                .addValue("description", UserMeal.getDescription())
                .addValue("calories", UserMeal.getCalories())
                ;

        if (UserMeal.isNew()) {
            Number newKey = insertMeal.executeAndReturnKey(map);
            UserMeal.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update(
                    "UPDATE meals SET user_id=:user_id, datetime=:datetime, description=:description, calories=:calories" +
                            " WHERE id=:id and user_id=:user_id", map);
        }

        return UserMeal;
    }

    @Override
    public boolean delete(int id, int userId) {
        return jdbcTemplate.update("DELETE FROM MEALS WHERE id=? and user_id=?",id,userId) != 0;
    }

    @Override
    public UserMeal get(int id, int userId) {
        return jdbcTemplate.queryForObject("SELECT id, datetime, description, calories FROM MEALS WHERE id=? and user_id=?",ROW_MAPPER,id,userId);
    }

    @Override
    public List<UserMeal> getAll(int userId) {
        return jdbcTemplate.query("SELECT id, user_id ,datetime, description, calories FROM meals WHERE user_id=? ORDER BY datetime desc",ROW_MAPPER, userId);
    }

    @Override
    public void deleteAll(int userId) {
        jdbcTemplate.update("DELETE FROM MEALS WHERE user_id=?",userId);
    }

    @Override
    public List<UserMeal> getBetween(LocalDateTime startDate, LocalDateTime endDate, int userId) {
        Timestamp sD = Timestamp.valueOf(startDate);
        Timestamp eD = Timestamp.valueOf(endDate);
        return jdbcTemplate.query("SELECT id,user_id,datetime,description,calories FROM meals " +
                "WHERE datetime<? and datetime>? and user_id=? ORDER BY datetime desc", ROW_MAPPER, eD, sD, userId);
    }
}
