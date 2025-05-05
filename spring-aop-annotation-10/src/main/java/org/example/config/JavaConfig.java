package org.example.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @since: 2025/5/5 14:50
 * @author: qm
 * @description:
 */
@Configuration
@ComponentScan("org.example")
@EnableAspectJAutoProxy // 开启 AspectJ 注解支持
public class JavaConfig {
}
