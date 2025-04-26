package org.example.ioc_05;

import org.springframework.beans.factory.FactoryBean;

/**
 * @since: 2025/4/26 15:40
 * @author: qm
 * @description:
 */

/*
 * FactoryBean接口的实现类
 *   step 1. 实现FactoryBean接口 <返回值泛型>
 *   step 2. 实现getObject()方法，返回需要创建的对象；实现getObjectType()方法，返回对象的类型
 */
public class JavaBeanFactoryBean implements FactoryBean<JavaBean> {

    @Override
    public JavaBean getObject() throws Exception {
        return new JavaBean();
    }

    @Override
    public Class<?> getObjectType() {
        return JavaBean.class;
    }
}
