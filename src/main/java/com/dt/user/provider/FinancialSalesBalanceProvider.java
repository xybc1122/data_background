package com.dt.user.provider;


import com.dt.user.model.FinancialSalesBalance;
import com.dt.user.store.ProviderSqlStore;
import com.dt.user.store.AppendSqlStore;
import com.dt.user.toos.Constants;
import com.dt.user.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
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
                "(`date`,`shop_id`,`site_id`,`settlemen_id`," +
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
                "`fba_inventory_fee`,`point_fee`,`low_value_goods`,`create_date`,`create_user`," +
                "`recording_id`)" +
                " values";
        // 保存sql后缀
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        for (FinancialSalesBalance fsb : fsbList) {
            // 构建sql后缀
            sb.append("(").append(fsb.getDate()).append(",").append(fsb.getShopId()).append(",").append(fsb.getSiteId()).append(",");
            //#
            StrUtils.appBuider(sb, fsb.getSettlemenId());
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
            AppendSqlStore.set(sb, fsb);
        }
        // 构建完整sql
        return sb.toString().substring(0, sb.length() - 1);
    }

    public String getFbsInfo(FinancialSalesBalance fbs) {
        String table = AppendSqlStore.setSqlTable(fbs, "`financial_sales_amazon_balance`", "`sales_amazon_fba_balance`");
        SQL sql = new SQL();
        sql.SELECT("ps.`sku`,s.`shop_name`, cs.`site_name`,\n" +
                "`financial_sku`,`settlemen_id`,`date`, `payment_type_id`, `type`, `order_id`,\n" +
                "`description`,`o_quantity`,`quantity`,\n" +
                "`refund_quantity`,`order_qty`,`adjustment_qty`,\n" +
                "`marketplace`, `fulfillment`, `city`,\n" +
                "`state`,`postal`,`sales`, `sale_price`,\n" +
                "`pre_sale_price`, `std_sale_price`, `new_shipping_credits`,\n" +
                "`shipping_credits`,`giftwrap_credits`, `promotional_rebates`,\n" +
                "`sales_tax`,`marketplace_facilitator_tax`, `low_value_goods`,`point_fee`,\n" +
                "`selling_fees`, `fba_fee`,`other_transaction_fees`,\n" +
                "`other`, `total`,`service_fee`,\n" +
                "`transfer`,`adjustment`, `new_promotional_rebates`,\n" +
                "`new_shipping_fba`, `std_product_sales`, `std_sales_original`, `std_sales_add`,\n" +
                "`std_sales_minus`,`std_fba`,`std_fbas`,`std_fba_original`,`lightning_deal_fee`," +
                "`fba_inventory_fee`," + ProviderSqlStore.statusV + "" +
                "FROM " + table + " AS sab \n");
        sql.INNER_JOIN("`basic_public_shop` AS s ON s.`shop_id`=sab.`shop_id`");
        sql.INNER_JOIN("`basic_public_site` AS cs ON cs.`site_id` = sab.`site_id`");
        sql.INNER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = sab.`sku_id`");
        //结算号
        if (StringUtils.isNotBlank(fbs.getSettlemenId())) {
            sql.WHERE("POSITION('" + fbs.getSettlemenId() + "' IN `settlemen_id`)");
        }
        //付款类型
        if (fbs.getPaymentTypeId() != null) {
            sql.WHERE("`payment_type_id`=#{paymentTypeId}");
        }
        //类型
        if (StringUtils.isNotBlank(fbs.getType())) {
            sql.WHERE("POSITION('" + fbs.getType() + "' IN `type`)");
        }
        //订单号
        if (StringUtils.isNotBlank(fbs.getOrderId())) {
            sql.WHERE("POSITION('" + fbs.getOrderId() + "' IN `order_id`)");
        }
        // 链表sku
        if (StringUtils.isNotBlank(fbs.getSku())) {
            sql.WHERE("POSITION('" + fbs.getSku() + "' IN ps.`sku`)");
        }
        //自表sku
        if (StringUtils.isNotBlank(fbs.getFinancialSku())) {
            sql.WHERE("POSITION('" + fbs.getFinancialSku() + "' IN financial_sku)");
        }
        //产品描述
        if (StringUtils.isNotBlank(fbs.getDescription())) {
            sql.WHERE("POSITION('" + fbs.getDescription() + "' IN description)");
        }
        //原始数量
        if (fbs.getoQuantity() != null) {
            sql.WHERE("`o_quantity`=#{oQuantity}");
        }
        //发货数量
        if (fbs.getQuantity() != null) {
            sql.WHERE("`quantity`=#{quantity}");
        }
        //退货数量
        if (fbs.getRefundQuantity() != null) {
            sql.WHERE("`refund_quantity`=#{refundQuantity}");
        }
        //订单数量
        if (fbs.getOrderQty() != null) {
            sql.WHERE("`order_qty`=#{orderQty}");
        }
        //调整数量
        if (fbs.getAdjustmentQty() != null) {
            sql.WHERE("`adjustment_qty`=#{adjustmentQty}");
        }
        //市场
        if (StringUtils.isNotBlank(fbs.getMarketplace())) {
            sql.WHERE("POSITION('" + fbs.getMarketplace() + "' IN marketplace)");
        }
        //运输
        if (StringUtils.isNotBlank(fbs.getFulfillment())) {
            sql.WHERE("POSITION('" + fbs.getFulfillment() + "' IN fulfillment)");
        }
        //城市
        if (StringUtils.isNotBlank(fbs.getCity())) {
            sql.WHERE("POSITION('" + fbs.getCity() + "' IN city)");
        }
        //州
        if (StringUtils.isNotBlank(fbs.getState())) {
            sql.WHERE("POSITION('" + fbs.getState() + "' IN state)");
        }
        //邮编
        if (StringUtils.isNotBlank(fbs.getPostal())) {
            sql.WHERE("POSITION('" + fbs.getPostal() + "' IN postal)");
        }
        //金额
        if (fbs.getSales() != null) {
            sql.WHERE("`sales`=#{sales}");
        }
        //销售单价
        if (fbs.getSalePrice() != null) {
            sql.WHERE("`sale_price`=#{salePrice}");
        }
        //上期销售价
        if (fbs.getPreSalePrice() != null) {
            sql.WHERE("`pre_sale_price`=#{preSalePrice}");
        }
        //标准售价
        if (fbs.getStdSalePrice() != null) {
            sql.WHERE("`std_sale_price`=#{stdSalePrice}");
        }
        //新运费
        if (fbs.getNewShippingCredits() != null) {
            sql.WHERE("`new_shipping_credits`=#{newShippingCredits}");
        }
        //运费
        if (fbs.getShippingCredits() != null) {
            sql.WHERE("`shipping_credits`=#{shippingCredits}");
        }
        //礼物卡
        if (fbs.getGiftwrapCredits() != null) {
            sql.WHERE("`giftwrap_credits`=#{giftwrapCredits}");
        }
        //促销折扣
        if (fbs.getPromotionalRebates() != null) {
            sql.WHERE("`promotional_rebates`=#{promotionalRebates}");
        }
        //销售税
        if (fbs.getSalesTax() != null) {
            sql.WHERE("`sales_tax`=#{salesTax}");
        }
        //市场服务税
        if (fbs.getMarketplaceFacilitatorTax() != null) {
            sql.WHERE("`marketplace_facilitator_tax`=#{marketplaceFacilitatorTax}");
        }
        //低价值商品(澳洲)
        if (fbs.getLowValueGoods() != null) {
            sql.WHERE("`low_value_goods`=#{lowValueGoods}");
        }
        //积分费用(日本ポイントの費用)
        if (fbs.getPointFee() != null) {
            sql.WHERE("`point_fee`=#{pointFee}");
        }
        //销售费用
        if (fbs.getSellingFees() != null) {
            sql.WHERE("`selling_fees`=#{sellingFees}");
        }
        //FBA费用
        if (fbs.getFbaFee() != null) {
            sql.WHERE("`fba_fee`=#{fbaFee}");
        }
        //其他交易费
        if (fbs.getOtherTransactionFees() != null) {
            sql.WHERE("`other_transaction_fees`=#{otherTransactionFees}");
        }
        //其他
        if (fbs.getOther() != null) {
            sql.WHERE("`other`=#{other}");
        }
        //总计
        if (fbs.getOther() != null) {
            sql.WHERE("`total`=#{total}");
        }
        //广告费
        if (fbs.getOther() != null) {
            sql.WHERE("`service_fee`=#{serviceFee}");
        }
        //转账
        if (fbs.getTransfer() != null) {
            sql.WHERE("`transfer`=#{transfer}");
        }
        //调整
        if (fbs.getAdjustment() != null) {
            sql.WHERE("`adjustment`=#{adjustment}");
        }
        //新促销折扣
        if (fbs.getNewPromotionalRebates() != null) {
            sql.WHERE("`new_promotional_rebates`=#{newPromotionalRebates}");
        }
        //运费_FBA
        if (fbs.getNewShippingFba() != null) {
            sql.WHERE("`new_shipping_fba`=#{newShippingFba}");
        }
        //标准产品售价
        if (fbs.getStdProductSales() != null) {
            sql.WHERE("`std_product_sales`=#{stdProductSales}");
        }
        //原始标准售价
        if (fbs.getStdSalesOriginal() != null) {
            sql.WHERE("`std_sales_original`=#{stdSalesOriginal}");
        }
        //标准售价增加
        if (fbs.getStdSalesAdd() != null) {
            sql.WHERE("`std_sales_add`=#{stdSalesAdd}");
        }
        //标准售价降低
        if (fbs.getStdSalesAdd() != null) {
            sql.WHERE("`std_sales_minus`=#{stdSalesMinus}");
        }
        //标准FBA
        if (fbs.getStdFba() != null) {
            sql.WHERE("`std_fba`=#{stdFba}");
        }
        //标准FBA费
        if (fbs.getStdFba() != null) {
            sql.WHERE("`std_fbas`=#{stdFbas}");
        }
        //原始标准FBA费
        if (fbs.getStdFbaOriginal() != null) {
            sql.WHERE("`std_fba_original`=#{stdFbaOriginal}");
        }
        //秒杀费
        if (fbs.getLightningDealFee() != null) {
            sql.WHERE("`lightning_deal_fee`=#{lightningDealFee}");
        }
        //FBA仓储费
        if (fbs.getFbaInventoryFee() != null) {
            sql.WHERE("`fba_inventory_fee`=#{fbaInventoryFee}");
        }
        ProviderSqlStore.saveUploadStatus(sql, fbs);
        return sql.toString();
    }


}
