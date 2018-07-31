package com.qianmi.yqqlm.pattern;

/**
 * 一般情况直接使用饿汉模式{@link com.qianmi.yqqlm.thread.race.RequestIDGenerator}
 * 如果要求使用懒加载则采用静态内部类的方式
 *
 * @author 陈辉[of2547]
 *         company qianmi.com
 *         Date    2018/7/31
 */
public class Singleton {

    /**
     * 私有-懒汉
     */
    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    private Singleton() {
    }

    /**
     * JVM本身机制保证了线程安全
     *
     * @return 单例
     */
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
