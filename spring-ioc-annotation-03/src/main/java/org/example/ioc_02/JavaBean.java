package org.example.ioc_02;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @since: 2025/4/28 14:14
 * @author: qm
 * @description:
 */
//@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class JavaBean {
    @PostConstruct
    public void init() {
        System.out.println("JavaBean.init()");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("JavaBean.destroy()");
    }
}
