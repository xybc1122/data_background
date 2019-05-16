package com.dt.project.utils;

import com.dt.project.model.RealTimeData;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 并发 ThreadLocal 转换类
 */
public class ThreadLocalUtils {


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

    //set清空数据
    public static void clearSetThread(ThreadLocal<Set<RealTimeData>> set) {
        Set<RealTimeData> realTimeData = set.get();
        if (realTimeData != null && realTimeData.size() > 0) {
            realTimeData.clear();
            set.set(realTimeData);
        }
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
