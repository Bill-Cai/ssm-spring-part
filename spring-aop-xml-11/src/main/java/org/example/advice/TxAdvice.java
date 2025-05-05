package org.example.advice;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

/**
 * @since: 2025/5/5 16:51
 * @author: qm
 * @description:
 */
@Component
public class TxAdvice {
    public void begin(JoinPoint joinPoint) {
        System.out.println("Tx begin");
    }

    public void commit(Object result) {
        System.out.println("Tx commit");
    }

    public void rollback(JoinPoint joinPoint, Throwable ex) {
        System.out.println("Tx rollback");
    }
}
