package com.dt.user.provider;

import com.dt.user.model.SalesAmazonAd.SalesAmazonAdCpr;
import com.dt.user.store.ProviderSqlStore;
import com.dt.user.store.SpliceSqlStore;
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
                "campaign_name," +
                "ad_group_name,keyword,match_type,impressions,clicks,total_spend,orders_placed,sales,roas," +
                "total_units,samesku_units_ordered,othersku_units_ordered,samesku_units_sales,othersku_units_sales," +
                "create_date,create_use,`recording_id`) values");
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
            StrUtils.appBuider(sb, cpr.getKeyword());
            sb.append(",");
            StrUtils.appBuider(sb, cpr.getMatchType());
            sb.append(",");
            sb.append(cpr.getImpressions()).append(",")
                    .append(cpr.getClicks()).append(",").append(cpr.getTotalSpend()).
                    append(",").append(cpr.getOrdersPlaced()).append(",").append(cpr.getSales()).
                    append(",").append(cpr.getRoas()).append(",").
                    append(cpr.getTotalUnits()).append(",").
                    append(cpr.getSameskuUnitsOrdered()).
                    append(",").append(cpr.getOtherskuUnitsOrdered()).append(",").
                    append(cpr.getSameskuUnitsSales()).append(",").append(cpr.getOtherskuUnitsSales()).append(",");
            //通用set 拼接
            SpliceSqlStore.set(sb, cpr);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }


    public String getCprInfo(SalesAmazonAdCpr cpr) {
        SQL sql = new SQL();
        sql.SELECT("ps.`sku`,s.`shop_name`, cs.`site_name`,\n" +
                "`ad_cpr_id`, `date`,`advertised_sku`,\n" +
                "`advertised_asin`,`campaign_name`,`ad_group_name`,\n" +
                "`keyword`,`match_type`,`impressions`,\n" +
                "`clicks`,`total_spend`,`orders_placed`,\n" +
                "`sales`,`roas`,`total_units`,\n" +
                "`samesku_units_ordered`,`othersku_units_ordered`,`samesku_units_sales`,\n" +
                "`othersku_units_sales`,`remark`,`status`,`create_date`,`create_user`,\n" +
                "`modify_date`,`modify_user`,`audit_date`,`audit_user`\n" +
                "FROM `sales_amazon_ad_cpr` AS ac \n");
        sql.LEFT_OUTER_JOIN("`basic_public_shop` AS s ON s.`shop_id`=ac.`shop_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_site` AS cs ON cs.`site_id` = ac.`site_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = ac.`sku_id`");
        // sku
        if (StringUtils.isNotBlank(cpr.getSku())) {
            sql.WHERE("POSITION('" + cpr.getSku() + "' IN ps.`sku`)");
        }
        //店铺名称
        if (StringUtils.isNotBlank(cpr.getShopName())) {
            sql.WHERE("POSITION('" + cpr.getShopName() + "' IN s.`shop_name`)");
        }
        //站点名称
        if (StringUtils.isNotBlank(cpr.getSiteName())) {
            sql.WHERE("POSITION('" + cpr.getSiteName() + "' IN cs.`site_name`)");
        }
        //广告SKU
        if (StringUtils.isNotBlank(cpr.getAdvertisedSku())) {
            sql.WHERE("POSITION('" + cpr.getAdvertisedSku() + "' IN `advertised_sku`)");
        }
        //广告ASIN
        if (StringUtils.isNotBlank(cpr.getAdvertisedAsin())) {
            sql.WHERE("POSITION('" + cpr.getAdvertisedAsin() + "' IN `advertised_asin`)");
        }
        //广告活动
        if (StringUtils.isNotBlank(cpr.getCampaignName())) {
            sql.WHERE("POSITION('" + cpr.getCampaignName() + "' IN `campaign_name`)");
        }
        //广告组
        if (StringUtils.isNotBlank(cpr.getAdGroupName())) {
            sql.WHERE("POSITION('" + cpr.getAdGroupName() + "' IN `ad_group_name`)");
        }
        //关键词
        if (StringUtils.isNotBlank(cpr.getKeyword())) {
            sql.WHERE("POSITION('" + cpr.getKeyword() + "' IN `keyword`)");
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
        if (cpr.getSameskuUnitsOrdered() != null) {
            sql.WHERE("samesku_units_ordered=#{sameskuUnitsOrdered}");
        }
        //其他SKU销量
        if (cpr.getOtherskuUnitsOrdered() != null) {
            sql.WHERE("othersku_units_ordered=#{otherskuUnitsOrdered}");
        }
        //广告SKU销售额
        if (cpr.getSameskuUnitsSales() != null) {
            sql.WHERE("samesku_units_sales=#{sameskuUnitsSales}");
        }
        //其他SKU销售额
        if (cpr.getOtherskuUnitsSales() != null) {
            sql.WHERE("othersku_units_sales=#{otherskuUnitsSales}");
        }
        ProviderSqlStore.saveUploadStatus(sql, cpr);
        return sql.toString();
    }
}
