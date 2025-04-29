package org.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @since: 2025/4/29 19:38
 * @author: qingmu
 * @description: Java配置类，代替XML配置文件
 * 1. 包扫描注解配置
 * 2. 引用外部的配置文件
 * 3. 声明三方依赖的bean组件
 */
@ComponentScan("org.example.ioc_01") // 扫描指定包下的所有组件【替代xml中的<context:component-scan>标签】
@PropertySource("classpath:jdbc.properties") // 加载外部配置文件【替代xml中的<context:property-placeholder>标签】
@Configuration
public class JavaConfiguration {

}
