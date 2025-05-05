package org.example.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @since: 2025/5/5 16:09
 * @author: qm
 * @description:
 */
//@Component
//@Aspect
public class TxAroundAdvice {
    /**
     * 环绕通知，需要在通知中调用proceed方法来执行目标方法
     *
     * @param pjp 目标方法
     * @return 执行结果
     * @throws Throwable
     */
    @Around("org.example.pointcut.MyPointCut.pointcut1()")
    public Object transaction(ProceedingJoinPoint pjp) {
        Object[] args = pjp.getArgs();
        Object result = null;
        try {
            System.out.println("Tx begin");
            result = pjp.proceed(args);
            System.out.println("Tx commit");
        } catch (Throwable e) {
            System.out.println("Tx rollback");
            throw new RuntimeException(e);
        } finally {
            System.out.println("Tx end");
        }
        return result;
    }
}
