package org.example.advice;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @since: 2025/5/5 16:06
 * @author: qm
 * @description:
 */
@Component
@Aspect
@Order(0) // 指定执行顺序，数字越小越先执行
public class TxAdvice {
    @Before("org.example.pointcut.MyPointCut.pointcut1()")
    public void begin() {
        System.out.println("Tx begin");
    }

    @AfterReturning("org.example.pointcut.MyPointCut.pointcut1()")
    public void commit() {
        System.out.println("Tx commit");
    }

    @AfterThrowing("org.example.pointcut.MyPointCut.pointcut1()")
    public void rollback() {
        System.out.println("Tx rollback");
    }
}
