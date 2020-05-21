package com.itmck.proxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author it_mck
 * @version V1.0
 * @Package com.itmck.proxy
 * @date 2020/5/21 21:53
 */
public class CglibProxy {


    /**
     * 本文主要讲的是CGLIB的动态代理，因为基于JDK的动态代理一定要继承一个接口，而绝大部分情况是基于POJO类的动态代理，
     * 那么CGLIB就是一个很好的选择，在Hibernate框架中PO的字节码生产工作就是靠CGLIB来完成的。还是先看代码。
     *
     * @param args
     */
    public static void main(String[] args) {

        //Enhancer类是CGLib中的一个字节码增强器
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CGsubject.class);//将被代理类设置成父类
        //设置拦截器
        enhancer.setCallback(new MethodInterceptor() {
            /**
             *
             * @param o     Object为由CGLib动态生成的代理类实例
             * @param method Method为上文中实体类所调用的被代理的方法引用
             * @param args  Object[]为参数值列表
             * @param methodProxy   MethodProxy为生成的代理类对方法的代理引用
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("begin time -----> " + System.currentTimeMillis());
                Object o1 = methodProxy.invokeSuper(o, args);
                System.out.println("end time -----> " + System.currentTimeMillis());
                return o1;
            }
        });
        CGsubject cGsubject = (CGsubject) enhancer.create();//创建代理对象实例
        cGsubject.sayHello();
    }
}

/**
 * 被代理对象
 */
class CGsubject {

    public void sayHello() {
        System.out.println("hello world");
    }
}
