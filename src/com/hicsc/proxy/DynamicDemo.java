package com.hicsc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author: skye
 * @date: 2020/5/21
 **/
public class DynamicDemo {

    public static void main(String[] args) {

        System.getProperties().setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");

        RealSubject rs = new RealSubject();
        InvocationHandler ih = new DynamicSubject(rs);
        Class<?> cls = rs.getClass();

        Subject subject = (Subject) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), ih);
        subject.request();

        System.out.println(subject.getClass());
    }
}
