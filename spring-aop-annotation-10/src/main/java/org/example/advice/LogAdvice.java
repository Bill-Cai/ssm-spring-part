package org.example.advice;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @since: 2025/5/5 14:53
 * @author: qm
 * @description:
 */
@Component
@Aspect
public class LogAdvice {
    /**
     * *  1. 增强类的内部存储增强代码
     * *      具体定义几个方法 <-- 插入几个位置
     * *  2. 使用注解配置指定插入目标方法的位置：
     * *      前置：@Before
     * *      后置：@AfterReturning
     * *      异常：@AfterThrowing
     * *      最后：@After
     * *      环绕：@Around
     * *  3. 配置切点表达式 [选中插入的方法 切点表达式]
     * *  4. 注解
     * *      @Component
     * *      @Aspect = 切点 + 增强
     * *  5. 开启 AspectJ 注解支持
     */

    @Before("execution(* org.example.service.impl.*.*(..))")
    public void start() {
        System.out.println("LogAdvice: start");
    }

    @After("execution(* org.example.service.impl.*.*(..))")
    public void end() {
        System.out.println("LogAdvice: end");
    }

    @AfterThrowing("execution(* org.example.service.impl.*.*(..))")
    public void exception() {
        System.out.println("LogAdvice: exception");
    }
}
