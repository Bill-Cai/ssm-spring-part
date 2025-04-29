package org.example.dao;

import org.example.pojo.Student;

import java.util.List;

/**
 * @since: 2025/4/29 19:07
 * @author: qingmu
 * @description:
 */
public interface StudentDao {
    List<Student> queryAll();
}
