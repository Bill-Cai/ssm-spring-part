package org.example;

import org.example.dyn.ProxyFactory;
import org.example.statics.StaticProxyCalculator;
import org.example.util.Calculator;
import org.example.util.CalculatorImpl;

/**
 * @since: 2025/4/30 11:27
 * @author: qm
 * @description:
 */
public class UseAop {
    public static void main(String[] args) {
        // 创建 AOP 代理对象
//        StaticProxyCalculator staticProxyCalculator = new StaticProxyCalculator(new CalculatorImpl());
        // 调用 AOP 代理对象的方法
//        staticProxyCalculator.add(1, 2);
//        staticProxyCalculator.sub(1, 2);
//        staticProxyCalculator.mul(1, 2);
//        staticProxyCalculator.div(1, 2);

        // JDK 动态代理
        CalculatorImpl calculator = new CalculatorImpl();
        ProxyFactory proxyFactory = new ProxyFactory(calculator);
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(1, 2);
//        proxy.div(1, 0);
    }
}
