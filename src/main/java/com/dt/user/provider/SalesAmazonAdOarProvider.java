package com.dt.user.provider;

import com.dt.user.model.SalesAmazon.SalesAmazonAdOar;
import com.dt.user.store.AppendSqlStore;
import com.dt.user.store.ProviderSqlStore;
import com.dt.user.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SalesAmazonAdOarProvider {

    @SuppressWarnings("unchecked")
    public String addAmazonAdOar(Map<String, Object> mapOar) {
        List<SalesAmazonAdOar> oarList = (List<SalesAmazonAdOar>) mapOar.get("oarList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `sales_amazon_ad_oar`\n" +
                "(`date`,`shop_id`,`site_id`,`campaign_name`,`ad_group_name`,`advertised_sku`,`advertised_asin`,`targeting`,`match_type`,`other_asin`,`sku_id`,`other_asin_units`, `other_asin_units_ordered`,\n" +
                "`other_asin_units_ordered_sales`,`create_date`,`create_user`,`recording_id`)values");
        for (SalesAmazonAdOar oar : oarList) {
            sb.append("(").append(oar.getDate()).append(",").append(oar.getShopId()).append(",").append(oar.getSiteId());
            sb.append(",");
            StrUtils.appBuider(sb, oar.getCampaignName());
            sb.append(",");
            StrUtils.appBuider(sb, oar.getAdGroupName());
            sb.append(",");
            StrUtils.appBuider(sb, oar.getAdvertisedSku());
            sb.append(",");
            StrUtils.appBuider(sb, oar.getAdvertisedAsin());
            sb.append(",");
            StrUtils.appBuider(sb, oar.getTargeting());
            sb.append(",");
            StrUtils.appBuider(sb, oar.getMatchType());
            sb.append(",");
            StrUtils.appBuider(sb, oar.getOtherAsin());
            sb.append(",");
            sb.append(oar.getSkuId()).append(",").append(oar.getOtherAsinUnits()).append(",").append(oar.getOtherAsinUnitsOrdered()).append(",").append(oar.getOtherAsinUnitsOrderedSales()).append(",");
            //通用set 拼接
            AppendSqlStore.set(sb, oar);
        }

        return sb.toString().substring(0, sb.length() - 1);
    }

    public String getOarInfo(SalesAmazonAdOar oar) {
        String table = AppendSqlStore.setSqlTable(oar.getSqlMode(), "`sales_amazon_ad_oar`", "`sales_amazon_ad_oar_wk`");
        SQL sql = new SQL();
        String alias = "oar";
        sql.SELECT("ps.`sku`,s.`shop_name`, cs.`site_name`,\n" +
                " `oar_id`,`date`,\n" +
                "`campaign_name`,`ad_group_name`,`advertised_sku`,\n" +
                "`advertised_asin`,`targeting`,\n" +
                "`match_type`,`other_asin`,\n" +
                "`other_asin_units`,`other_asin_units_ordered`,\n" +
                "`other_asin_units_ordered_sales`," +
                "" + ProviderSqlStore.statusV(alias) + "" +
                "FROM " + table + " AS " + alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = " + alias + ".`sku_id`");
        ProviderSqlStore.joinTable(sql, alias);
        // sku
        if (StringUtils.isNotBlank(oar.getSku())) {
            sql.WHERE("POSITION('" + oar.getSku() + "' IN ps.`sku`)");
        }
        //广告组
        if (StringUtils.isNotBlank(oar.getAdGroupName())) {
            sql.WHERE("POSITION('" + oar.getAdGroupName() + "' IN `ad_group_name`)");
        }
        //广告活动
        if (StringUtils.isNotBlank(oar.getCampaignName())) {
            sql.WHERE("POSITION('" + oar.getCampaignName() + "' IN `campaign_name`)");
        }
        //广告SKU
        if (StringUtils.isNotBlank(oar.getAdvertisedSku())) {
            sql.WHERE("POSITION('" + oar.getAdvertisedSku() + "' IN `advertised_sku`)");
        }
        //广告ASIN
        if (StringUtils.isNotBlank(oar.getAdvertisedAsin())) {
            sql.WHERE("POSITION('" + oar.getAdvertisedAsin() + "' IN `advertised_asin`)");
        }
        //其他ASIN
        if (StringUtils.isNotBlank(oar.getOtherAsin())) {
            sql.WHERE("POSITION('" + oar.getOtherAsin() + "' IN `other_asin`)");
        }
        //其他ASINUnits
        if (oar.getOtherAsinUnits() != null) {
            sql.WHERE("other_asin_units=#{otherAsinUnits}");
        }
        //匹配方式
        if (StringUtils.isNotBlank(oar.getMatchType())) {
            sql.WHERE("POSITION('" + oar.getMatchType() + "' IN `match_type`)");
        }
        //其他ASIN销量
        if (oar.getOtherAsinUnitsOrdered() != null) {
            sql.WHERE("other_asin_units_ordered=#{otherAsinUnitsOrdered}");
        }
        //其他ASIN销售额
        if (oar.getOtherAsinUnitsOrderedSales() != null) {
            sql.WHERE("other_asin_units_ordered_sales=#{otherAsinUnitsOrderedSales}");
        }
        //关键词
        if (StringUtils.isNotBlank(oar.getTargeting())) {
            sql.WHERE("POSITION('" + oar.getTargeting() + "' IN `targeting`)");
        }
        ProviderSqlStore.selectUploadStatus(sql, oar,alias);
        return sql.toString();
    }

}
