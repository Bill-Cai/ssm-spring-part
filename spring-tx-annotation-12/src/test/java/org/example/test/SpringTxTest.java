package org.example.test;

import org.example.config.JavaConfig;
import org.example.service.StudentService;
import org.example.service.TopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.io.FileNotFoundException;

/**
 * @since: 2025/5/5 19:32
 * @author: qingmu
 * @description:
 */
@SpringJUnitConfig(JavaConfig.class)
public class SpringTxTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void test() {
        studentService.changeInfo();
    }

    @Test
    public void test2() {
        studentService.getInfo();
    }

    @Test
    public void test3() {
        studentService.getInfoTimeout();
    }

    @Test
    public void test4() throws FileNotFoundException {
        studentService.tryException();
    }

    @Autowired
    private TopService topService;

    @Test
    public void test5() {
        topService.topService();
    }
}
