package com.qianmi.yqqlm.thread.race;

/**
 * @author 陈辉[of2547]
 *         company qianmi.com
 *         Date    2018/7/28
 */
public class RaceConditionDemo {

    /**
     * psvm
     *
     * @param args
     */
    public static void main(String[] args) {
        int numberOfThreads = args.length > 0 ? Short.valueOf(args[0]) : Runtime.getRuntime().availableProcessors();
        Thread[] workerThread = new Thread[numberOfThreads];

        for (int i = 0; i < numberOfThreads; i++) {
            workerThread[i] = new Thread(new RaceConditionTask(10));
            workerThread[i].setName(String.format("tasker-%s", i));
        }
        for (Thread thread : workerThread) {
            thread.start();
        }
    }
}
