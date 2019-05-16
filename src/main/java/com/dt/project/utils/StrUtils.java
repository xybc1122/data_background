package com.dt.project.utils;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class StrUtils {

    /**
     * 更新sql // 批量删除数据  针对基础资料 一些通过用的方法
     *
     * @param delIds
     * @param sql
     * @param thisId
     * @return
     */
    public static String updateSql(String delIds, String sql, String param, String delDate, String thisId) {
        String[] newDelIds = delIds.split(",");
        List<String> idsList = java.util.Arrays.asList(newDelIds);
        StringBuilder sb = new StringBuilder();
        sb.append(sql).append(param);
        if (StringUtils.isNotBlank(delDate)) {
            sb.append(delDate).append(new Date().getTime());
        }
        sb.append("\n").append("WHERE ").append(thisId).append(" in (");
        for (String id : idsList) {
            if (idsList.indexOf(id) > 0)
                sb.append(",").append(id);
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * 拼接删除in sql
     *
     * @param thisId
     * @return
     */
    public static String in(Object obj, String thisId) {
        StringBuilder sb = new StringBuilder();
        if (obj == null) {
            return sb.append(thisId).append(" IN (-1)").toString();
        }
        if (obj instanceof String) {
            String ids = (String) obj;
            String[] idsArr = ids.split(",");
            sb.append("\n").append(thisId).append(" in (");
            for (String id : idsArr) {
                sb.append(id).append(",");
            }
        } else if (obj instanceof List) {
            List idList = (List) obj;
            sb.append("\n").append(thisId).append(" in (");
            for (Object id : idList) {
                sb.append(id).append(",");
            }
        }
        return sb.substring(0, sb.length() - 1) + ")";
    }

    /**
     * 转换Integer
     *
     * @param v
     * @return
     */
    public static Integer isIntegerNull(String v) {
        if (StringUtils.isNotBlank(v)) {
            return Integer.parseInt(v);
        }
        return null;
    }

    /**
     * 通用替换字符串转Decimal
     */
    public static BigDecimal repDecimal(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        int h1 = str.indexOf("￡");
        int h = str.indexOf("£");
        int l = str.indexOf("%");
        int j = str.indexOf("$");
        int k = str.indexOf(",");
        int g = str.indexOf("￥");
        int f = str.indexOf("€");
        int c = str.indexOf("Can");
        int v = str.indexOf("MXN");
        if (v == -1 && c == -1 && h == -1 && l == -1 && j == -1 && k == -1 && g == -1 && f == -1 && h1 == -1) {
            return new BigDecimal(str);
        }
        String strNew = str.
                replace("￥", "").
                replace("%", "").
                replace("$", "").
                replace(",", "").
                replace("£", "").
                replace("€", "").
                replace("Can", "").
                replace("MXN", "").
                replace("￡", "").
                trim();
        if (l != -1) {
            return new BigDecimal(strNew).divide(new BigDecimal("100"));
        }
        return new BigDecimal(strNew);
    }

    /**
     * 通用替换字符串转Double
     */
    public static Double repDouble(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        int h = str.indexOf("£");
        int l = str.indexOf("%");
        int j = str.indexOf("$");
        int k = str.indexOf(",");
        int g = str.indexOf("￥");
        int f = str.indexOf("€");
        int c = str.indexOf("Can");
        int v = str.indexOf("MXN");
        if (v == -1 && c == -1 && h == -1 && l == -1 && j == -1 && k == -1 && g == -1 && f == -1) {
            return Double.parseDouble(str);
        }
        String strNew = str.
                replace("￥", "").
                replace("%", "").
                replace("$", "").
                replace(",", "").
                replace("£", "").
                replace("€", "").
                replace("Can", "").
                replace("MXN", "")
                .trim();
        if (l != -1) {
            return new BigDecimal(strNew).divide(new BigDecimal(100)).doubleValue();
        }
        return Double.parseDouble(strNew);
    }

    /**
     * 通用替换字符串判断
     */
    public static String repString(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        } else if (str.equals("NO")) {
            return "NO";
        }
        int l = str.indexOf("\\");
        int k = str.indexOf("'");
        if (k == -1 && l == -1) {
            return str;
        }
        return str.
                replace("'", "").
                replace("\\", "").
                replace('"', ' ')
                .trim();
    }

    /**
     * 财务字符串替换BigDecimal
     *
     * @param str
     * @return
     */
    public static BigDecimal replaceDecimal(String str) {
        String strNew;
        if (StringUtils.isBlank(str)) {
            return null;
        }
        int i = str.indexOf(".");
        int j = str.indexOf(",");
        int k = str.indexOf("?");
        //会出现 不间断的空格
        int s = str.indexOf("\u00A0");
        //如果都有 并且 j > i 等于德国的
        if (i != -1 && j != -1 && j > i) {
            strNew = str.
                    replace(".", "").
                    replace(',', '.');
            return new BigDecimal(strNew);
        }
        //如果都有 并且 j < i 等于加拿大的
        else if (i != -1 && j != -1 && j < i) {
            strNew = str.
                    replace(",", "");
            return new BigDecimal(strNew);
        }
        //法国会出现,号
        else if (k != -1 && j != -1) {
            strNew = str.
                    replace("?", "").
                    replace(',', '.');
            return new BigDecimal(strNew);
            //法国会出现不间断的空格
        } else if (s != -1 && j != -1) {
            strNew = str.
                    replace("\u00A0", "").
                    replace(',', '.');
            return new BigDecimal(strNew);

        } else if (j != -1) {
            //如果单独是单独的 ,号
            strNew = str.replace(',', '.');
            return new BigDecimal(strNew);
        }
        return new BigDecimal(str);
    }

    /**
     * 返回Integer 类型 财务导入跟Xls导入用到
     *
     * @param str
     * @return
     */
    public static Integer replaceInteger(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        int j = str.indexOf(",");
        if (j == -1) {
            return Integer.parseInt(str);
        }
        String newStr = str.
                replace(",", "");
        return Integer.parseInt(newStr);
    }

    /**
     * 返回Long 类型 这工具 转换时间  财务导入跟Xls导入用到
     *
     * @param str
     * @return
     */
    public static Long replaceLong(String str) {
        Long l;
        if (StringUtils.isBlank(str)) {
            return null;
        }
        try {
            //如果有报错有catch
            l = Long.parseLong(str);
        } catch (Exception e) {
            return DateUtils.getXlsStrTime(str, "yyyy-MM-dd");
        }
        return l;
    }

    /**
     * 返回Integer 类型 基本
     *
     * @param str
     * @return
     */
    public static Integer repInteger(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        return Integer.parseInt(str);
    }

    /**
     * 返回Long 类型 基本
     *
     * @param str
     * @return
     */
    public static Long repLong(String str) {

        if (StringUtils.isBlank(str)) {
            return null;
        }
        return Long.parseLong(str);
    }

    /**
     * 封装Append
     */
    public static StringBuilder appBuider(StringBuilder sb, String str) {
        if (StringUtils.isEmpty(str)) {
            sb.append(str);
        } else {
            sb.append("'").append(str).append("'");
        }
        return sb;
    }

    /**
     * 去除 ﻿"\uFEFF"
     *
     * @param str
     * @return
     */
    public static String specialUnicode(String str) {
        if (str.startsWith("\uFEFF")) {
            str = str.replace("\uFEFF", "");
        } else if (str.endsWith("\uFEFF")) {
            str = str.replace("\uFEFF", "");
        }
        return str;
    }

    public static void main(String[] args) {
        String s = "-14 786,59";
        System.out.println(s.indexOf(" "));
    }
}
