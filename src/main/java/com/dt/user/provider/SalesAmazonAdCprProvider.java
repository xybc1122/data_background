package com.dt.user.provider;

import com.dt.user.model.SalesAmazon.SalesAmazonAdCpr;
import com.dt.user.store.ProviderSqlStore;
import com.dt.user.store.AppendSqlStore;
import com.dt.user.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SalesAmazonAdCprProvider {

    @SuppressWarnings("unchecked")
    public String addAmazonAdCpr(Map<String, Object> mapCpr) {
        List<SalesAmazonAdCpr> cprList = (List<SalesAmazonAdCpr>) mapCpr.get("cprList");
        StringBuilder sb = new StringBuilder();
        sb.append("insert into sales_amazon_ad_cpr(`date`,shop_id,site_id,sku_id,advertised_sku,advertised_asin," +
                "campaign_name,ad_group_name,targeting,match_type,impressions,clicks,total_spend,orders_placed,sales,roas," +
                "total_units,same_sku_units_ordered,other_sku_units_ordered,same_sku_units_sales,other_sku_units_sales," +
                "create_date,create_user,`recording_id`) values");
        for (SalesAmazonAdCpr cpr : cprList) {
            sb.append("(").append(cpr.getDate()).append(",").
                    append(cpr.getShopId()).append(",").append(cpr.getSiteId()).append(",");
            sb.append(cpr.getSkuId()).append(",");
            StrUtils.appBuider(sb, cpr.getAdvertisedSku());
            sb.append(",");
            StrUtils.appBuider(sb, cpr.getAdvertisedAsin());
            sb.append(",");
            StrUtils.appBuider(sb, cpr.getCampaignName());
            sb.append(",");
            StrUtils.appBuider(sb, cpr.getAdGroupName());
            sb.append(",");
            StrUtils.appBuider(sb, cpr.getTargeting());
            sb.append(",");
            StrUtils.appBuider(sb, cpr.getMatchType());
            sb.append(",");
            sb.append(cpr.getImpressions()).append(",")
                    .append(cpr.getClicks()).append(",").append(cpr.getTotalSpend()).
                    append(",").append(cpr.getOrdersPlaced()).append(",").append(cpr.getSales()).
                    append(",").append(cpr.getRoas()).append(",").
                    append(cpr.getTotalUnits()).append(",").
                    append(cpr.getSameSkuUnitsOrdered()).
                    append(",").append(cpr.getOtherSkuUnitsOrdered()).append(",").
                    append(cpr.getSameSkuUnitsSales()).append(",").append(cpr.getOtherSkuUnitsSales()).append(",");
            //通用set 拼接
            AppendSqlStore.set(sb, cpr);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }


    public String getCprInfo(SalesAmazonAdCpr cpr) {
        String table = AppendSqlStore.setSqlTable(cpr, "`sales_amazon_ad_cpr`", "`sales_amazon_ad_cpr_wk`");
        SQL sql = new SQL();
        sql.SELECT("ps.`sku`,s.`shop_name`, cs.`site_name`,\n" +
                "`ad_cpr_id`, `date`,`advertised_sku`,\n" +
                "`advertised_asin`,`campaign_name`,`ad_group_name`,\n" +
                "`targeting`,`match_type`,`impressions`,\n" +
                "`clicks`,`total_spend`,`orders_placed`,\n" +
                "`sales`,`roas`,`total_units`,\n" +
                "`same_sku_units_ordered`,`other_sku_units_ordered`,`same_sku_units_sales`,\n" +
                "`other_sku_units_sales`," + ProviderSqlStore.statusV + "" +
                "FROM " + table + " AS cpr \n");
        sql.INNER_JOIN("`basic_public_shop` AS s ON s.`shop_id`=cpr.`shop_id`");
        sql.INNER_JOIN("`basic_public_site` AS cs ON cs.`site_id` = cpr.`site_id`");
        sql.INNER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = cpr.`sku_id`");
        // sku
        if (StringUtils.isNotBlank(cpr.getSku())) {
            sql.WHERE("POSITION('" + cpr.getSku() + "' IN ps.`sku`)");
        }
        //广告SKU
        if (StringUtils.isNotBlank(cpr.getAdvertisedSku())) {
            sql.WHERE("POSITION('" + cpr.getAdvertisedSku() + "' IN `advertised_sku`)");
        }
        //广告ASIN
        if (StringUtils.isNotBlank(cpr.getAdvertisedAsin())) {
            sql.WHERE("POSITION('" + cpr.getAdvertisedAsin() + "' IN `advertised_asin`)");
        }
        //广告组
        if (StringUtils.isNotBlank(cpr.getAdGroupName())) {
            sql.WHERE("POSITION('" + cpr.getAdGroupName() + "' IN `ad_group_name`)");
        }
        //广告活动
        if (StringUtils.isNotBlank(cpr.getCampaignName())) {
            sql.WHERE("POSITION('" + cpr.getCampaignName() + "' IN `campaign_name`)");
        }
        //关键词
        if (StringUtils.isNotBlank(cpr.getTargeting())) {
            sql.WHERE("POSITION('" + cpr.getTargeting() + "' IN `targeting`)");
        }
        //匹配方式
        if (StringUtils.isNotBlank(cpr.getMatchType())) {
            sql.WHERE("POSITION('" + cpr.getMatchType() + "' IN `match_type`)");
        }
        //曝光量
        if (cpr.getImpressions() != null) {
            sql.WHERE("impressions=#{impressions}");
        }
        //广告点击
        if (cpr.getClicks() != null) {
            sql.WHERE("clicks=#{clicks}");
        }
        //广告费
        if (cpr.getTotalSpend() != null) {
            sql.WHERE("total_spend=#{totalSpend}");
        }
        //订单量
        if (cpr.getOrdersPlaced() != null) {
            sql.WHERE("orders_placed=#{ordersPlaced}");
        }
        //广告销售额
        if (cpr.getSales() != null) {
            sql.WHERE("sales=#{sales}");
        }
        //RoAS
        if (cpr.getRoas() != null) {
            sql.WHERE("roas=#{roas}");
        }
        //TotalUnits
        if (cpr.getTotalUnits() != null) {
            sql.WHERE("total_units=#{totalUnits}");
        }
        //广告SKU销量
        if (cpr.getSameSkuUnitsOrdered() != null) {
            sql.WHERE("same_sku_units_ordered=#{sameSkuUnitsOrdered}");
        }
        //其他SKU销量
        if (cpr.getOtherSkuUnitsOrdered() != null) {
            sql.WHERE("other_sku_units_ordered=#{otherSkuUnitsOrdered}");
        }
        //广告SKU销售额
        if (cpr.getSameSkuUnitsSales() != null) {
            sql.WHERE("same_sku_units_sales=#{sameSkuUnitsSales}");
        }
        //其他SKU销售额
        if (cpr.getOtherSkuUnitsSales() != null) {
            sql.WHERE("other_sku_units_sales=#{otherSkuUnitsSales}");
        }
        ProviderSqlStore.saveUploadStatus(sql, cpr);
        return sql.toString();
    }
}
