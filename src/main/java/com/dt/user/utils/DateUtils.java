package com.dt.user.utils;

import com.dt.user.model.FinancialSalesBalance;
import com.dt.user.toos.Constants;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间转换 设置
 */
public class DateUtils {

    /**
     * 设置时间转换类型
     *
     * @param fsb
     * @param seId
     * @throws IOException
     */
    public static void setDate(FinancialSalesBalance fsb, Integer seId, String time) {
        switch (seId) {
            case 1:
                fsb.setDate(DateUtils.getTime(time, Constants.USA_TIME));
                break;
            case 2:
                fsb.setDate(DateUtils.getTime(time, Constants.CANADA_TIME));
                break;
            case 3:
                fsb.setDate(DateUtils.getTime(time, Constants.AUSTRALIA_TIME));
                break;
            case 4:
                fsb.setDate(DateUtils.getTime(time, Constants.UNITED_KINGDOM_TIME));
                break;
            case 5:
                fsb.setDate(DateUtils.getTime(time, Constants.GERMAN_TIME));
                break;
            case 6:
                fsb.setDate(DateUtils.getFranceTime(time, Constants.FRANCE_TIME));
                break;
            case 7:
                fsb.setDate(DateUtils.getItalyTime(time, Constants.ITALY_TIME));
                break;
            case 8:
                fsb.setDate(DateUtils.getTime(time, Constants.SPAIN_TIME));
                break;
            case 9:
                fsb.setDate(DateUtils.getTime(time, Constants.JAPAN_TIME));
                break;
            case 10:
                fsb.setDate(DateUtils.getTime(time, Constants.MEXICO_TIME));
                break;
        }
    }


    //获得当前时间+后面 N天时间的时间戳
    public static Long getRearDate(Integer time) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, time);
        return calendar.getTime().getTime();
    }

    /**
     * 美国/加拿大/德国/澳大利亚/英国/时间转换/北美
     *
     * @throws ParseException
     */
    public static Long getTime(String date, String pattern) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        Long time = null;
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.ENGLISH);
        try {
            time = sdf.parse(date).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static Long getXlsStrTime(String date, String pattern) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        String newDate = null;
        Long time = null;
        if (date.contains("一月")) {
            newDate = date.replace("一月", "01");
        } else if (date.contains("二月")) {
            newDate = date.replace("二月", "02");
        } else if (date.contains("三月")) {
            newDate = date.replace("三月", "03");
        } else if (date.contains("四月")) {
            newDate = date.replace("四月", "04");
        } else if (date.contains("五月")) {
            newDate = date.replace("五月", "05");
        } else if (date.contains("六月")) {
            newDate = date.replace("六月", "06");
        } else if (date.contains("七月")) {
            newDate = date.replace("七月", "07");
        } else if (date.contains("八月")) {
            newDate = date.replace("八月", "08");
        } else if (date.contains("九月")) {
            newDate = date.replace("九月", "09");
        } else if (date.contains("十月")) {
            newDate = date.replace("十月", "10");
        }
        if (date.contains("十一月")) {
            newDate = date.replace("十一月", "11");
        }
        if (date.contains("十二月")) {
            newDate = date.replace("十二月", "12");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            time = sdf.parse(newDate).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 意大利日期转换
     *
     * @param date
     * @param pattern
     * @return
     */
    public static Long getItalyTime(String date, String pattern) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        Long time = null;
        String newDate = null;
        if (date.contains("gen")) {
            newDate = date.replace("gen", "01");
        } else if (date.contains("feb")) {
            newDate = date.replace("feb", "02");
        } else if (date.contains("mar")) {
            newDate = date.replace("mar", "03");
        } else if (date.contains("apr")) {
            newDate = date.replace("apr", "04");
        } else if (date.contains("mag")) {
            newDate = date.replace("mag", "05");
        } else if (date.contains("giu")) {
            newDate = date.replace("giu", "06");
        } else if (date.contains("lug")) {
            newDate = date.replace("lug", "07");
        } else if (date.contains("ago")) {
            newDate = date.replace("ago", "08");
        } else if (date.contains("set")) {
            newDate = date.replace("set", "09");
        } else if (date.contains("ott")) {
            newDate = date.replace("ott", "10");
        } else if (date.contains("nov")) {
            newDate = date.replace("nov", "11");
        } else if (date.contains("dic")) {
            newDate = date.replace("dic", "12");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.ENGLISH);
        try {
            time = sdf.parse(newDate).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 法国日期转换
     *
     * @param date
     * @param pattern
     * @return
     */
    public static Long getFranceTime(String date, String pattern) {
        if (StringUtils.isBlank(date)) {
            return null;
        }
        Long time = null;
        String newDate = null;
        if (date.contains("janv.")) {
            newDate = date.replace("janv.", "01");
        } else if (date.contains("févr.")) {
            newDate = date.replace("févr.", "02");
        } else if (date.contains("mars")) {
            newDate = date.replace("mars", "03");
        } else if (date.contains("avr.")) {
            newDate = date.replace("avr.", "04");
        } else if (date.contains("mai")) {
            newDate = date.replace("mai", "05");
        } else if (date.contains("juin")) {
            newDate = date.replace("juin", "06");
        } else if (date.contains("juil.")) {
            newDate = date.replace("juil.", "07");
        } else if (date.contains("août")) {
            newDate = date.replace("août", "08");
        } else if (date.contains("sept")) {
            newDate = date.replace("sept.", "09");
        } else if (date.contains("oct.")) {
            newDate = date.replace("oct.", "10");
        } else if (date.contains("nov.")) {
            newDate = date.replace("nov.", "11");
        } else if (date.contains("déc.")) {
            newDate = date.replace("déc.", "12");
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.ENGLISH);
        try {
            time = sdf.parse(newDate).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return time;
    }

    public static void main(String[] args) throws ParseException {
        String stringDate = "2018/11/1";
        //   SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy HH:mm:ss", Locale.ENGLISH);
        System.out.println(getTime(stringDate, "yyyy/MM/dd"));
//        Long time = sdf.parse(stringDate).getTime();
//        System.out.println(time);
//        System.out.println(getXlsStrTime(stringDate, "dd-MM-yyyy"));
//        System.out.println(DateUtils.getFranceTime(stringDate, Constants.FRANCE_TIME));

    }
}
