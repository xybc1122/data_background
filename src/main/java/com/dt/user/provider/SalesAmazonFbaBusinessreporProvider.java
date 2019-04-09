package com.dt.user.provider;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaBusinessreport;
import com.dt.user.store.AppendSqlStore;
import com.dt.user.store.ProviderSqlStore;
import com.dt.user.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SalesAmazonFbaBusinessreporProvider {

    @SuppressWarnings("unchecked")
    public String addAmazonAdBus(Map<String, Object> mapStr) {
        List<SalesAmazonFbaBusinessreport> busList = (List<SalesAmazonFbaBusinessreport>) mapStr.get("busList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO`sales_amazon_fba_businessreport`\n" +
                "(`date`,`shop_id`,`site_id`,`bus_sku`,`sku_id`, `f_asin`, `s_asin`, `p_name`, `sessions_visit`,\n" +
                "`sessions_per`,`page_views`,`buy_box_per`,`order`,`order_b2b`, `sales`,`sales_b2b`,`order_items`,`order_items_b2b`," +
                "`create_date`,`create_user`,`recording_id`)values");
        for (SalesAmazonFbaBusinessreport bus : busList) {
            sb.append("(").append(bus.getDate()).append(",").append(bus.getShopId()).append(",").append(bus.getSiteId()).append(",");
            StrUtils.appBuider(sb, bus.getBusSku());
            sb.append(",").append(bus.getSkuId()).append(",");
            StrUtils.appBuider(sb, bus.getfAsin());
            sb.append(",");
            StrUtils.appBuider(sb, bus.getsAsin());
            sb.append(",");
            StrUtils.appBuider(sb, bus.getpName());
            sb.append(",");
            sb.append(bus.getSessionsVisit()).append(",").append(bus.getSessionsPer()).append(",").append(bus.getPageViews()).append(",").append(bus.getBuyBoxPer()).append(",").append(bus.getOrder()).append(",").append(bus.getOrderB2B()).append(",").append(bus.getSales()).append(",").append(bus.getSalesB2B()).append(",").append(bus.getOrderItems()).append(",").append(bus.getOrderItemsB2B()).append(",");
            AppendSqlStore.set(sb, bus);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }


    public String getBusInfo(SalesAmazonFbaBusinessreport rePort) {
        String table = AppendSqlStore.setSqlTable(rePort, "`sales_amazon_fba_businessreport`",
                "`sales_amazon_fba_businessreport_wk`");
        SQL sql = new SQL();
        sql.SELECT("ps.`sku`,s.`shop_name`, cs.`site_name`,\n" +
                "`bus_id`,`date`,`bus_sku`,`f_asin`,bus.`s_asin`,`p_name`,`sessions_visit`,\n" +
                "`sessions_per`,`page_views`, `buy_box_per`,\n" +
                "`order`,`order_b2b`,`sales`,\n" +
                "`sales_b2b`,`order_items`, `order_items_b2b`," +
                "" + ProviderSqlStore.statusV + "" +
                "FROM " + table + " AS bus");
        sql.INNER_JOIN("`basic_public_shop` AS s ON s.`shop_id`=bus.`shop_id`");
        sql.INNER_JOIN("`basic_public_site` AS cs ON cs.`site_id` = bus.`site_id`");
        sql.INNER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = bus.`sku_id`");
        // sku
        if (StringUtils.isNotBlank(rePort.getSku())) {
            sql.WHERE("POSITION('" + rePort.getSku() + "' IN ps.`sku`)");
        }

        //业务报告SKU
        if (StringUtils.isNotBlank(rePort.getBusSku())) {
            sql.WHERE("POSITION('" + rePort.getBusSku() + "' IN `bus_sku`)");
        }
        //父ASIN
        if (StringUtils.isNotBlank(rePort.getfAsin())) {
            sql.WHERE("POSITION('" + rePort.getfAsin() + "' IN `f_asin`)");
        }
        //子ASIN
        if (StringUtils.isNotBlank(rePort.getsAsin())) {
            sql.WHERE("POSITION('" + rePort.getsAsin() + "' IN `s_asin`)");
        }
        //产品标题
        if (StringUtils.isNotBlank(rePort.getpName())) {
            sql.WHERE("POSITION('" + rePort.getpName() + "' IN `p_name`)");
        }
        //自然点击
        if (rePort.getSessionsVisit() != null) {
            sql.WHERE("sessions_visit=#{sessionsVisit}");
        }
        //自然点击次数百分比
        if (rePort.getSessionsPer() != null) {
            sql.WHERE("sessions_per=#{sessionsPer}");
        }
        //页面浏览量
        if (rePort.getPageViews() != null) {
            sql.WHERE("page_views=#{pageViews}");
        }
        //购物车占有率
        if (rePort.getBuyBoxPer() != null) {
            sql.WHERE("buy_box_per=#{buyBoxPer}");
        }
        //销量
        if (rePort.getOrder() != null) {
            sql.WHERE("order=#{order}");
        }
        //B2B销量
        if (rePort.getOrderB2B() != null) {
            sql.WHERE("order_b2b=#{orderB2b}");
        }
        //销售额
        if (rePort.getSales() != null) {
            sql.WHERE("sales=#{sales}");
        }
        //B2B销售额
        if (rePort.getSalesB2B() != null) {
            sql.WHERE("sales_b2b=#{salesB2b}");
        }
        //订单商品种类
        if (rePort.getOrderItems() != null) {
            sql.WHERE("order_items=#{orderItems}");
        }
        //B2B订单商品种类
        if (rePort.getOrderItemsB2B() != null) {
            sql.WHERE("order_items_b2b=#{orderItemsB2b}");
        }
        ProviderSqlStore.saveUploadStatus(sql, rePort);
        return sql.toString();
    }
}
