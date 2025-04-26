package org.example.service;

import org.example.dao.StudentDao;
import org.example.pojo.Student;

import java.util.List;

/**
 * @since: 2025/4/26 18:00
 * @author: qm
 * @description:
 */
public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        List<Student> studentList = studentDao.queryAll();
        System.out.println("studentService: " + studentList);
        return studentList;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
