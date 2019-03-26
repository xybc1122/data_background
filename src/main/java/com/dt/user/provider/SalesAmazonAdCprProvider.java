package com.dt.user.provider;

import com.dt.user.model.SalesAmazonAd.SalesAmazonAdCpr;
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
                "remark,`status`,create_date," +
                "create_user,modify_date,modify_user,audit_date,audit_user,`recording_id`) values");
        for (SalesAmazonAdCpr cpr : cprList) {
            sb.append("(" + cpr.getDate() + "," + cpr.getShopId() + "," + cpr.getSiteId() + "");
            sb.append(",");
            sb.append("" + cpr.getSkuId() + "");
            sb.append(",");
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
            sb.append("" + cpr.getImpressions() + ","
                    + cpr.getClicks() + "," + cpr.getTotalSpend() + ","
                    + cpr.getOrdersPlaced() + "," + cpr.getSales() + "," + cpr.getRoas() + ","
                    + cpr.getTotalUnits() + "," + cpr.getSameskuUnitsOrdered() + ","
                    + cpr.getOtherskuUnitsOrdered() + "," + cpr.getSameskuUnitsSales() + ","
                    + cpr.getOtherskuUnitsSales() + ",");
            StrUtils.appBuider(sb, cpr.getRemark());
            sb.append(",");
            StrUtils.appBuider(sb, cpr.getCreateUser());
            sb.append(",");
            StrUtils.appBuider(sb, cpr.getModifyUser());
            sb.append(",");
            StrUtils.appBuider(sb, cpr.getAuditUser());
            sb.append(",");
            sb.append(cpr.getStatus() + "," + cpr.getCreateDate() + ","
                    + cpr.getModifyDate() + ","
                    + cpr.getAuditDate() + ","
                    + cpr.getRecordingId() + "),");
        }
        String sql = sb.toString().substring(0, sb.length() - 1);
        return sql;
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
                "`othersku_units_sales`,`remark`,`status`,`create_date`,`create_id_user`,\n" +
                "`modify_date`,`modify_id_user`,`audit_date`,`audit_id_user`\n" +
                "FROM `sales_amazon_ad_cpr` AS ac \n" +
                "LEFT JOIN `basic_public_shop` AS s ON s.`shop_id`=ac.`shop_id`\n" +
                "LEFT JOIN  `basic_public_site` AS cs ON cs.`site_id` = ac.`site_id`\n" +
                "LEFT JOIN `basic_public_sku` AS ps ON ps.`sku_id` = ac.`sku_id`\n");
        //店铺名称
        if (StringUtils.isNotBlank(cpr.getShopName())) {
            sql.WHERE("s.`shop_name`=#{shopName}");
        }
        //站点名称
        if (StringUtils.isNotBlank(cpr.getSiteName())) {
            sql.WHERE("cs.`site_name`=#{siteName}");
        }
        return sql.toString();
    }
}
