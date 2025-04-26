package org.example.dao;

import org.example.pojo.Student;

import java.util.List;

/**
 * @since: 2025/4/26 17:53
 * @author: qm
 * @description:
 */
public interface StudentDao {
    /**
     * 查询所有学生
     *
     * @return
     */
    List<Student> queryAll();
}
