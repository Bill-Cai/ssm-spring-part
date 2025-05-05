package org.example.test;

import org.example.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @since: 2025/5/5 17:02
 * @author: qm
 * @description:
 */
@SpringJUnitConfig(locations = "classpath:spring.xml")
public class SpringAopTest {
    @Autowired
    private Calculator calculator;

    @Test
    public void test() {
        int result = calculator.add(1, 2);
        System.out.println("Result: " + result);
    }
}
