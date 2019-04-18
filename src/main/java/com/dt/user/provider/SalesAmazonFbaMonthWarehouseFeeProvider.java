package com.dt.user.provider;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaMonthWarehouseFee;
import com.dt.user.store.AppendSqlStore;
import com.dt.user.store.ProviderSqlStore;
import com.dt.user.utils.StrUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SalesAmazonFbaMonthWarehouseFeeProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/17 9:47
 **/
public class SalesAmazonFbaMonthWarehouseFeeProvider {

    public String addAmazonMonthWar(Map<String, Object> mapStr) {
        List<SalesAmazonFbaMonthWarehouseFee> mWarList = (List<SalesAmazonFbaMonthWarehouseFee>) mapStr.get("mWarList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `sales_amazon_fba_month_warehousefee`\n" +
                "(`date`, `shop_id`, `site_id`, `sku_id`,`asin`,\n" +
                "`fn_sku`,`product_name`,  `fc`, `aw_id`,`country_code`,\n" +
                "`longest_side`,`median_side`,`shortest_side`,\n" +
                "`measurement_units`, `weight`,`weight_units`,`item_volume`, `volume_units`,\n" +
                "`product_size_tier`,`average_quantity_on_hand`,`average_quantity_pending_removal`,\n" +
                "`estimated_total_item_volume`,`month_of_charge`,`storage_rate`, `currency`,\n" +
                "`estimated_monthly_storage_fee`,`create_date`,`create_user`,`recording_id`) values");
        for (SalesAmazonFbaMonthWarehouseFee mWar : mWarList) {
            sb.append("(").append(mWar.getDate()).append(",").
                    append(mWar.getShopId()).append(",").append(mWar.getSiteId()).append(",").append(mWar.getSkuId());
            sb.append(",");
            StrUtils.appBuider(sb, mWar.getAsin());
            sb.append(",");
            StrUtils.appBuider(sb, mWar.getFnSku());
            sb.append(",");
            StrUtils.appBuider(sb, mWar.getProductName());
            sb.append(",");
            StrUtils.appBuider(sb, mWar.getFc());
            sb.append(",").append(mWar.getAwId()).append(",");
            StrUtils.appBuider(sb, mWar.getCountryCode());
            sb.append(",").append(mWar.getLongestSide()).append(",").
                    append(mWar.getMedianSide()).append(",").
                    append(mWar.getShortestSide()).append(",");
            StrUtils.appBuider(sb, mWar.getMeasurementUnits());
            sb.append(",").append(mWar.getWeight()).append(",");
            StrUtils.appBuider(sb, mWar.getWeightUnits());
            sb.append(",").append(mWar.getItemVolume()).append(",");
            StrUtils.appBuider(sb, mWar.getVolumeUnits());
            sb.append(",");
            StrUtils.appBuider(sb, mWar.getProductSizeTier());
            sb.append(",").append(mWar.getAverageQuantityOnHand()).append(",").
                    append(mWar.getAverageQuantityPendingRemoval()).append(",")
                    .append(mWar.getEstimatedTotalItemVolume()).append(",").append(mWar.getMonthOfCharge())
                    .append(",").append(mWar.getStorageRate()).append(",");
            StrUtils.appBuider(sb, mWar.getCurrency());
            sb.append(",").append(mWar.getEstimatedMonthlyStorageFee()).append(",");
            //通用set 拼接
            AppendSqlStore.set(sb, mWar);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public String getMWarInfo(SalesAmazonFbaMonthWarehouseFee mWar) {
        SQL sql = new SQL();
        sql.SELECT("ps.`sku`,s.`shop_name`, cs.`site_name`,\n" +
                "`w_id`,`date`,`asin`,`fn_sku`,`product_name`,`fc`, `country_code`,\n" +
                "`longest_side`,`median_side`,`shortest_side`,\n" +
                "`measurement_units`, `weight`,`weight_units`,\n" +
                "`item_volume`,`volume_units`,`product_size_tier`,`average_quantity_on_hand`,\n" +
                "`average_quantity_pending_removal`,`estimated_total_item_volume`, `month_of_charge`,\n" +
                "`storage_rate`, `currency`, `estimated_monthly_storage_fee`," +
                "" + ProviderSqlStore.statusV + "" +
                "FROM sales_amazon_fba_month_warehousefee AS mAr");
        sql.INNER_JOIN("`basic_public_shop` AS s ON s.`shop_id`=mAr.`shop_id`");
        sql.INNER_JOIN("`basic_public_site` AS cs ON cs.`site_id` = mAr.`site_id`");
        sql.INNER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = mAr.`sku_id`");
        ProviderSqlStore.saveUploadStatus(sql, mWar);
        return sql.toString();
    }
}
