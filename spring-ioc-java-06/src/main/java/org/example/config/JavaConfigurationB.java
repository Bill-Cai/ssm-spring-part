package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @since: 2025/4/30 10:01
 * @author: qm
 * @description:
 */
@Configuration
public class JavaConfigurationB {
    @Bean
    public String beanB() {
        return "JavaConfigurationB beanB";
    }
}
