package org.example.dyn;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @since: 2025/5/3 20:04
 * @author: qingmu
 * @description:
 */
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            /**
             * invoke 调用代理的方法都会执行到这个方法
             *
             * @param proxy the proxy instance that the method was invoked on
             *              代理对象
             *
             * @param method the {@code Method} instance corresponding to
             * the interface method invoked on the proxy instance.  The declaring
             * class of the {@code Method} object will be the interface that
             * the method was declared in, which may be a superinterface of the
             * proxy interface that the proxy class inherits the method through.
             *               目标的方法
             *
             * @param args an array of objects containing the values of the
             * arguments passed in the method invocation on the proxy instance,
             * or {@code null} if interface method takes no arguments.
             * Arguments of primitive types are wrapped in instances of the
             * appropriate primitive wrapper class, such as
             * {@code java.lang.Integer} or {@code java.lang.Boolean}.
             *             方法参数
             *
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("[Dynamic Proxy][log] " + method.getName() + ", args = " + Arrays.toString(args));
                    result = method.invoke(target, args);
                    System.out.println("[Dynamic Proxy][log] " + method.getName() + ", result = " + result);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("[Dynamic Proxy][log] " + method.getName() + ", error = " + e.getMessage());
                } finally {
                    System.out.println("[Dynamic Proxy][log] " + method.getName() + ", finally");
                }
                return result;
            }
        };
        /**
         * JDK 生成代理对象
         *    @param classLoader 目标对象的类加载器
         *    @param interfaces 目标对象实现的接口
         *    @param invocationHandler 代理对象的调用处理器
         */
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
