package com.hicsc.proxy;

/**
 * @author: skye
 * @date: 2020/5/21
 **/
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("real subject request");
    }
}
