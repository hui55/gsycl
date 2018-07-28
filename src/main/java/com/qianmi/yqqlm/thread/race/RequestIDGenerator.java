package com.qianmi.yqqlm.thread.race;

import com.qianmi.yqqlm.thread.common.CircularSeqGenerator;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringJoiner;

/**
 * @author 陈辉[of2547]
 *         company qianmi.com
 *         Date    2018/7/28
 */
public class RequestIDGenerator implements CircularSeqGenerator {


    private final static RequestIDGenerator INSTANCE = new RequestIDGenerator();
    private final static short SEQ_UPPER_LIMIT = 999;

    private short sequence = -1;


    private RequestIDGenerator() {
        // 什么也不做
    }

    /**
     * 获取实例
     *
     * @return 返回单例
     */
    public static RequestIDGenerator getInstance() {
        return INSTANCE;
    }

    public String nextID() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");
        DecimalFormat df = new DecimalFormat("000");

        StringJoiner sj = new StringJoiner("");
        sj.add("0049").add(sf.format(new Date())).add(df.format(nextSequence()));
        return sj.toString();
    }

    @Override
    public short nextSequence() {
        if (sequence >= SEQ_UPPER_LIMIT) {
            return 0;
        } else {
            sequence++;
        }
        return sequence;
    }
}
