package org.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @since: 2025/5/5 19:28
 * @author: qingmu
 * @description:
 */
@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void updateNameById(String name, Integer id) {
        String sql = "update students set name = ? where id = ?";
        jdbcTemplate.update(sql, name, id);
    }

    public void updateAgeById(Integer age, Integer id) {
        String sql = "update students set age = ? where id = ?";
        jdbcTemplate.update(sql, age, id);
    }

    public String getNameById(Integer id) {
        String sql = "select name from students where id = ?";
        return jdbcTemplate.queryForObject(sql, String.class, id);
    }
}
