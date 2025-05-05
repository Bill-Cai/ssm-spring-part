package org.example.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;

/**
 * @since: 2025/5/5 15:16
 * @author: qm
 * @description: 增强类
 * <p>
 * *  1. 定义方法：增强代码
 * *  2. 使用注解配置指定插入目标方法的位置
 * *  3. 配置切点表达式
 * *  4. 切面和ioc配置
 * *  5. 开启 AspectJ 注解支持
 * *
 * *    增强方法中获取目标方法信息
 * *        1. 全部增强方法中，获取目标方法的信息（所属类信息，方法名，访问修饰符，参数...）
 * *        2. 返回结果（仅在后置增强 @AfterReturning 中使用）
 * *        3. 异常信息（仅在异常增强 @AfterThrowing 中使用）
 */
//@Component
//@Aspect
public class MyAdvice {
    @Before("org.example.pointcut.MyPointCut.pointcut2()")
    public void before(JoinPoint joinPoint) {
        // 获取类名
        String className = joinPoint.getTarget().getClass().getName();
        // 获取方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取访问修饰符
        String modifier = Modifier.toString(joinPoint.getSignature().getModifiers());
        // 获取参数
        Object[] args = joinPoint.getArgs();

        System.out.println(
                "[MyAdvice: before] Class name: " + className
                        + ", Method name: " + methodName
                        + ", Modifier: " + modifier
//                        + ", Args: " + args
        );
    }

    @AfterReturning(value = "org.example.pointcut.MyPointCut.pointcut2()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
    }

    @After("org.example.pointcut.MyPointCut.pointcut2()")
    public void after(JoinPoint joinPoint) {
    }

    @AfterThrowing(value = "org.example.pointcut.MyPointCut.pointcut2()", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, Throwable throwable) {
    }
}
