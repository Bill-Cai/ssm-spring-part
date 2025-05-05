package org.example.service;

import org.example.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @since: 2025/5/5 20:59
 * @author: qingmu
 * @description:
 */
@Service
public class TopService {
    @Autowired
    private StudentService studentService;

    @Transactional
    public void topService() {
        studentService.changeAge();
        studentService.changeName();
    }
}
