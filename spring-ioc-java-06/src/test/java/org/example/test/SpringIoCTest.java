package org.example.test;

import org.example.config.JavaConfiguration;
import org.example.config.JavaConfigurationA;
import org.example.config.JavaConfigurationB;
import org.example.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @since: 2025/4/29 19:41
 * @author: qingmu
 * @description:
 */
public class SpringIoCTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        StudentController studentController = context.getBean(StudentController.class);
        System.out.println(studentController);
    }

    @Test
    public void testMultiConfiguration() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(JavaConfigurationA.class);
        JavaConfigurationA beanA = annotationConfigApplicationContext.getBean(JavaConfigurationA.class);
        System.out.println(beanA.beanA());
        JavaConfigurationB beanB = annotationConfigApplicationContext.getBean(JavaConfigurationB.class);
        System.out.println(beanB.beanB());
    }
}
