package com.dt.user.provider;

import com.dt.user.model.SalesAmazon.SalesAmazonAdStr;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaAbandon;
import com.dt.user.store.AppendSqlStore;
import com.dt.user.store.ProviderSqlStore;
import com.dt.user.toos.Constant;
import com.dt.user.toos.Constants;
import com.dt.user.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

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
                "(`date`,`shop_id`,`site_id`,`area_id`,`order_id`,\n" +
                "`order_type`,`order_status`,`last_updated_date`,`abandon_sku`,\n" +
                "`fn_sku`,`disposition`, `requested_quantity`,`cancelled_quantity`,\n" +
                "`disposed_quantity`, `shipped_quantity`,`in_process_quantity`,`removal_fee`, `currency`,\n" +
                "`create_date`,`create_user`,`recording_id`) values");
        for (SalesAmazonFbaAbandon abandon : abandons) {
            sb.append("(").append(abandon.getDate()).append(",").append(abandon.getShopId()).append(",").
                    append(abandon.getSiteId()).append(",").append(abandon.getAreaId()).append(",");
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


    public String getAbandonInfo(SalesAmazonFbaAbandon abandon) {
        SQL sql = new SQL();
        sql.SELECT("ps.`sku`,s.`shop_name`, cs.`site_name`,\n" +
                " `a_id`,`fba_shipment_id`,`abandon_sku`,\n" +
                "  `fn_sku`, `product_name`, `quantity`, `fc`,\n" +
                "  `aw_id`," + ProviderSqlStore.statusV + "" +
                "FROM sales_amazon_fba_abandon AS ad \n");
        sql.INNER_JOIN("`basic_public_shop` AS s ON s.`shop_id`=ad.`shop_id`");
        sql.INNER_JOIN("`basic_public_site` AS cs ON cs.`site_id` = ad.`site_id`");
        // sku
        AppendSqlStore.sqlWhere(abandon.getSku(), "ps.`sku`", sql, Constants.SELECT);

        // FBA SKU
        AppendSqlStore.sqlWhere(abandon.getAbandonSku(), "`abandon_sku`", sql, Constants.SELECT);
        //fn_sku
        AppendSqlStore.sqlWhere(abandon.getFnSku(), "`fn_sku`", sql, Constants.SELECT);

        ProviderSqlStore.saveUploadStatus(sql, abandon);
        return sql.toString();
    }

}
