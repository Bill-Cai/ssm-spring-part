package org.example.config;

import org.example.components.A;
import org.example.components.B;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @since: 2025/4/30 10:43
 * @author: qm
 * @description:
 */
@Configuration
@ComponentScan(basePackages = "org.example")
public class JavaConfig {
    @Bean
    public A a() {
        return new A();
    }

    @Bean
    public B b() {
        return new B();
    }
}
