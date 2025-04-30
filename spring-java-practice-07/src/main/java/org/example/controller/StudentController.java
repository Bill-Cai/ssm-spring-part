package org.example.controller;

import org.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @since: 2025/4/29 19:16
 * @author: qingmu
 * @description:
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    public void findAll() {
        System.out.println(studentService.findAll());
    }
}
