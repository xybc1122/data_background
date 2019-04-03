package com.dt.user.provider;

import com.dt.user.model.SalesAmazonAd.SalesAmazonAdHl;
import com.dt.user.model.SalesAmazonAd.SalesAmazonAdOar;
import com.dt.user.store.ProviderSqlStore;
import com.dt.user.store.SpliceSqlStore;
import com.dt.user.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SalesAmazonAdHlProvider {

    @SuppressWarnings("unchecked")
    public String addAmazonAdHl(Map<String, Object> mapHl) {
        List<SalesAmazonAdHl> hlList = (List<SalesAmazonAdHl>) mapHl.get("hlList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `sales_amazon_ad_hl`\n" +
                "(`date`,`shop_id`,`site_id`,`campaign_name`,`impressions`,`clicks`,`ctr`,`cpc`,\n" +
                " `spend`,`acos`,`roas`,`total_sales`,`total_orders`,`total_units`,`conversion_rate`," +
                "`create_date`, `create_user`, `recording_id`) values");
        for (SalesAmazonAdHl hl : hlList) {
            sb.append("(").append(hl.getDate()).append(",").append(hl.getShopId()).append(",").append(hl.getSiteId());
            sb.append(",");
            StrUtils.appBuider(sb, hl.getCampaignName());
            sb.append(",").append(hl.getImpressions()).append(",").append(hl.getClicks()).append(",");
            sb.append(hl.getCtr()).append(",").append(hl.getCpc()).append(",").append(hl.getSpend()).append(",").append(hl.getAcos()).append(",").append(hl.getRoas()).append(",").append(hl.getTotalSales()).append(",").append(hl.getTotalOrders()).append(",").append(hl.getTotalUnits()).append(",").append(hl.getConversionRate()).append(",");
            //通用set 拼接
            SpliceSqlStore.set(sb, hl);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public String getHlInfo(SalesAmazonAdHl hl) {
        SQL sql = new SQL();
        sql.SELECT("s.`shop_name`, cs.`site_name`,\n" +
                "`hl_id`,`date`,`campaign_name`,`impressions`,\n" +
                "`clicks`, `ctr`,`cpc`, `spend`,\n" +
                "`acos`,`roas`, `total_sales`,`total_orders`,`total_units`,\n" +
                "`conversion_rate`,`remark`,`status`,`create_date`,\n" +
                "`create_user`,`modify_date`,`modify_user`,\n" +
                "`audit_date`,`audit_user`,`recording_id`," +
                "" + ProviderSqlStore.statusV + "" +
                "FROM `sales_amazon_ad_hl` AS hl");
        sql.LEFT_OUTER_JOIN("`basic_public_shop` AS s ON s.`shop_id`=hl.`shop_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_site` AS cs ON cs.`site_id` = hl.`site_id`");
        //广告活动
        if (StringUtils.isNotBlank(hl.getCampaignName())) {
            sql.WHERE("POSITION('" + hl.getCampaignName() + "' IN `campaign_name`)");
        }
        //曝光量
        if (hl.getImpressions() != null) {
            sql.WHERE("impressions=#{impressions}");
        }
        //广告点击
        if (hl.getClicks() != null) {
            sql.WHERE("clicks=#{clicks}");
        }
        //CTR
        if (hl.getCtr() != null) {
            sql.WHERE("cpc=#{cpc}");
        }
        //花费
        if (hl.getSpend() != null) {
            sql.WHERE("spend=#{spend}");
        }
        //ACOS
        if (hl.getAcos() != null) {
            sql.WHERE("acos=#{acos}");
        }
        //ROAS
        if (hl.getRoas() != null) {
            sql.WHERE("roas=#{roas}");
        }
        //广告销售额
        if (hl.getTotalSales() != null) {
            sql.WHERE("totalSales=#{total_sales}");
        }
        //订单量
        if (hl.getTotalOrders() != null) {
            sql.WHERE("totalOrders=#{total_orders}");
        }
        //TotalUnits
        if (hl.getTotalUnits() != null) {
            sql.WHERE("totalUnits=#{total_units}");
        }
        //转化率
        if (hl.getConversionRate() != null) {
            sql.WHERE("conversionRate=#{conversion_rate}");
        }
        ProviderSqlStore.saveUploadStatus(sql, hl);
        return sql.toString();
    }

}
