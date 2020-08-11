package com.example.demo.aop;

import com.example.demo.service.impl.Apple;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibAgent implements MethodInterceptor {

    private Object proxy;

    private Object getInstance(Object proxy) {
        this.proxy = proxy;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.proxy.getClass());

        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(">>>>>>>>>>before invoking");
        Object ret = methodProxy.invokeSuper(o, objects);
        System.out.println(">>>>>>>>>>after invoking");
        return ret;
    }

    public static void main(String[] args) {
        CGlibAgent agent = new CGlibAgent();
        Apple apple = (Apple) agent.getInstance(new Apple());
        apple.show();
    }
}
