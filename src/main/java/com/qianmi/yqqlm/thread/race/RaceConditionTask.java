package com.qianmi.yqqlm.thread.race;


/**
 * @author 陈辉[of2547]
 *         company qianmi.com
 *         Date    2018/7/28
 */
public class RaceConditionTask implements Runnable {

    /**
     * 模拟请求次数
     */
    private final int requestCount;

    public RaceConditionTask(int requestCount) {
        this.requestCount = requestCount;
    }

    @Override
    public void run() {

        int i = requestCount;
        String requestID;
        try {
            RequestIDGenerator generator = RequestIDGenerator.getInstance();
            while (i-- > 0) {
                requestID = generator.nextID();
                processRequest(requestID);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 快速修复alt+enter
     *
     * @param requestID 请求ID
     */
    private void processRequest(String requestID) throws InterruptedException {
        Thread.sleep(1550);
        System.out.printf("%s got requestID: %s \n", Thread.currentThread().getName(), requestID);
    }
}
