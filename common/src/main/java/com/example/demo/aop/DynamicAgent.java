package com.example.demo.aop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicAgent {

    private static String className;

    public DynamicAgent(String className) {
        this.className = className;
    }

    public static Object agent(Class interfaceClazz) {
        return Proxy.newProxyInstance(interfaceClazz.getClassLoader(), new Class[]{interfaceClazz}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(">>>>>>before invoke");
                Class clazz = Class.forName(className);

                Object ret = method.invoke(clazz.newInstance(), args);
                System.out.println(">>>>>>after invoke");
                return ret;
            }
        });
    }
}
