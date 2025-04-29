package org.example.ioc_01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @since: 2025/4/29 19:35
 * @author: qingmu
 * @description:
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
}
