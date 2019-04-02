package com.dt.user.utils;

import com.dt.user.model.RealTimeData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CrrUtils {


    /**
     * Long 类型++
     *
     * @param numberCount
     */
    public static void inCreateNumberLong(ThreadLocal<Long> numberCount) {
        Long myNumberCount = numberCount.get();
        myNumberCount++;
        numberCount.set(myNumberCount);
    }

    /**
     * Long 类型++
     */
    public static void delCreateNumberLong(ThreadLocal<Long> numberCount) {
        Long myNumberCount = numberCount.get();
        myNumberCount--;
        numberCount.set(myNumberCount);
    }


    //set并发add
    public static Set<RealTimeData> inCreateSet(ThreadLocal<Set<RealTimeData>> timingSet, RealTimeData timeData) {
        Set<RealTimeData> realTimeDataSet = timingSet.get();
        if (realTimeDataSet == null) {
            realTimeDataSet = new HashSet<>();
        }
        if (timeData != null) {
            realTimeDataSet.add(timeData);
        }
        timingSet.set(realTimeDataSet);
        return realTimeDataSet;
    }

    //List清空数据
    public static void clearListThread(ThreadLocal<List<List<String>>> timingList) {
        List<List<String>> timings = timingList.get();
        if (timings != null && timings.size() > 0) {
            timings.clear();
            timingList.set(timings);
        }
    }

    //List添加数据
    public static void inCreateList(ThreadLocal<List<List<String>>> timingList) {
        List<List<String>> strList = timingList.get();
        if (strList == null) {
            strList = new ArrayList<>();
        }
        timingList.set(strList);
    }

    //List添加数据
    public static void inCreateListXls(ThreadLocal<List<List<?>>> timingList) {
        List<List<?>> strList = timingList.get();
        if (strList == null) {
            strList = new ArrayList<>();
        }
        timingList.set(strList);
    }

    /**
     * Integer 类型++
     *
     * @param numberCount
     */
    public static void inCreateNumberInteger(ThreadLocal<Integer> numberCount) {
        Integer myNumberCount = numberCount.get();
        myNumberCount++;
        numberCount.set(myNumberCount);
    }
}
