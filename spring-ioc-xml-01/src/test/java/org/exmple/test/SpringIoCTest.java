package org.exmple.test;

import org.example.ioc_03.HappyComponent;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @since: 2025/4/26 14:00
 * @author: qm
 * @description:
 */
public class SpringIoCTest {
    // 创建IoC容器并读取配置文件
    @Test
    public void CreateIoC() {
        // 方法1：直接实例化并指定配置文件路径
        ApplicationContext context1 = new ClassPathXmlApplicationContext("spring-03.xml");

        // 方法2：先实例化ApplicationContext对象，再通过getBean方法获取对象并刷新
        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext();
        context2.setConfigLocations("spring-03.xml");
        context2.refresh();
    }

    // 在IoC容器获取Bean
    @Test
    public void getBeanFromIoC() {
        // 创建IoC容器
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-03.xml");

        // 获取Bean对象
        // 方法1. 通过Bean的名称获取
        HappyComponent bean1 = (HappyComponent) context.getBean("happyComponent");
        // 方法2. 通过Bean的类型获取
        HappyComponent bean2 = context.getBean(HappyComponent.class);
        // 方法3. 通过Bean的名称和类型获取
        HappyComponent bean3 = context.getBean("happyComponent", HappyComponent.class);

        bean1.doWork();

        // 获取的Bean对象是同一个实例
        System.out.println("bean1 == bean2: " + (bean1 == bean2));
        System.out.println("bean1 == bean3: " + (bean1 == bean3));
    }
}
