package org.example.test;

import org.example.ioc_01.XxxDao;
import org.example.ioc_02.JavaBean;
import org.example.ioc_03.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @since: 2025/4/28 13:46
 * @author: qm
 * @description:
 */
public class SpringIoCTest {
    @Test
    public void testIoC_01() {
        // 1. 创建Spring容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-01.xml");
        // 2. 获取Bean
        XxxDao bean = context.getBean(XxxDao.class);
        Object xxxService = context.getBean("xxxService");
        // 3. 使用Bean
        System.out.println("bean = " + bean);
        System.out.println("xxxService = " + xxxService);
        // 4. 关闭Spring容器

        // 5. Spring容器会自动扫描指定包下的所有组件，并注册到容器中。
        // 6. @ComponentScan注解可以指定扫描的包路径。
    }

    @Test
    public void testIoC_02() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-02.xml");
        JavaBean bean1 = context.getBean(JavaBean.class);
        JavaBean bean2 = context.getBean(JavaBean.class);
        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
        System.out.println("bean1 == bean2 = " + (bean1 == bean2));

        context.close();
        // 单例模式：销毁时会调用一次destroy()方法
        // 原型模式：销毁是不会调用destroy()方法
    }

    @Test
    public void testIoC_03() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-03.xml");
        // 1. 获取Bean
        UserController userController = context.getBean("userController", UserController.class);
        System.out.println("userController = " + userController);
        // 2. 使用Bean
        userController.show();
        // 3. 关闭Spring容器
        context.close();
    }

    @Test
    public void testIoC_04() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-04.xml");
        // 1. 获取Bean
        org.example.ioc_04.JavaBean javaBean = context.getBean("javaBean", org.example.ioc_04.JavaBean.class);
        // 2. 使用Bean
        System.out.println("javaBean = " + javaBean);
        // 3. 关闭Spring容器
        context.close();
    }
}
