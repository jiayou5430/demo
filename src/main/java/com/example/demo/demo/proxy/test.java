package com.example.demo.demo.proxy;

import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args) {
        Liudehua liudehua = new Liudehua();
        StarProxy invocationHandler = new StarProxy(liudehua);
        Star proxy = (Star) Proxy.newProxyInstance(liudehua.getClass().getClassLoader(), liudehua.getClass().getInterfaces(), invocationHandler);
        proxy.dance("dehua");
        proxy.sing("dehua");
    }
}
