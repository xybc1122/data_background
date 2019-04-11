package com.dt.user.utils;

import com.dt.user.model.FinancialSalesBalance;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class StrUtils {

    /**
     * 更新sql //批量删除数据
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
                sb.append(",");
            sb.append("'").append(id).append("'");
        }
        sb.append(")");
        return sb.toString();
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
        int h = str.indexOf("£");
        int l = str.indexOf("%");
        int j = str.indexOf("$");
        int k = str.indexOf(",");
        int g = str.indexOf("￥");
        int f = str.indexOf("€");
        int c = str.indexOf("Can");
        int v = str.indexOf("MXN");
        if (v == -1 && c == -1 && h == -1 && l == -1 && j == -1 && k == -1 && g == -1 && f == -1) {
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
                replace("MXN", "")
                .trim();
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
            return Double.parseDouble(strNew) / 100;
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
        }
        return new BigDecimal(str.replace(',', '.'));
    }

    /**
     * 返回Integer 类型
     *
     * @param number
     * @return
     */
    public static Integer replaceInteger(String number) {
        if (StringUtils.isBlank(number)) {
            return null;
        }
        int j = number.indexOf(",");
        if (j == -1) {
            return Integer.parseInt(number);
        }
        String newNumber = number.
                replace(",", "");
        return Integer.parseInt(newNumber);
    }

    /**
     * 返回Long 类型
     *
     * @param number
     * @return
     */
    public static Long replaceLong(String number) {
        Long l;
        if (StringUtils.isBlank(number)) {
            return null;
        }
        try {
            //如果有报错有catch
            l = Long.parseLong(number);
        } catch (Exception e) {
            return DateUtils.getXlsStrTime(number, "yyyy-MM-dd");
        }
        return l;
    }

    /**
     * 封装Append
     */
    public static StringBuilder appBuider(StringBuilder sb, String str) {
        if (StringUtils.isEmpty(str)) {
            sb.append(str);
        } else {
            sb.append("'" + str + "'");
        }
        return sb;
    }

    /**
     * 判断TypeName是否== xxxxx  计算一些数据
     */
    public static void setInfo(String typeName, FinancialSalesBalance fsb) {
        if (StringUtils.isNotEmpty(typeName)) {
            //促销费用（abs(运费)<abs(促销费用)）
            //返回值 -1 小于 0 等于 1 大于
            if (fsb.getShippingCredits().abs().compareTo(fsb.getPromotionalRebates().abs()) < 0) {
                fsb.setNewPromotionalRebates(fsb.getShippingCredits().add(fsb.getPromotionalRebates()));
            }
            //促销费用（abs(运费)>abs(促销费用)）
            if (fsb.getShippingCredits().abs().compareTo(fsb.getPromotionalRebates().abs()) > 0) {
                fsb.setNewShippingCredits(fsb.getShippingCredits());
                fsb.setNewPromotionalRebates(fsb.getPromotionalRebates());
            }
            //促销费用（abs(运费)=abs(促销费用)）
            if (fsb.getShippingCredits().abs().compareTo(fsb.getPromotionalRebates().abs()) == 0) {
                fsb.setNewShippingCredits(new BigDecimal(0.0));
                fsb.setNewPromotionalRebates(new BigDecimal(0.0));
            }
            if (fsb.getNewShippingCredits() == null) {
                fsb.setNewShippingCredits(new BigDecimal(0.0));
            }
            if (fsb.getFbaFee() == null) {
                fsb.setFbaFee(new BigDecimal(0.0));
            }
            fsb.setNewShippingFba(fsb.getNewShippingCredits().add(fsb.getFbaFee()));
            if (!typeName.equals("退货")) {
                fsb.setQuantity(fsb.getoQuantity());
            }
            if (typeName.equals("服务费")) {
                fsb.setServiceFee(fsb.getOtherTransactionFees());
            } else if (typeName.equals("转账")) {
                fsb.setTransfer(fsb.getTotal());
            } else if (typeName.equals("调整")) {
                fsb.setAdjustment(fsb.getOther());
                fsb.setAdjustmentQty(fsb.getoQuantity());
            } else if (typeName.equals("库存费")) {
                fsb.setFbaInventoryFee(fsb.getOther());
            } else if (typeName.equals("秒杀费")) {
                fsb.setLightningDealFee(fsb.getOtherTransactionFees());
            } else if (typeName.equals("退货")) {
                fsb.setRefundQuantity(fsb.getoQuantity());
            } else if (typeName.equals("订单")) {
                fsb.setOrderQty(fsb.getoQuantity());
            }
        } else {
            fsb.setQuantity(fsb.getoQuantity());
        }


    }
}
