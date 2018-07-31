package com.qianmi.yqqlm.pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author 陈辉[of2547]
 *         company qianmi.com
 *         Date    2018/7/31
 */
public class DynamicProxyHandler implements InvocationHandler {


    private Object target;

    public DynamicProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类: " + proxy.getClass() + ", 调用方法: " + method.getName());
        return method.invoke(target, args);
    }
}
