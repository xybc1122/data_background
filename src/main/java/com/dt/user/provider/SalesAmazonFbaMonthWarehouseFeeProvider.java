package com.dt.user.provider;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaMonthWarehouseFee;
import com.dt.user.store.AppendSqlStore;
import com.dt.user.utils.StrUtils;

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
}
