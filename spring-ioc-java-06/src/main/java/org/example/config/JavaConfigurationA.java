package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @since: 2025/4/30 10:01
 * @author: qm
 * @description:
 */
@Configuration
@Import(JavaConfigurationB.class)
public class JavaConfigurationA {
    @Bean
    public String beanA() {
        return "JavaConfigurationA beanA";
    }
}
