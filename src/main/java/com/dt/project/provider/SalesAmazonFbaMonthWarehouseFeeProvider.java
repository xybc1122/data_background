package com.dt.project.provider;

import com.dt.project.model.salesAmazon.SalesAmazonFbaMonthWarehouseFee;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.FieldStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import com.dt.project.utils.StrUtils;
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
                    .append(mWar.getEstimatedTotalItemVolume()).append(",");
            StrUtils.appBuider(sb, mWar.getMonthOfCharge());
            sb.append(",").append(mWar.getStorageRate()).append(",");
            StrUtils.appBuider(sb, mWar.getCurrency());
            sb.append(",").append(mWar.getEstimatedMonthlyStorageFee()).append(",");
            //通用set 拼接
            AppendSqlStore.set(sb, mWar);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }

    public String getMWarInfo(SalesAmazonFbaMonthWarehouseFee mWar) throws IllegalAccessException {
        SQL sql = new SQL();
        String alias = "mWar";
        sql.SELECT("ps.`sku`,s.`shop_name`, cs.`site_name`,aw.`warehouse_code`,\n" +
                "`w_id`,`date`,`asin`," + alias + ". `fn_sku`, `product_name`, `fc`, `country_code`,\n " +
                "`longest_side`,`median_side`,`shortest_side`,\n" +
                "`measurement_units`, `weight`,`weight_units`,\n" +
                "`item_volume`,`volume_units`,`product_size_tier`,`average_quantity_on_hand`,\n" +
                "`average_quantity_pending_removal`,`estimated_total_item_volume`, `month_of_charge`,\n" +
                "`storage_rate`, " + alias + ".`currency`, `estimated_monthly_storage_fee`," +
                "" + ProviderSqlStore.statusV(alias) + "" +
                "FROM sales_amazon_fba_month_warehousefee AS " + alias + "");
        sql.LEFT_OUTER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = " + alias + ".`sku_id`");
        sql.LEFT_OUTER_JOIN("`basic_sales_amazon_warehouse` AS aw ON aw.`amazon_warehouse_id` = " + alias + ".`aw_id`");
        //链表
        ProviderSqlStore.joinTable(sql, alias);
        AppendSqlStore.sqlWhere(mWar.getWarehouseCode(), "aw.`warehouse_code`", sql, Constants.SELECT);

        AppendSqlStore.sqlWhere(mWar.getSku(), "ps.`sku`", sql, Constants.SELECT);

        //查询
        FieldStore.query(mWar.getClass(), mWar.getNameList(), mWar, sql);
        ProviderSqlStore.selectUploadStatus(sql, mWar, alias);
        return sql.toString();
    }
}
