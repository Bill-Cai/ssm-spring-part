package org.example.ioc;

import org.example.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @since: 2025/4/29 19:22
 * @author: qingmu
 * @description:
 */
public class SpringIoCTest {
    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        StudentController bean = applicationContext.getBean(StudentController.class);
        bean.findAll();
    }
}
