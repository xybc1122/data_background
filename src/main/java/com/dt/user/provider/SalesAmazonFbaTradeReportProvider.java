package com.dt.user.provider;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaTradeReport;
import com.dt.user.store.AppendSqlStore;
import com.dt.user.store.ProviderSqlStore;
import com.dt.user.toos.Constants;
import com.dt.user.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SalesAmazonFbaTradeReportProvider {


    public String addInfo(Map<String, Object> infoMap) {
        List<SalesAmazonFbaTradeReport> trdList = (List<SalesAmazonFbaTradeReport>) infoMap.get("trdList");
        // sql前缀
        String prefix = "INSERT INTO`sales_amazon_fba_trade_report`\n" +
                "(`amazon_order_id`,`merchant_order_id`,`date`,`last_updated_date`,`shop_id`,`site_id`,`order_status`,\n" +
                "`fulfillment_channel`, `sales_channel`,`order_channel`,`url`,`ship_service_level`,`product_name`,`trade_sku`,`sku_id`,\n" +
                "`asin`,`item_status`,`quantity`,`currency`,`item_price`,`item_tax`,`shipping_price`,`shipping_tax`,`gift_wrap_price`,\n" +
                "`gift_wrap_tax`,`item_promotion_discount`,`ship_promotion_discount`,`ship_city`,`ship_state`,`ship_postal_code`,\n" +
                "`ship_country`,`promotion_ids`,`is_business_order`,`purchase_order_number`,`price_designation`, `is_replacement_order`,`original_order_id`,\n" +
                "`create_date`,`create_user`,`recording_id`)values";
        // 保存sql后缀
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        for (SalesAmazonFbaTradeReport trade : trdList) {
            sb.append("(");
            StrUtils.appBuider(sb, trade.getAmazonOrderId());
            sb.append(",");
            StrUtils.appBuider(sb, trade.getMerchantOrderId());
            sb.append(",");
            // 构建sql后缀
            sb.append(trade.getDate()).append(",").append(trade.getLastUpdatedDate()).append(",").append(trade.getShopId()).append(",").append(trade.getSiteId());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, trade.getOrderStatus());
            sb.append(",");
            StrUtils.appBuider(sb, trade.getFulfillmentChannel());
            //#
            sb.append(",");
            StrUtils.appBuider(sb, trade.getSalesChannel());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, trade.getOrderChannel());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, trade.getUrl());
            sb.append(",");
            StrUtils.appBuider(sb, trade.getShipServiceLevel());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, trade.getProductName());
            sb.append(",");
            StrUtils.appBuider(sb, trade.getTradeSku());
            sb.append(",").append(trade.getSkuId());
            sb.append(",");
            StrUtils.appBuider(sb, trade.getAsin());
            sb.append(",");
            StrUtils.appBuider(sb, trade.getItemStatus());
            sb.append(",").append(trade.getQuantity());
            sb.append(",");
            StrUtils.appBuider(sb, trade.getCurrency());
            sb.append(",");
            sb.append(trade.getItemPrice()).append(",").append(trade.getItemTax()).append(",").append(trade.getShippingPrice()).append(",").append(trade.getShippingTax()).append(",").append(trade.getGiftWrapPrice()).append(",").append(trade.getGiftWrapTax()).append(",").append(trade.getItemPromotionDiscount()).append(",").append(trade.getShipPromotionDiscount());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, trade.getShipCity());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, trade.getShipState());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, trade.getShipPostalCode());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, trade.getShipCountry());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, trade.getPromotionIds());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, trade.getIsBusinessOrder());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, trade.getPurchaseOrderNumber());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, trade.getPriceDesignation());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, trade.getIsReplacementOrder());
            sb.append(",");
            //#
            StrUtils.appBuider(sb, trade.getOriginalOrderId());
            sb.append(",");
            AppendSqlStore.set(sb, trade);

        }
        // 构建完整sql
        return sb.toString().substring(0, sb.length() - 1);
    }


    public String getRePortInfo(SalesAmazonFbaTradeReport report) {
        SQL sql = new SQL();
        String alias = "tr";
        sql.SELECT("ps.`sku`,s.`shop_name`, cs.`site_name`,\n" +
                "`trade_id`, `amazon_order_id`,`merchant_order_id`,`date`,\n" +
                "`last_updated_date`,`order_status`,`fulfillment_channel`,\n" +
                "`sales_channel`,`order_channel`, tr.`url`,\n" +
                "`ship_service_level`, `product_name`,`trade_sku`,\n" +
                "`asin`,`item_status`,`quantity`, `currency`,\n" +
                "`item_price`,`item_tax`,`shipping_price`,`shipping_tax`,\n" +
                "`gift_wrap_price`, `gift_wrap_tax`,`item_promotion_discount`,\n" +
                "`ship_promotion_discount`, `ship_city`,`ship_state`,\n" +
                "`ship_postal_code`,`ship_country`,`promotion_ids`,\n" +
                "`is_business_order`,`purchase_order_number`,`price_designation`,\n" +
                "`is_replacement_order`, `original_order_id`," + ProviderSqlStore.statusV + "" +
                "FROM sales_amazon_fba_trade_report AS " + alias + " \n");
        sql.INNER_JOIN("`basic_public_shop` AS s ON s.`shop_id`=" + alias + ".`shop_id`");
        sql.INNER_JOIN("`basic_public_site` AS cs ON cs.`site_id` = " + alias + ".`site_id`");
        sql.INNER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = " + alias + ".`sku_id`");
        // sku
        AppendSqlStore.sqlWhere(report.getSku(), "ps.`sku`", sql, Constants.SELECT);
        //亚马逊订单号
        AppendSqlStore.sqlWhere(report.getAmazonOrderId(), "amazon_order_id", sql, Constants.SELECT);
        //店铺订单号
        AppendSqlStore.sqlWhere(report.getMerchantOrderId(), "merchant_order_id", sql, Constants.SELECT);
        //最近更新日期
        if (report.getLastUpdatedDates() != null && (report.getLastUpdatedDates().size() > 0)) {
            sql.WHERE("last_updated_date  " + report.getLastUpdatedDates().get(0) + " AND " + report.getLastUpdatedDates().get(1) + "");
        }
        //订单状态
        AppendSqlStore.sqlWhere(report.getOrderStatus(), "order_status", sql, Constants.SELECT);
        //发货方式
        AppendSqlStore.sqlWhere(report.getFulfillmentChannel(), "fulfillment_channel", sql, Constants.SELECT);
        //销售渠道
        AppendSqlStore.sqlWhere(report.getSalesChannel(), "sales_channel", sql, Constants.SELECT);
        //订单渠道
        AppendSqlStore.sqlWhere(report.getOrderChannel(), "order_channel", sql, Constants.SELECT);
        //URL
        AppendSqlStore.sqlWhere(report.getUrl(), "tr.`url`", sql, Constants.SELECT);
        //运输服务等级
        AppendSqlStore.sqlWhere(report.getShipServiceLevel(), "ship_service_level", sql, Constants.SELECT);
        //产品名称
        AppendSqlStore.sqlWhere(report.getProductName(), "product_name", sql, Constants.SELECT);
        //SKU
        AppendSqlStore.sqlWhere(report.getTradeSku(), "trade_sku", sql, Constants.SELECT);
        //子ASIN
        AppendSqlStore.sqlWhere(report.getAsin(), "asin", sql, Constants.SELECT);
        //商品状态
        AppendSqlStore.sqlWhere(report.getItemStatus(), "item_status", sql, Constants.SELECT);
        //数量
        if (report.getQuantity() != null) {
            sql.WHERE("quantity=#{quantity}");
        }
        //币别
        AppendSqlStore.sqlWhere(report.getCurrency(), "currency", sql, Constants.SELECT);
        //商品价格
        if (report.getItemPrice() != null) {
            sql.WHERE("item_price=#{itemPrice}");
        }
        //商品税
        if (report.getItemTax() != null) {
            sql.WHERE("item_tax=#{itemTax}");
        }
        //运输价格
        if (report.getShippingPrice() != null) {
            sql.WHERE("shipping_price=#{shippingPrice}");
        }
        //运输税
        if (report.getShippingTax() != null) {
            sql.WHERE("shipping_tax=#{shippingTax}");
        }
        //礼物包装价格
        if (report.getGiftWrapPrice() != null) {
            sql.WHERE("gift_wrap_price=#{giftWrapPrice}");
        }
        //礼物包装税
        if (report.getGiftWrapTax() != null) {
            sql.WHERE("gift_wrap_tax=#{giftWrapTax}");
        }
        //促销折扣
        if (report.getItemPromotionDiscount() != null) {
            sql.WHERE("item_promotion_discount=#{itemPromotionDiscount}");
        }
        //运输折扣
        if (report.getShipPromotionDiscount() != null) {
            sql.WHERE("ship_promotion_discount=#{shipPromotionDiscount}");
        }
        //城市
        AppendSqlStore.sqlWhere(report.getShipCity(), "ship_city", sql, Constants.SELECT);
        //州
        AppendSqlStore.sqlWhere(report.getShipState(), "ship_state", sql, Constants.SELECT);
        //邮编
        AppendSqlStore.sqlWhere(report.getShipPostalCode(), "ship_postal_code", sql, Constants.SELECT);
        //国家
        AppendSqlStore.sqlWhere(report.getShipCountry(), "ship_country", sql, Constants.SELECT);
        //折扣码
        AppendSqlStore.sqlWhere(report.getPromotionIds(), "promotion_ids", sql, Constants.SELECT);
        //是否商业订单
        AppendSqlStore.sqlWhere(report.getIsBusinessOrder(), "is_business_order", sql, Constants.SELECT);
        //采购订单编号
        AppendSqlStore.sqlWhere(report.getPurchaseOrderNumber(), "purchase_order_number", sql, Constants.SELECT);
        //价格类型
        AppendSqlStore.sqlWhere(report.getPriceDesignation(), "price_designation", sql, Constants.SELECT);
        //是否退换货订单
        AppendSqlStore.sqlWhere(report.getIsReplacementOrder(), "is_replacement_order", sql, Constants.SELECT);
        //原始订单号
        AppendSqlStore.sqlWhere(report.getOriginalOrderId(), "original_order_id", sql, Constants.SELECT);
        ProviderSqlStore.saveUploadStatus(sql, report, alias);
        return sql.toString();
    }
}
