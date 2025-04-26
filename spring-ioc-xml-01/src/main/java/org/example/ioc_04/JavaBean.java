package org.example.ioc_04;

/**
 * @since: 2025/4/26 15:03
 * @author: qm
 * @description:
 */
public class JavaBean {
    /**
     * 必须是public且void类型的方法
     * 命名无所谓
     * 初始化方法写初始化的业务逻辑
     */
    public void init() {
        System.out.println("JavaBean init");
    }

    /*
     * 销毁方法
     */
    public void destroy() {
        System.out.println("JavaBean destroy");
    }
}
