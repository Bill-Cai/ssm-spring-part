package org.example.advice;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @since: 2025/5/5 14:53
 * @author: qm
 * @description: *  1. 增强类的内部存储增强代码
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
@Component
@Aspect
public class LogAdvice {
    /**
     * *  切点表达式
     * *     固定语法 execution(1 2 3.4.5(6))
     * *       1. 访问修饰符 public/private...
     * *       2. 方法返回值类型 String/int/void...
     * *           如果不考虑访问修饰符和返回值，则一起写为 *
     * *           如果不考虑，则两个都不考虑；如果考虑，则两个都考虑；仅写一个会报错
     * *       3. 包名
     * *           具体包：org.example.service.impl
     * *           单层模糊：org.example.service.*
     * *           多层模糊：org.example..impl          .. 表示任意层
     * *               细节：.. 不能再开头
     * *                    找所有impl：org..impl，不能写 ..impl，但是可以写 *..impl
     * *       4. 类名
     * *           具体类：CalculatorImpl
     * *           模糊类：*
     * *           部分模糊：*Calculator
     * *       5. 方法名
     * *           语法和类名一致
     * *       6. 参数列表
     * *           没有参数：()
     * *           有具体参数：(int) (String,int)
     * *           模糊参数：(..) 代表任意参数
     * *           部分模糊：(..int) 代表最后一个参数int；(int..) 代表第一个参数int；(String..int) 代表第一个参数String，最后一个参数int
     */

    /**
     * *  重用切点表达式
     * *      1. 在当前类中
     * *          定义一个空方法 --> 注解 @Pointcut --> 切点表达式 --> 其他方法引用
     * *      2. 创建一个切点类
     * *          单独维护切点表达式
     * *          其他类引用：类全限定符号.方法名()
     */

//    @Pointcut("execution(* org.example.service.impl.*.*(..))")
//    public void pointcut() {
//    }
    @Before("org.example.pointcut.MyPointCut.pointcut1()")
    public void start() {
        System.out.println("LogAdvice: start");
    }

    @After("org.example.pointcut.MyPointCut.pointcut1()")
    public void end() {
        System.out.println("LogAdvice: end");
    }

    @AfterThrowing("org.example.pointcut.MyPointCut.pointcut1()")
    public void exception() {
        System.out.println("LogAdvice: exception");
    }
}
