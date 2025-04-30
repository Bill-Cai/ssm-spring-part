package org.example;

import org.example.config.JavaConfig;
import org.example.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @since: 2025/4/30 10:28
 * @author: qm
 * @description:
 */
public class SpringIoCTest {
    @Test
    public void test(){
        // 1. 创建Spring容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaConfig.class);
        // 2. 获取StudentController对象
        StudentController studentController = applicationContext.getBean("studentController", StudentController.class);
        // 3. 调用方法
        studentController.findAll();
    }
}
