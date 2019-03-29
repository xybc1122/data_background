package com.dt.user.store;

import com.dt.user.model.RealTimeData;

/**
 * @ClassName RealTimeDataStore
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/29 16:34
 **/
public class RealTimeDataStore {
    /**
     * 设置百分比进度
     */

    public static int setSchedule(RealTimeData timeData, int index) {
        return timeData.setAttributesTim(index);
    }

    /**
     * 发送消息
     */
    public static void sendMsg(RealTimeData timeData, String msg) {
        timeData.setMsg(msg);
    }

    /**
     * 设置消息
     */
    public static void setCont(RealTimeData timeData, String filePath) {
        timeData.setFileCount(filePath);
    }

    /**
     * 创建对象
     */
    public static RealTimeData getTimeData(String filePath) {
        RealTimeData timeData = new RealTimeData();
        setCont(timeData, filePath);
        return timeData;
    }
}
