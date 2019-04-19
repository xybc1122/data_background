package com.dt.user.provider;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaLongWarehouseFee;
import com.dt.user.store.AppendSqlStore;
import com.dt.user.utils.StrUtils;

import java.util.List;
import java.util.Map;

/**
 * @ClassName SalesAmazonFbaLongWarehousefeeProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/17 14:31
 **/
public class SalesAmazonFbaLongWarehousefeeProvider {


    public String saveAmazonLongWarList(Map<String, Object> mapStr) {
        List<SalesAmazonFbaLongWarehouseFee> longWarList = (List<SalesAmazonFbaLongWarehouseFee>) mapStr.get("longWarList");
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO `sales_amazon_fba_long_warehousefee`\n" +
                "(`date`,`shop_id`,`site_id`, `sku_id`,`lw_sku`,\n" +
                "`fn_sku`,`asin`,`condition`,`qty_charged_twelve_mo_long_term_storage_fee`,\n" +
                "`per_unit_volume`,`currency`,`twelve_mo_long_terms_storage_fee`," +
                "`qty_charged_six_mo_long_term_storage_fee`,\n" +
                "`six_mo_long_terms_storage_fee`,`volume_unit`, `country`," +
                "`enrolled_in_small_and_light`,`product_name`,`create_date`,`create_user`,`recording_id`) values");
        for (SalesAmazonFbaLongWarehouseFee l : longWarList) {
            sb.append("(").append(l.getDate()).append(",").
                    append(l.getShopId()).append(",").append(l.getSiteId()).append(",").append(l.getSkuId());
            sb.append(",");
            StrUtils.appBuider(sb, l.getLwSku());
            sb.append(",");
            StrUtils.appBuider(sb, l.getFnSku());
            sb.append(",");
            StrUtils.appBuider(sb, l.getAsin());
            sb.append(",");
            StrUtils.appBuider(sb, l.getCondition());
            sb.append(",").append(l.getQtyChargedSixMoLongTermStorageFee()).append(",")
                    .append(l.getPerUnitVolume()).append(",");
            StrUtils.appBuider(sb, l.getCurrency());
            sb.append(",").append(l.getTwelveMoLongTermsStorageFee()).append(",")
                    .append(l.getQtyChargedTwelveMoLongTermStorageFee()).append(",")
                    .append(l.getSixMoLongTermsStorageFee()).append(",");
            StrUtils.appBuider(sb, l.getVolumeUnit());
            sb.append(",");
            StrUtils.appBuider(sb, l.getCountry());
            sb.append(",");
            StrUtils.appBuider(sb, l.getEnrolledInSmallAndLight());
            sb.append(",");
            StrUtils.appBuider(sb, l.getProductName());
            sb.append(",");
            //通用set 拼接
            AppendSqlStore.set(sb, l);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }


}
