package org.example.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @since: 2025/4/29 19:38
 * @author: qingmu
 * @description: Java配置类，代替XML配置文件
 * 1. 包扫描注解配置
 * 2. 引用外部的配置文件
 * 3. 声明三方依赖的bean组件
 */
@Configuration                                      // 声明当前类是一个配置类
@ComponentScan("org.example.ioc_01")                // 扫描指定包下的所有组件【替代xml中的<context:component-scan>标签】
@PropertySource("classpath:jdbc.properties")        // 加载外部配置文件【替代xml中的<context:property-placeholder>标签】
public class JavaConfiguration {
    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    /**
     * 声明DruidDataSource组件
     * 作为三方组件，需要手动声明，通过@Bean注解
     * 1. bean name：默认是方法名，可以通过@Bean注解的name属性指定
     * 2. 周期方法指定：PostConstruct和PreDestroy注解；或者，initMethod和destroyMethod属性
     * 3. 作用域：使用@Scope注解指定，默认是单例
     * 4. 依赖注入：@Autowired注解
     */
    @Bean(name = "druidDataSource")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public DruidDataSource druidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        // 如果注入的bean是@Bean注解的，Spring会自动注入
        return new JdbcTemplate(druidDataSource());
    }

    @Bean
    public JdbcTemplate jdbcTemplate2(DruidDataSource dataSource) {
        // 可以在方法参数中注入bean
        // 如果没有对应的bean，会抛出异常
        // 如果有多个同类型的bean，参数名指定为bean的名称
        return new JdbcTemplate(dataSource);
    }
}
