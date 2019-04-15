package com.dt.user.provider;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaReceivestock;
import com.dt.user.store.AppendSqlStore;
import com.dt.user.store.ProviderSqlStore;
import com.dt.user.toos.Constants;
import com.dt.user.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SalesAmazonFbaReceivestockProvider {


    @SuppressWarnings("unchecked")
    public String addReceives(Map<String, Object> mapStr) {
        List<SalesAmazonFbaReceivestock> receivesList = (List<SalesAmazonFbaReceivestock>) mapStr.get("receivesList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO`sales_amazon_fba_receivestock`\n" +
                "(`date`,`shop_id`,`site_id`,`fba_shipment_id`,`rec_sku`,`fn_sku`,\n" +
                "`sku_id`,`product_name`,`quantity`,`fc`,`aw_id`,`create_date`,`create_user`,`recordingId`)values");
        for (SalesAmazonFbaReceivestock receives : receivesList) {
            sb.append("(").append(receives.getDate()).append(",").append(receives.getShopId()).append(",").append(receives.getSiteId()).append(",");
            StrUtils.appBuider(sb, receives.getFbaShipmentId());
            sb.append(",");
            StrUtils.appBuider(sb, receives.getRecSku());
            sb.append(",");
            StrUtils.appBuider(sb, receives.getFnSku());
            sb.append(",");
            sb.append(receives.getSkuId()).append(",");
            StrUtils.appBuider(sb, receives.getProductName());
            sb.append(",");
            sb.append(receives.getQuantity()).append(",");
            StrUtils.appBuider(sb, receives.getFc());
            sb.append(",");
            sb.append(receives.getAwId()).append(",");
            AppendSqlStore.set(sb, receives);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }


    public String getRecInfo(SalesAmazonFbaReceivestock rec) {
        SQL sql = new SQL();
        sql.SELECT("ps.`sku`,s.`shop_name`, cs.`site_name`,\n" +
                "`rec_id`, `date`,`fba_shipment_id`,`rec_sku`,\n" +
                "  `fn_sku`,`product_name`,`quantity`,`fc`,`aw_id`," + ProviderSqlStore.statusV + "" +
                "FROM sales_amazon_fba_receivestock AS rec \n");
        sql.INNER_JOIN("`basic_public_shop` AS s ON s.`shop_id`=rec.`shop_id`");
        sql.INNER_JOIN("`basic_public_site` AS cs ON cs.`site_id` = rec.`site_id`");
        sql.INNER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = rec.`sku_id`");
        // sku
        AppendSqlStore.sqlWhere(rec.getSku(), "ps.`sku`", sql, Constants.SELECT);
        //FBA号
        AppendSqlStore.sqlWhere(rec.getFbaShipmentId(), "`fba_shipment_id`", sql, Constants.SELECT);
        //recSku
        AppendSqlStore.sqlWhere(rec.getRecSku(), "`rec_sku`", sql, Constants.SELECT);
        //fnSku
        AppendSqlStore.sqlWhere(rec.getFnSku(), "`fn_sku`", sql, Constants.SELECT);
        //产品名称
        AppendSqlStore.sqlWhere(rec.getProductName(), "`product_name`", sql, Constants.SELECT);
        //接收数量
        if (rec.getQuantity() != null) {
            sql.WHERE("quantity=#{quantity}");
        }
        //亚马逊仓库代码
        AppendSqlStore.sqlWhere(rec.getFc(), "`fc`", sql, Constants.SELECT);
        //亚马逊仓库ID
        if (rec.getAwId() != null) {
            sql.WHERE("aw_id=#{awId}");
        }
        ProviderSqlStore.saveUploadStatus(sql, rec);
        return sql.toString();
    }
}

