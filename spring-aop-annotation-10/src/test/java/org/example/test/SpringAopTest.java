package org.example.test;

import org.example.config.JavaConfig;
import org.example.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @since: 2025/5/5 14:51
 * @author: qm
 * @description:
 */
@SpringJUnitConfig(value = JavaConfig.class)
public class SpringAopTest {
    // 这里一定要是接口类型
    @Autowired
    private Calculator calculator;

    @Test
    public void test() {
        int result = calculator.add(1, 2);
        System.out.println("Get result: " + result);
    }

    @Test
    public void test2() {
        int result = calculator.sub(1, 2);
        System.out.println("Get result: " + result);
    }

    @Test
    public void test3() {
        int result = calculator.div(1, 1);
        System.out.println("Get result: " + result);
    }
}
