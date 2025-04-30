package org.example.statics;

import org.example.util.Calculator;

/**
 * @since: 2025/4/30 11:23
 * @author: qm
 * @description:
 */
public class StaticProxyCalculator implements Calculator {
    private Calculator calculator;

    public StaticProxyCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int a, int b) {
        System.out.println("add");
        System.out.println("a = " + a + ", b = " + b);
        int result = calculator.add(a, b);
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int sub(int a, int b) {
        System.out.println("sub");
        System.out.println("a = " + a + ", b = " + b);
        int result = calculator.sub(a, b);
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int mul(int a, int b) {
        System.out.println("mul");
        System.out.println("a = " + a + ", b = " + b);
        int result = calculator.mul(a, b);
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int div(int a, int b) {
        System.out.println("div");
        System.out.println("a = " + a + ", b = " + b);
        int result = calculator.div(a, b);
        System.out.println("result = " + result);
        return result;
    }
}
