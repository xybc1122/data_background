package com.dt.project.provider;

import com.dt.project.model.salesAmazon.SalesAmazonFbaRefund;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import com.dt.project.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SalesAmazonFbaRefundProvider {


    @SuppressWarnings("unchecked")
    public String addRefund(Map<String, Object> mapStr) {
        List<SalesAmazonFbaRefund> refundList = (List<SalesAmazonFbaRefund>) mapStr.get("refundList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `sales_amazon_fba_refund`" +
                "(`date`,`purchase_date`,`shop_id`,`site_id`,`order_id`,`ref_sku`,`s_asin`,\n" +
                "`fn_sku`,`sku_id`,`p_name`,`quantity`,`fc`,`aw_id`,`detailed_disposition`,\n" +
                "`reason`,`refund_status`,`license_plate_number`,`customer_remarks`," +
                "`create_date`,`create_user`,`recording_id`)values");
        for (SalesAmazonFbaRefund refund : refundList) {
            sb.append("(" + refund.getDate() + "," + refund.getPurchaseDate() + ","
                    + refund.getShopId() + "," + refund.getSiteId());
            sb.append(",");
            StrUtils.appBuider(sb, refund.getOrderId());
            sb.append(",");
            StrUtils.appBuider(sb, refund.getRefSku());
            sb.append(",");
            StrUtils.appBuider(sb, refund.getsAsin());
            sb.append(",");
            StrUtils.appBuider(sb, refund.getFnSku());
            sb.append(",").append(refund.getSkuId()).append(",");

            StrUtils.appBuider(sb, refund.getpName());

            sb.append(",").append(refund.getQuantity()).append(",");

            StrUtils.appBuider(sb, refund.getFc());

            sb.append(",").append(refund.getAwId()).append(",");
            StrUtils.appBuider(sb, refund.getDetailedDisposition());
            sb.append(",");
            StrUtils.appBuider(sb, refund.getReason());
            sb.append(",");
            StrUtils.appBuider(sb, refund.getRefundStatus());
            sb.append(",");
            StrUtils.appBuider(sb, refund.getLicensePlateNumber());
            sb.append(",");
            StrUtils.appBuider(sb, refund.getCustomerRemarks());
            sb.append(",");
            AppendSqlStore.set(sb, refund);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }


    public String getRefundInfo(SalesAmazonFbaRefund refund) {
        SQL sql = new SQL();
        String alias = "re";
        sql.SELECT("ps.`sku`,s.`shop_name`, cs.`site_name`,\n" +
                "`ref_id`, `purchase_date`,\n" +
                "`order_id`, `ref_sku`, re.`s_asin`,`fn_sku`,\n" +
                "`p_name`, `quantity`, `fc`, `aw_id`,\n" +
                "`detailed_disposition`,`reason`,`refund_status`,\n" +
                "`license_plate_number`,`customer_remarks`," + ProviderSqlStore.statusV(alias) + "" +
                "FROM sales_amazon_fba_refund AS " + alias + " \n");
        sql.LEFT_OUTER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = " + alias + ".`sku_id`");
        ProviderSqlStore.joinTable(sql, alias);
        // sku
        AppendSqlStore.sqlWhere(refund.getSku(), "ps.`sku`", sql, Constants.SELECT,alias);
        //下单日期
        if (refund.getPurchaseDates() != null && (refund.getPurchaseDates().size() > 0)) {
            sql.WHERE("purchase_date  BETWEEN " + refund.getPurchaseDates().get(0) + " AND " + refund.getPurchaseDates().get(1) + "");
        }
        //订单号
        AppendSqlStore.sqlWhere(refund.getOrderId(), "order_id", sql, Constants.SELECT,alias);
        //SKU
        AppendSqlStore.sqlWhere(refund.getRefSku(), "ref_sku", sql, Constants.SELECT,alias);
        //子ASIN
        AppendSqlStore.sqlWhere(refund.getsAsin(), "re.`s_asin`", sql, Constants.SELECT,alias);
        //fnsku
        AppendSqlStore.sqlWhere(refund.getFnSku(), "`fn_sku`", sql, Constants.SELECT,alias);
        //产品名称
        AppendSqlStore.sqlWhere(refund.getpName(), "`p_name`", sql, Constants.SELECT,alias);
        //退货数量
        AppendSqlStore.sqlWhere(refund.getQuantity(), "`quantity`", sql, Constants.SELECT,alias);
        //亚马逊仓库代码
        AppendSqlStore.sqlWhere(refund.getFc(), "`fc`", sql, Constants.SELECT,alias);
        //亚马逊仓库ID
        AppendSqlStore.sqlWhere(refund.getAwId(), "`aw_id`", sql, Constants.SELECT,alias);
        //处理细节
        AppendSqlStore.sqlWhere(refund.getDetailedDisposition(), "`detailed_disposition`", sql, Constants.SELECT,alias);
        //原因
        AppendSqlStore.sqlWhere(refund.getReason(), "`reason`", sql, Constants.SELECT,alias);
        //退货状态
        AppendSqlStore.sqlWhere(refund.getRefundStatus(), "`refund_status`", sql, Constants.SELECT,alias);
        //平台号
        AppendSqlStore.sqlWhere(refund.getLicensePlateNumber(), "`license_plate_number`", sql, Constants.SELECT,alias);
        //客户备注
        AppendSqlStore.sqlWhere(refund.getCustomerRemarks(), "`customer_remarks`", sql, Constants.SELECT,alias);
        ProviderSqlStore.selectUploadStatus(sql, refund, alias);
        return sql.toString();
    }
}
