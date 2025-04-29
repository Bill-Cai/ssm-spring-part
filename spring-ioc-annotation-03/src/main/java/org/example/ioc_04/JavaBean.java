package org.example.ioc_04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @since: 2025/4/29 13:47
 * @author: qingmu
 * @description:
 */
@Component
public class JavaBean {
    // 赋值
    // 方法 1. 直接赋值
    private String name = "Zhang San";
    // 方法 2. 使用@Value注解赋值
    @Value("18")
    private int age;

    // 方法 3. 使用@Value注解赋值，使用${}从配置文件中读取
    //   例如：${jdbc.username:admin}表示从配置文件中读取jdbc.username的值，如果没有则使用默认值admin
    @Value("${jdbc.username:admin}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Override
    public String toString() {
        return "JavaBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
