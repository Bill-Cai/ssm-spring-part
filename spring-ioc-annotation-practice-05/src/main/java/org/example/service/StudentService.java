package org.example.service;

import org.example.pojo.Student;

import java.util.List;

/**
 * @since: 2025/4/29 19:14
 * @author: qingmu
 * @description:
 */
public interface StudentService {
    List<Student> findAll();
}
