package org.example.service.impl;

import org.example.service.Calculator;
import org.springframework.stereotype.Component;

/**
 * @since: 2025/4/30 10:59
 * @author: qm
 * @description:
 */
@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
        try {
            System.out.println("Executing add method");
            int result = a + b;
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            System.out.println("Finally block executed");
        }
        return a + b;
    }

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public int mul(int a, int b) {
        return a * b;
    }

    @Override
    public int div(int a, int b) {
        return a / b;
    }
}
