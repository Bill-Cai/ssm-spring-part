package org.example.controller;

import org.example.pojo.Student;
import org.example.service.StudentService;

import java.util.List;

/**
 * @since: 2025/4/26 18:02
 * @author: qm
 * @description:
 */
public class StudentController {
    private StudentService studentService;


    public void findAll() {
        List<Student> studentList = studentService.findAll();
        System.out.println("studentController: " + studentList);
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
}
