package com.itmck.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author it_mck
 * @version V1.0
 * @Package com.itmck.proxy
 * @date 2020/5/21 21:14
 */
public class JDKproxy {


    /**
     * jdk方式的动态代理基于接口实现,被代理对象实现相应的接口
     * @param args
     */
    public static void main(String[] args) {

        //1创建被代理对象
        Subject subject = new SubjectImpl();
        //代理类调用处理程序中
        InvocationHandler subjectProxy = new SubjectProxy(subject);
        /**
         * 3:通过Proxy创建代理之后实例对象
         * 参数1:代理类的类加载器  性参数2:被代理类的接口对象  参数3:代理类
         *
         *      lassLoader loader, Class<?>[] interfaces, InvocationHandler h
         */
        //创建代理对象
        Subject proxyInstance = (Subject) Proxy.newProxyInstance(subjectProxy.getClass().getClassLoader(), subject.getClass().getInterfaces(), subjectProxy);
        proxyInstance.hello("world");
    }
}

/**
 *
 * 创建代理对象
 */
class SubjectProxy implements InvocationHandler {

    private Subject subject;//被代理对象

    public SubjectProxy(Subject subject) {
        this.subject = subject;
    }
    /**
     *
     * @param proxy 代理对象
     * @param method  被代理对象的方法
     * @param args  参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("--------------begin-------------");
        Object invoke = method.invoke(subject, args);//反射获取实例
        System.out.println("--------------end-------------");
        return invoke;
    }
}
/**
 * 被代理对象
 */
class SubjectImpl implements Subject{

    @Override
    public void hello(String param) {
        System.out.println("hello:"+param);
    }
}


interface  Subject{

    void hello(String  param);
}