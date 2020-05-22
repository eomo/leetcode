package com.hicsc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: skye
 * @date: 2020/5/21
 **/
public class DynamicSubject implements InvocationHandler {

    private Object subject;

    public DynamicSubject(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin invoke: " + method.getName());

        method.invoke(subject, args);

        System.out.println("after invoke: " + method.getName());
        return null;
    }
}
