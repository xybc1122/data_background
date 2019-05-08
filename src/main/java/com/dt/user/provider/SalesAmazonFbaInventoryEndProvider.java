package com.dt.user.provider;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaInventoryEnd;
import com.dt.user.store.AppendSqlStore;
import com.dt.user.store.ProviderSqlStore;
import com.dt.user.toos.Constants;
import com.dt.user.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SalesAmazonFbaInventoryEndProvider {

    @SuppressWarnings("unchecked")
    public String addEndList(Map<String, Object> mapStr) {
        List<SalesAmazonFbaInventoryEnd> endList = (List<SalesAmazonFbaInventoryEnd>) mapStr.get("endList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `sales_amazon_fba_Inventory_End`\n" +
                "(`date`,`shop_id`,`site_id`,`inv_sku`,`fn_sku`,`sku_id`,\n" +
                "`product_name`,`quantity`,`fc`,`aw_id`,`disposition`,`country`,\n" +
                "`create_date`,`create_user`,`recordingId`)values");
        for (SalesAmazonFbaInventoryEnd end : endList) {
            sb.append("(").append(end.getDate()).append(",").append(end.getShopId()).append(",").append(end.getSiteId()).append(",");
            StrUtils.appBuider(sb, end.getInvSku());
            sb.append(",");
            StrUtils.appBuider(sb, end.getFnSku());
            sb.append(",").append(end.getSkuId()).append(",");
            StrUtils.appBuider(sb, end.getProductName());
            sb.append(",").append(end.getQuantity()).append(",");
            StrUtils.appBuider(sb, end.getFc());
            sb.append(",").append(end.getAwId()).append(",");
            StrUtils.appBuider(sb, end.getDisposition());
            sb.append(",");
            StrUtils.appBuider(sb, end.getCountry());
            sb.append(",");
            AppendSqlStore.set(sb, end);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public String getEndInfo(SalesAmazonFbaInventoryEnd inv) {
        SQL sql = new SQL();
        String alias = "re";
        sql.SELECT("ps.`sku`,s.`shop_name`, cs.`site_name`,\n" +
                "`date`,`inv_id`,`inv_sku`,`fn_sku`,\n" +
                "`quantity`,`fc`,`aw_id`,`disposition`,`country`," + ProviderSqlStore.statusV(alias) + "" +
                "FROM sales_amazon_fba_Inventory_End AS " + alias + " \n");
        sql.LEFT_OUTER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = " + alias + ".`sku_id`");
        ProviderSqlStore.joinTable(sql, alias);
        // sku
        AppendSqlStore.sqlWhere(inv.getSku(), "ps.`sku`", sql, Constants.SELECT);
        // inv_sku
        AppendSqlStore.sqlWhere(inv.getInvSku(), "`inv_sku`", sql, Constants.SELECT);
        //fn_sku
        AppendSqlStore.sqlWhere(inv.getFnSku(), "`fn_sku`", sql, Constants.SELECT);
        //产品名称
        AppendSqlStore.sqlWhere(inv.getProductName(), "`product_name`", sql, Constants.SELECT);
        //接收数量
        if (inv.getQuantity() != null) {
            sql.WHERE("quantity=#{quantity}");
        }
        //亚马逊仓库代码
        AppendSqlStore.sqlWhere(inv.getFc(), "`fc`", sql, Constants.SELECT);
        //亚马逊仓库ID
        if (inv.getAwId() != null) {
            sql.WHERE("aw_id=#{awId}");
        }
        //未知
        AppendSqlStore.sqlWhere(inv.getDisposition(), "`disposition`", sql, Constants.SELECT);
        //未知
        AppendSqlStore.sqlWhere(inv.getCountry(), "`country`", sql, Constants.SELECT);
        ProviderSqlStore.selectUploadStatus(sql, inv, alias);
        return sql.toString();
    }
}
