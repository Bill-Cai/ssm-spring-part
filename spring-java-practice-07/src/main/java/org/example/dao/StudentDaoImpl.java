package org.example.dao;

import org.example.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @since: 2025/4/29 19:08
 * @author: qingmu
 * @description:
 */
@Repository
public class StudentDaoImpl implements StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> queryAll() {
        String sql = "select id,name,age,gender,class as classes from students";
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        return studentList;
    }
}
