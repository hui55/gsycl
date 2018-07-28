package com.qianmi.yqqlm.thread.common;

/**
 * @author 陈辉[of2547]
 *         company qianmi.com
 *         Date    2018/7/28
 */
public interface CircularSeqGenerator {

    /**
     * 生成循环递增序列号
     *
     * @return [0-999]序列
     */
    short nextSequence();
}
