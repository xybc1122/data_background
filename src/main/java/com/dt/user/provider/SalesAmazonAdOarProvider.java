package com.dt.user.provider;

import com.dt.user.model.SalesAmazonAd.SalesAmazonAdOar;
import com.dt.user.store.ProviderSqlStore;
import com.dt.user.store.SpliceSqlStore;
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
            SpliceSqlStore.set(sb, oar);
        }

        return sb.toString().substring(0, sb.length() - 1);
    }

    public String getOarInfo(SalesAmazonAdOar oar) {
        SQL sql = new SQL();
        sql.SELECT("ps.`sku`,s.`shop_name`, cs.`site_name`,\n" +
                " `oar_id`,`date`,\n" +
                "`campaign_name`,`ad_group_name`,`advertised_sku`,\n" +
                "`advertised_asin`,`targeting`,\n" +
                "`match_type`,`other_asin`,\n" +
                "`other_asin_units`,`other_asin_units_ordered`,\n" +
                "`other_asin_units_ordered_sales`," +
                "" + ProviderSqlStore.statusV + "" +
                "FROM `sales_amazon_ad_oar` AS oar");
        sql.LEFT_OUTER_JOIN("`basic_public_shop` AS s ON s.`shop_id`=oar.`shop_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_site` AS cs ON cs.`site_id` = oar.`site_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = oar.`sku_id`");

        //其他ASIN
        if (StringUtils.isNotBlank(oar.getOtherAsin())) {
            sql.WHERE("POSITION('" + oar.getOtherAsin() + "' IN `other_asin`)");
        }
        //其他ASINUnits
        if (oar.getOtherAsinUnits() != null) {
            sql.WHERE("other_asin_units=#{otherAsinUnits}");
        }
        //其他ASIN销量
        if (oar.getOtherAsinUnitsOrdered() != null) {
            sql.WHERE("other_asin_units_ordered=#{otherAsinUnitsOrdered}");
        }
        //其他ASIN销售额
        if (oar.getOtherAsinUnitsOrderedSales() != null) {
            sql.WHERE("other_asin_units_ordered_sales=#{otherAsinUnitsOrderedSales}");
        }
        ProviderSqlStore.saveUploadStatus(sql, oar);
        return sql.toString();
    }

}
