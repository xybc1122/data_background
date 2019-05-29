package com.dt.project.provider;

import com.dt.project.model.salesAmazon.SalesAmazonFbaReceivestock;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import com.dt.project.utils.StrUtils;
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
        String alias = "rec";
        sql.SELECT("ps.`sku`,s.`shop_name`, cs.`site_name`,\n" +
                "`rec_id`, `date`,`fba_shipment_id`,`rec_sku`,\n" +
                "  `fn_sku`,`product_name`,`quantity`,`fc`,`aw_id`," + ProviderSqlStore.statusV(alias) + "" +
                "FROM sales_amazon_fba_receivestock AS " + alias + " \n");
        sql.LEFT_OUTER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = " + alias + ".`sku_id`");
        ProviderSqlStore.joinTable(sql, alias);
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
        ProviderSqlStore.selectUploadStatus(sql, rec, alias);
        return sql.toString();
    }
}

