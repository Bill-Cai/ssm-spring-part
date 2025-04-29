package org.example.ioc_01;

import org.springframework.stereotype.Component;

/**
 * @since: 2025/4/28 13:34
 * @author: qm
 * @description:
 *      普通组件：
 *          1. 标记注解 @Component
 *          2. 配置指定包
 */
@Component
// @Component注解表示该类是一个组件，Spring会自动扫描并注册到容器中。
// 等于于xml配置中的<bean>标签：<bean id="commonComponent" class="org.example.ioc_01.CommonComponent"/>
public class CommonComponent {
}
