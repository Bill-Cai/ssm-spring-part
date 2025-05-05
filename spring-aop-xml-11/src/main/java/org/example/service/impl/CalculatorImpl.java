package org.example.service.impl;

import org.example.service.Calculator;
import org.springframework.stereotype.Component;

/**
 * @since: 2025/5/5 16:51
 * @author: qm
 * @description:
 */
@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int a, int b) {
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
