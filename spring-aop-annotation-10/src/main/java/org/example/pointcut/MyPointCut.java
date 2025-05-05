package org.example.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @since: 2025/5/5 15:51
 * @author: qm
 * @description:
 */
@Component
public class MyPointCut {
    @Pointcut("execution(* org.example.service.impl.*.*(..))")
    public void pointcut1() {
    }

    @Pointcut("execution(* org.example..impl.*.*(..))")
    public void pointcut2() {
    }
}
