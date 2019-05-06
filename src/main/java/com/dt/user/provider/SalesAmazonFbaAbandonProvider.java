package com.dt.user.provider;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaAbandon;
import com.dt.user.store.AppendSqlStore;
import com.dt.user.store.FieldStore;
import com.dt.user.store.ProviderSqlStore;
import com.dt.user.toos.Constants;
import com.dt.user.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SalesAmazonFbaAbandonProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/9 13:16
 **/
public class SalesAmazonFbaAbandonProvider {

    public String setAbandon(Map<String, Object> mapStr) {
        List<SalesAmazonFbaAbandon> abandons = (List<SalesAmazonFbaAbandon>) mapStr.get("abandonList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `sales_amazon_fba_abandon`\n" +
                "(`date`,`shop_id`,`site_id`,`sku_id`,`area_id`,`order_id`,\n" +
                "`order_type`,`order_status`,`last_updated_date`,`abandon_sku`,\n" +
                "`fn_sku`,`disposition`, `requested_quantity`,`cancelled_quantity`,\n" +
                "`disposed_quantity`, `shipped_quantity`,`in_process_quantity`,`removal_fee`, `currency`,\n" +
                "`create_date`,`create_user`,`recording_id`) values");
        for (SalesAmazonFbaAbandon abandon : abandons) {
            sb.append("(").append(abandon.getDate()).append(",").append(abandon.getShopId()).append(",").
                    append(abandon.getSiteId()).append(",").append(abandon.getSkuId()).append(",").append(abandon.getAreaId()).append(",");
            StrUtils.appBuider(sb, abandon.getOrderId());
            sb.append(",");
            StrUtils.appBuider(sb, abandon.getOrderType());
            sb.append(",");
            StrUtils.appBuider(sb, abandon.getOrderStatus());
            sb.append(",").append(abandon.getLastUpdatedDate()).append(",");
            StrUtils.appBuider(sb, abandon.getAbandonSku());
            sb.append(",");
            StrUtils.appBuider(sb, abandon.getFnSku());
            sb.append(",");
            StrUtils.appBuider(sb, abandon.getDisposition());
            sb.append(",");
            sb.append(abandon.getRequestedQuantity()).append(",").
                    append(abandon.getCancelledQuantity()).append(",").append(abandon.getDisposedQuantity())
                    .append(",").append(abandon.getShippedQuantity()).append(",")
                    .append(abandon.getInProcessQuantity()).append(",").append(abandon.getRemovalFee()).append(",");
            StrUtils.appBuider(sb, abandon.getCurrency());
            sb.append(",");
            //通用set 拼接
            AppendSqlStore.set(sb, abandon);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }


    public String getAbandonInfo(SalesAmazonFbaAbandon abandon) throws IllegalAccessException {
        SQL sql = new SQL();
        String alias = "don";
        sql.SELECT("ps.sku,s.`shop_name`, cs.`site_name`,\n" +
                "`fba_id`,`date`,`order_id`,`order_type`,`order_status`,\n" +
                "`last_updated_date`, `abandon_sku`,`fn_sku`,\n" +
                "`disposition`,`requested_quantity`, `cancelled_quantity`,`disposed_quantity`,\n" +
                "`shipped_quantity`,`in_process_quantity`,`removal_fee`," + alias + ".`currency`,\n " +
                "" + ProviderSqlStore.statusV(alias) + "" +
                "FROM `sales_amazon_fba_abandon` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_shop` AS s ON s.`shop_id`=" + alias + ".`shop_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_site` AS cs ON cs.`site_id` = " + alias + ".`site_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = " + alias + ".`sku_id`");
        // sku
        AppendSqlStore.sqlWhere(abandon.getSku(), "ps.`sku`", sql, Constants.SELECT);
        //更新日期
        if (abandon.getLastUpdatedDates() != null && (abandon.getLastUpdatedDates().size() > 0)) {
            sql.WHERE("date  " + abandon.getLastUpdatedDates().get(0) + " AND " + abandon.getLastUpdatedDates().get(1) + "");
        }
        Field[] fields = abandon.getClass().getDeclaredFields();
        FieldStore.query(fields, abandon.getNameList(), abandon, sql);
        ProviderSqlStore.selectUploadStatus(sql, abandon, alias);
        return sql.toString();
    }
}
