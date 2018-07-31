package com.qianmi.yqqlm.pattern.common;

/**
 *
 * @author 陈辉[of2547]
 *         company qianmi.com
 *         Date    2018/7/31
 */
public class LoadCacheData implements LoadData {

    @Override
    public String load() {
        return "从缓存加载数据";
    }
}
