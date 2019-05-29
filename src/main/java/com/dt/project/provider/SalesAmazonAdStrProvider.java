package com.dt.project.provider;

import com.dt.project.model.salesAmazon.SalesAmazonAdStr;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SalesAmazonAdStrProvider {

    @SuppressWarnings("unchecked")
    public String addAmazonAdStr(Map<String, Object> mapStr) {
        List<SalesAmazonAdStr> strList = (List<SalesAmazonAdStr>) mapStr.get("strList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `sales_amazon_ad_str`\n" +
                "(`date`,`shop_id`,`site_id`,`campaign_name`, `ad_group_name`,`targeting`, " +
                "`match_type`,`customer_search_term`,`impressions`,`clicks`,\n" +
                "`total_spend`,`sales`,`roas`,`orders_placed`, `total_units`,`advertised_sku_units_ordered`," +
                "`other_sku_units_ordered`,`advertised_sku_units_sales`,`other_sku_units_sales`,\n" +
                "`create_date`,`create_user`,`recording_id`) values");
        for (SalesAmazonAdStr str : strList) {
            sb.append("(").append(str.getDate()).append(",").append(str.getShopId()).append(",").append(str.getSiteId());
            sb.append(",");
            StrUtils.appBuider(sb, str.getCampaignName());
            sb.append(",");
            StrUtils.appBuider(sb, str.getAdGroupName());
            sb.append(",");
            StrUtils.appBuider(sb, str.getTargeting());
            sb.append(",");
            StrUtils.appBuider(sb, str.getMatchType());
            sb.append(",");
            StrUtils.appBuider(sb, str.getCustomerSearchTerm());
            sb.append(",");
            sb.append(str.getImpressions());
            sb.append(",");
            sb.append(str.getClicks());
            sb.append(",");
            sb.append(str.getTotalSpend()).append(",").append(str.getSales()).
                    append(",").append(str.getRoas()).append(",").append(str.getOrdersPlaced()).
                    append(",").append(str.getTotalUnits()).append(",").append(str.getAdvertisedSkuUnitsOrdered()).
                    append(",").append(str.getOtherSkuUnitsOrdered()).append(",").
                    append(str.getAdvertisedSkuUnitsSales()).append(",").append(str.getOtherSkuUnitsSales()).append(",");
            //通用set 拼接
            AppendSqlStore.set(sb, str);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public String getStrInfo(SalesAmazonAdStr str) {
        SQL sql = new SQL();
        String alias = "str";
        sql.SELECT("s.`shop_name`, cs.`site_name`,\n" +
                "`str_id`,`date`, `campaign_name`, `ad_group_name`,`targeting`,\n" +
                "`match_type`, `customer_search_term`, `impressions`,`clicks`, `total_spend`,`sales`,\n" +
                "`roas`,`orders_placed`,`total_units`,`advertised_sku_units_ordered`,\n" +
                "`other_sku_units_ordered`,`advertised_sku_units_sales`,`other_sku_units_sales`," +
                "" + ProviderSqlStore.statusV(alias) + "" +
                "FROM `sales_amazon_ad_str` AS " + alias);
        ProviderSqlStore.joinTable(sql, alias);

        //广告活动
        if (StringUtils.isNotBlank(str.getCampaignName())) {
            sql.WHERE("POSITION('" + str.getCampaignName() + "' IN `campaign_name`)");
        }
        //广告组
        if (StringUtils.isNotBlank(str.getAdGroupName())) {
            sql.WHERE("POSITION('" + str.getAdGroupName() + "' IN `ad_group_name`)");
        }
        //关键词
        if (StringUtils.isNotBlank(str.getTargeting())) {
            sql.WHERE("POSITION('" + str.getTargeting() + "' IN `targeting`)");
        }
        //匹配方式
        if (StringUtils.isNotBlank(str.getMatchType())) {
            sql.WHERE("POSITION('" + str.getMatchType() + "' IN `match_type`)");
        }
        //客户搜索词
        if (StringUtils.isNotBlank(str.getCustomerSearchTerm())) {
            sql.WHERE("POSITION('" + str.getCustomerSearchTerm() + "' IN `customer_search_term`)");
        }
        //曝光量
        if (str.getImpressions() != null) {
            sql.WHERE("impressions=#{impressions}");
        }
        //广告点击
        if (str.getClicks() != null) {
            sql.WHERE("clicks=#{clicks}");
        }
        //广告费
        if (str.getTotalSpend() != null) {
            sql.WHERE("total_spend=#{totalSpend}");
        }
        //广告销售额
        if (str.getSales() != null) {
            sql.WHERE("sales=#{sales}");
        }
        //RoAS
        if (str.getRoas() != null) {
            sql.WHERE("roas=#{roas}");
        }
        //订单量
        if (str.getOrdersPlaced() != null) {
            sql.WHERE("orders_placed=#{ordersPlaced}");
        }
        //TotalUnits
        if (str.getTotalUnits() != null) {
            sql.WHERE("total_units=#{totalUnits}");
        }
        // 7天广告SKU销量
        if (str.getAdvertisedSkuUnitsOrdered() != null) {
            sql.WHERE("advertised_sku_units_ordered=#{advertisedSkuUnitsOrdered}");
        }
        //其他SKU销量
        if (str.getOtherSkuUnitsOrdered() != null) {
            sql.WHERE("other_sku_units_ordered=#{otherSkuUnitsOrdered}");
        }
        //7天广告SKU销售额
        if (str.getAdvertisedSkuUnitsSales() != null) {
            sql.WHERE("advertised_sku_units_sales=#{advertisedSkuUnitsSales}");
        }
        //其他SKU销售额
        if (str.getOtherSkuUnitsSales() != null) {
            sql.WHERE("other_sku_units_sales=#{otherSkuUnitsSales}");
        }
        ProviderSqlStore.selectUploadStatus(sql, str, alias);
        return sql.toString();
    }
}
