package com.dt.project.provider;


import com.dt.project.model.financial.FinancialSalesBalance;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.toos.Constants;
import com.dt.project.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class FinancialSalesBalanceProvider {

    @SuppressWarnings("unchecked")
    public String addInfo(Map<String, Object> infoMap) {
        List<FinancialSalesBalance> fsbList = (List<FinancialSalesBalance>) infoMap.get("fsbList");
        Integer menuId = (Integer) infoMap.get("tbId");
        String db = "financial_sales_amazon_balance";
        if (menuId == Constants.FINANCE_ID_YY) {
            db = "sales_amazon_fba_balance";
        }
        // sql前缀
        String prefix = "insert into " + db +
                "(`date`,`shop_id`,`site_id`,`settlement_id`," +
                "`payment_type_id`,`type`,`order_id`,`financial_sku`," +
                "`sku_id`,`description`,`o_quantity`,`quantity`," +
                "`refund_quantity`,`order_qty`,`adjustment_qty`,`marketplace`," +
                "`fulfillment`,`city`,`state`,`postal`," +
                "`sales`,`sale_price`,`pre_sale_price`,`std_sale_price`," +
                "`new_shipping_credits`,`shipping_credits`,`giftwrap_credits`,`promotional_rebates`," +
                "`sales_tax`,`marketplace_facilitator_tax`,`selling_fees`,`fba_fee`," +
                "`other_transaction_fees`, `other`,`total`,`service_fee`," +
                "`transfer`,`adjustment`,`new_promotional_rebates`,`new_shipping_fba`," +
                "`std_product_sales`,`std_sales_original`,`std_sales_add`,`std_sales_minus`," +
                "`std_fba`,`std_fbas`,`std_fba_original`,`lightning_deal_fee`," +
                "`fba_inventory_fee`,`point_fee`,`low_value_goods`," +
                "`new_other`,`vat`,`sales_for_tax`,`service_fee_tax`," +
                "" + ProviderSqlStore.setV() + ")" +
                " values";
        // 保存sql后缀
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        for (FinancialSalesBalance fsb : fsbList) {
            // 构建sql后缀
            sb.append("(").append(fsb.getDate()).append(",").append(fsb.getShopId()).append(",").append(fsb.getSiteId()).append(",");
            //#
            StrUtils.appBuider(sb, fsb.getSettlementId());
            sb.append(",");
            sb.append(fsb.getPaymentTypeId());
            //#
            sb.append(",");
            StrUtils.appBuider(sb, fsb.getType());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, fsb.getOrderId());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, fsb.getFinancialSku());
            sb.append(",");
            sb.append(fsb.getSkuId());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, fsb.getDescription());
            sb.append(",");
            sb.append(fsb.getoQuantity()).append(",").append(fsb.getQuantity()).append(",").append(fsb.getRefundQuantity()).append(",").append(fsb.getOrderQty()).append(",").append(fsb.getAdjustmentQty()).append(",");
            //#
            StrUtils.appBuider(sb, fsb.getMarketplace());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, fsb.getFulfillment());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, fsb.getCity());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, fsb.getState());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, fsb.getPostal());
            sb.append(",");
            sb.append(fsb.getSales()).append(",").append(fsb.getSalePrice()).
                    append(",").append(fsb.getPreSalePrice()).append(",").
                    append(fsb.getStdSalePrice()).append(",").
                    append(fsb.getNewShippingCredits()).append(",").
                    append(fsb.getShippingCredits()).append(",").
                    append(fsb.getGiftwrapCredits()).append(",").
                    append(fsb.getPromotionalRebates()).append(",").
                    append(fsb.getSalesTax()).append(",").append(fsb.getMarketplaceFacilitatorTax()).append(",").
                    append(fsb.getSellingFees()).append(",").append(fsb.getFbaFee()).append(",").append(fsb.getOtherTransactionFees()).
                    append(",").append(fsb.getOther()).append(",").append(fsb.getTotal()).append(",").append(fsb.getServiceFee()).append(",").
                    append(fsb.getTransfer()).append(",").append(fsb.getAdjustment()).append(",").append(fsb.getNewPromotionalRebates()).
                    append(",").append(fsb.getNewShippingFba()).append(",").append(fsb.getStdProductSales()).append(",").
                    append(fsb.getStdSalesOriginal()).append(",").append(fsb.getStdSalesAdd()).append(",").append(fsb.getStdSalesMinus()).
                    append(",").append(fsb.getStdFba()).append(",").append(fsb.getStdFbas()).append(",").append(fsb.getStdFbaOriginal()).
                    append(",").append(fsb.getLightningDealFee()).append(",").append(fsb.getFbaInventoryFee()).append(",");
            sb.append(fsb.getPointFee()).append(",").append(fsb.getLowValueGoods()).append(",");
            sb.append(fsb.getNewOther()).append(",").append(fsb.getVat()).append(",").append(fsb.getSalesForTax()).append(",").append(fsb.getServiceFeeTax()).append(",");
            AppendSqlStore.set(sb, fsb);
        }
        // 构建完整sql
        return sb.toString().substring(0, sb.length() - 1);
    }

    public String getFbsInfo(FinancialSalesBalance fbs) {
        String table = AppendSqlStore.setSqlTable(fbs.getSqlMode(), "`financial_sales_amazon_balance`", "`sales_amazon_fba_balance`");
        SQL sql = new SQL();
        String alias = "sab";
        sql.SELECT("`balance_id`, `years`,`pediod`,`date`,s.`shop_name`,cs.`site_name`,\n" +
                "`settlement_id`,`payment_type_id`,`type`,`order_id`,`financial_sku`, `sku_id`,`o_quantity`,\n" +
                "`quantity`,`refund_quantity`,`order_qty`,`adjustment_qty`,`marketplace`,\n" +
                "`fulfillment`,`city`,`state`,`postal`, `sales`,`sale_price`,`pre_sale_price`,`std_sale_price`,`new_shipping_credits`,\n" +
                "`shipping_credits`,`giftwrap_credits`,`promotional_rebates`,\n" +
                "`sales_tax`,`marketplace_facilitator_tax`,`low_value_goods`,\n" +
                "`point_fee`,`selling_fees`,`fba_fee`,`other_transaction_fees`,`other`,\n" +
                "`new_other`,`total`,`service_fee`,`transfer`,`adjustment`,`new_promotional_rebates`,`new_shipping_fba`,\n" +
                "`std_product_sales`,`std_sales_original`,`std_sales_add`,`std_sales_minus`,`std_fba`,`std_fbas`,`std_fba_original`,\n" +
                "`lightning_deal_fee`,`fba_inventory_fee`," + alias + ".`vat`,`sales_for_tax`,`service_fee_tax`," + ProviderSqlStore.statusV(alias) + "" +
                "FROM " + table + " AS " + alias + " \n");


        //这里这样写是性能优化后的sql
        //  "FROM " + table + " AS " + alias + "," + ProviderSqlStore.fsbJoinTable(sql, alias) + " \n");

        ProviderSqlStore.joinTable(sql, alias);
        //结算号
        AppendSqlStore.sqlWhere(fbs.getSettlementId(), "settlement_id", sql, Constants.SELECT);
        //付款类型
        AppendSqlStore.sqlWhere(fbs.getPaymentTypeId(), "payment_type_id", sql, Constants.SELECT);
        //类型
        AppendSqlStore.sqlWhere(fbs.getType(), "type", sql, Constants.SELECT);
        //订单号
        AppendSqlStore.sqlWhere(fbs.getOrderId(), "order_id", sql, Constants.SELECT);
        // 链表sku
        AppendSqlStore.sqlWhere(fbs.getSkuId(), "`sku_id`", sql, Constants.SELECT);
        //自表sku
        AppendSqlStore.sqlWhere(fbs.getFinancialSku(), "financial_sku", sql, Constants.SELECT);
        //产品描述
        AppendSqlStore.sqlWhere(fbs.getDescription(), "description", sql, Constants.SELECT);
        //原始数量
        AppendSqlStore.sqlWhere(fbs.getoQuantity(), "o_quantity", sql, Constants.SELECT);
        //发货数量
        AppendSqlStore.sqlWhere(fbs.getQuantity(), "quantity", sql, Constants.SELECT);
        //退货数量
        AppendSqlStore.sqlWhere(fbs.getRefundQuantity(), "refund_quantity", sql, Constants.SELECT);
        //订单数量
        AppendSqlStore.sqlWhere(fbs.getOrderQty(), "order_qty", sql, Constants.SELECT);
        //调整数量
        AppendSqlStore.sqlWhere(fbs.getAdjustmentQty(), "adjustment_qty", sql, Constants.SELECT);
        //市场
        AppendSqlStore.sqlWhere(fbs.getMarketplace(), "marketplace", sql, Constants.SELECT);
        //运输
        AppendSqlStore.sqlWhere(fbs.getFulfillment(), "fulfillment", sql, Constants.SELECT);
        //城市
        AppendSqlStore.sqlWhere(fbs.getCity(), "city", sql, Constants.SELECT);
        //州
        AppendSqlStore.sqlWhere(fbs.getState(), "state", sql, Constants.SELECT);
        //邮编
        AppendSqlStore.sqlWhere(fbs.getPostal(), "postal", sql, Constants.SELECT);
        //金额
        AppendSqlStore.sqlWhere(fbs.getSales(), "sales", sql, Constants.SELECT);
        //销售单价
        AppendSqlStore.sqlWhere(fbs.getSalePrice(), "sale_price", sql, Constants.SELECT);
        //上期销售价
        AppendSqlStore.sqlWhere(fbs.getPreSalePrice(), "pre_sale_price", sql, Constants.SELECT);
        //标准售价
        AppendSqlStore.sqlWhere(fbs.getStdSalePrice(), "std_sale_price", sql, Constants.SELECT);
        //新运费
        AppendSqlStore.sqlWhere(fbs.getNewShippingCredits(), "new_shipping_credits", sql, Constants.SELECT);
        //运费
        AppendSqlStore.sqlWhere(fbs.getShippingCredits(), "shipping_credits", sql, Constants.SELECT);
        //礼物卡
        AppendSqlStore.sqlWhere(fbs.getGiftwrapCredits(), "giftwrap_credits", sql, Constants.SELECT);
        //促销折扣
        AppendSqlStore.sqlWhere(fbs.getPromotionalRebates(), "promotional_rebates", sql, Constants.SELECT);
        //销售税
        AppendSqlStore.sqlWhere(fbs.getSalesTax(), "sales_tax", sql, Constants.SELECT);
        //市场服务税
        AppendSqlStore.sqlWhere(fbs.getMarketplaceFacilitatorTax(), "marketplace_facilitator_tax", sql, Constants.SELECT);
        //低价值商品(澳洲)
        AppendSqlStore.sqlWhere(fbs.getLowValueGoods(), "low_value_goods", sql, Constants.SELECT);
        //积分费用(日本ポイントの費用)
        AppendSqlStore.sqlWhere(fbs.getPointFee(), "point_fee", sql, Constants.SELECT);
        //销售费用
        AppendSqlStore.sqlWhere(fbs.getSellingFees(), "selling_fees", sql, Constants.SELECT);
        //FBA费用
        AppendSqlStore.sqlWhere(fbs.getFbaFee(), "fba_fee", sql, Constants.SELECT);
        //其他交易费
        AppendSqlStore.sqlWhere(fbs.getOtherTransactionFees(), "other_transaction_fees", sql, Constants.SELECT);
        //其他
        AppendSqlStore.sqlWhere(fbs.getOther(), "other", sql, Constants.SELECT);
        //总计
        AppendSqlStore.sqlWhere(fbs.getTotal(), "total", sql, Constants.SELECT);
        //广告费
        AppendSqlStore.sqlWhere(fbs.getOther(), "service_fee", sql, Constants.SELECT);
        //转账
        AppendSqlStore.sqlWhere(fbs.getTransfer(), "transfer", sql, Constants.SELECT);
        //调整
        AppendSqlStore.sqlWhere(fbs.getAdjustment(), "adjustment", sql, Constants.SELECT);
        //新促销折扣
        AppendSqlStore.sqlWhere(fbs.getNewPromotionalRebates(), "new_promotional_rebates", sql, Constants.SELECT);
        //运费_FBA
        AppendSqlStore.sqlWhere(fbs.getNewShippingFba(), "new_shipping_fba", sql, Constants.SELECT);
        //标准产品售价
        AppendSqlStore.sqlWhere(fbs.getStdProductSales(), "std_product_sales", sql, Constants.SELECT);
        //原始标准售价
        AppendSqlStore.sqlWhere(fbs.getStdSalesOriginal(), "std_sales_original", sql, Constants.SELECT);
        //标准售价增加
        AppendSqlStore.sqlWhere(fbs.getStdSalesAdd(), "std_sales_add", sql, Constants.SELECT);
        //标准售价降低
        AppendSqlStore.sqlWhere(fbs.getStdSalesAdd(), "std_sales_minus", sql, Constants.SELECT);
        //标准FBA
        AppendSqlStore.sqlWhere(fbs.getStdFba(), "std_fba", sql, Constants.SELECT);
        //标准FBA费
        AppendSqlStore.sqlWhere(fbs.getStdFbas(), "std_fbas", sql, Constants.SELECT);
        //原始标准FBA费
        AppendSqlStore.sqlWhere(fbs.getStdFbaOriginal(), "std_fba_original", sql, Constants.SELECT);
        //秒杀费
        AppendSqlStore.sqlWhere(fbs.getLightningDealFee(), "lightning_deal_fee", sql, Constants.SELECT);
        //FBA仓储费
        AppendSqlStore.sqlWhere(fbs.getFbaInventoryFee(), "fba_inventory_fee", sql, Constants.SELECT);
        //这里这样写是性能优化后的sql
//        //店铺名称
//        if (fbs.getShopId() != null) {
//            sql.WHERE(alias + ".shop_id=#{shopId}");
//        }
//        //站点名称
//        if (fbs.getSiteId() != null) {
//            sql.WHERE(alias + ".site_id=#{siteId}");
//        }
//        //文件已有时间
//        if (fbs.getDates() != null && (fbs.getDates().size() > 0)) {
//            sql.WHERE(alias + ".date  " + fbs.getDates().get(0) + " AND " + fbs.getDates().get(1) + "");
//        }
//        //备注
//        if (StringUtils.isNotBlank(fbs.getRemark())) {
//            sql.WHERE(alias + ".remark=#{remark}");
//        }
//        //状态
//        if (fbs.getStatus() != null) {
//            sql.WHERE(alias + ".status=#{status}");
//        }
//        //创建时间
//        if (fbs.getCreateDates() != null && (fbs.getCreateDates().size() > 0)) {
//            sql.WHERE(alias + ".create_date BETWEEN  " + fbs.getCreateDates().get(0) + " AND " + fbs.getCreateDates().get(1) + "");
//        }
//        sql.WHERE(alias + ".del_or_not=0");
        ProviderSqlStore.selectUploadStatus(sql, fbs, alias);
        return sql.toString();
    }
}
