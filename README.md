# 保持愚蠢

### 1.Java内存模型
    1. JMM的关键技术点都是围绕多线程的原子性、可见性和有序性展开的
    2. 多线程并发的法宝: 外互斥、内可见

### 2.画图
![java内存模型](http://p9bs7d5xg.bkt.clouddn.com/java%E7%BA%BF%E7%A8%8B%E6%A8%A1%E5%9E%8B.png)

### 3.深入分析

- 原子性
    - 操作不可中断
- 可见行
    - A线程变更共享变量的值，B线程立即感知
    - java中普通的共享变量不保证可见性，其被写入内存的时机是不确定的，可能出现脏读
    - volatile保证可见性：写操作立即刷新到主内存，读操作直接从主内存读取
    - synchronized和Lock能保证同一时刻只有一个线程获取锁并执行同步代码，间接实现可见行
- 有序性
    - 指令重排可以保证串行语义一致，但没有义务保证多线程间的语义也一致，即可能产生脏读