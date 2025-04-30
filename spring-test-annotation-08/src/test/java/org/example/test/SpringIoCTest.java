package org.example.test;

import org.example.components.A;
import org.example.config.JavaConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @since: 2025/4/30 10:44
 * @author: qm
 * @description:
 */
@SpringJUnitConfig(value = {JavaConfig.class})
public class SpringIoCTest {
    @Autowired
    private A a;

    @Test
    public void test() {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
//        A a = context.getBean(A.class);
//        System.out.println(a);

        System.out.println(a);
    }
}
