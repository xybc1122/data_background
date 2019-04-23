package com.dt.user.provider;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaLongWarehouseFee;
import com.dt.user.store.AppendSqlStore;
import com.dt.user.store.FieldStore;
import com.dt.user.store.ProviderSqlStore;
import com.dt.user.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;
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
                "`enrolled_in_small_and_light`,`create_date`,`create_user`,`recording_id`) values");
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
            //通用set 拼接
            AppendSqlStore.set(sb, l);
        }
        return sb.toString().substring(0, sb.length() - 1);
    }


    public String selectByLongWarehouseFee(SalesAmazonFbaLongWarehouseFee wFee) throws IllegalAccessException {
        SQL sql = new SQL();
        String Alias = "lWar";
        sql.SELECT("ps.`sku`,s.`shop_name`, cs.`site_name`,\n" +
                "`lw_id`,`date`,`lw_sku`,`fn_sku`,\n" +
                "`asin`,`condition`,`qty_charged_twelve_mo_long_term_storage_fee`,`per_unit_volume`,lWar.`currency`,\n" +
                "`twelve_mo_long_terms_storage_fee`,`qty_charged_six_mo_long_term_storage_fee`,\n" +
                "`six_mo_long_terms_storage_fee`,`volume_unit`,`country`, `enrolled_in_small_and_light`," +
                "" + ProviderSqlStore.statusV + "" +
                "FROM `sales_amazon_fba_long_warehousefee` AS " + Alias + "");
        sql.INNER_JOIN("`basic_public_shop` AS s ON s.`shop_id`=" + Alias + ".`shop_id`");
        sql.INNER_JOIN("`basic_public_site` AS cs ON cs.`site_id` = " + Alias + ".`site_id`");
        sql.INNER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = " + Alias + ".`sku_id`");
        if (StringUtils.isNotBlank(wFee.getSku()))
            sql.WHERE("POSITION('" + wFee.getSku() + "' IN ps.`sku`)");
        Field[] fields = wFee.getClass().getDeclaredFields();
        FieldStore.query(fields, wFee.getNameList(), wFee, sql);
        ProviderSqlStore.saveUploadStatus(sql, wFee,Alias);
        return sql.toString();
    }

}
