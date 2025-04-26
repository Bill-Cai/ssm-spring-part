package org.example.service;

import org.example.pojo.Student;

import java.util.List;

/**
 * @since: 2025/4/26 17:57
 * @author: qm
 * @description:
 */
public interface StudentService {
    /**
     * 查询所有学生
     *
     * @return
     */
    List<Student> findAll();
}
