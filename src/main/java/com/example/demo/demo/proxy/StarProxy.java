package com.example.demo.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StarProxy implements InvocationHandler {

    Object target;

    public StarProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        heshui();
        Object result = method.invoke(target,args);
        pgc();
        return result;
    }

    // 生成代理类
    public Object CreatProxyedObj()
    {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }


    public void heshui(){
        System.out.println("我得先喝口水！");
    }
    public void pgc(){
        System.out.println("完事了，去嫖个娼吧！");
    }
}
