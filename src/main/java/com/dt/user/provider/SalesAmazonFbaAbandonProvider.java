package com.dt.user.provider;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaAbandon;
import com.dt.user.store.AppendSqlStore;
import com.dt.user.store.ProviderSqlStore;
import com.dt.user.toos.Constant;
import com.dt.user.toos.Constants;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName SalesAmazonFbaAbandonProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/9 13:16
 **/
public class SalesAmazonFbaAbandonProvider {


    public String getAbandonInfo(SalesAmazonFbaAbandon abandon) {
        SQL sql = new SQL();
        sql.SELECT("ps.`sku`,s.`shop_name`, cs.`site_name`,\n" +
                " `a_id`,`fba_shipment_id`,`abandon_sku`,\n" +
                "  `fn_sku`, `product_name`, `quantity`, `fc`,\n" +
                "  `aw_id`," + ProviderSqlStore.statusV + "" +
                "FROM sales_amazon_fba_abandon AS ad \n");
        sql.INNER_JOIN("`basic_public_shop` AS s ON s.`shop_id`=ad.`shop_id`");
        sql.INNER_JOIN("`basic_public_site` AS cs ON cs.`site_id` = ad.`site_id`");
        sql.INNER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = ad.`sku_id`");
        // sku
        AppendSqlStore.sqlWhere(abandon.getSku(), "ps.`sku`", sql, Constants.SELECT);
        //FBA号
        AppendSqlStore.sqlWhere(abandon.getFbaShipmentId(), "`fba_shipment_id`", sql, Constants.SELECT);
        // FBA SKU
        AppendSqlStore.sqlWhere(abandon.getAbandonSku(), "`abandon_sku`", sql, Constants.SELECT);
        //fn_sku
        AppendSqlStore.sqlWhere(abandon.getFnSku(), "`fn_sku`", sql, Constants.SELECT);
        //产品名称
        AppendSqlStore.sqlWhere(abandon.getProductName(), "`product_name`", sql, Constants.SELECT);
        //接收数量
        if (abandon.getQuantity() != null) {
            sql.WHERE("quantity=#{quantity}");
        }
        //亚马逊仓库代码
        AppendSqlStore.sqlWhere(abandon.getFc(), "`fc`", sql, Constants.SELECT);
        //亚马逊仓库ID
        if (abandon.getAwId() != null) {
            sql.WHERE("aw_id=#{awId}");
        }
        ProviderSqlStore.saveUploadStatus(sql, abandon);
        return sql.toString();
    }

}
