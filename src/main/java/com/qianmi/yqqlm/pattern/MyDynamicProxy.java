package com.qianmi.yqqlm.pattern;

import com.qianmi.yqqlm.pattern.common.LoadCacheData;
import com.qianmi.yqqlm.pattern.common.LoadData;

import java.lang.reflect.Proxy;

/**
 * 静态代理
 * 1. 定义一个接口
 * 2. 多个实现接口的实际操作对象
 * 3. 定义代理对象
 * new xxxProxy(new RealWorker())
 * proxy.doXXX（由代理统一操作）
 * <p>
 * 动态代理
 * - 动态的创建代理并且动态的处理代理对象的方法调用
 * - 动态代理两个重要的对象Proxy、InvocationHandler
 *
 * @author 陈辉[of2547]
 *         company qianmi.com
 *         Date    2018/7/31
 */
public class MyDynamicProxy {

    public static void main(String[] args) {
        LoadCacheData loadCacheData = new LoadCacheData();
        LoadData loadData = (LoadData) Proxy.newProxyInstance(LoadData.class.getClassLoader(),
                new Class[]{LoadData.class},
                new DynamicProxyHandler(loadCacheData));

        System.out.printf(loadData.load());
    }
}
