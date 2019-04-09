package com.dt.user.provider;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaShipNoticeEntry;
import com.dt.user.store.AppendSqlStore;
import com.dt.user.store.ProviderSqlStore;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName SalesAmazonFbaShipNoticeEntryProvider
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/9 13:40
 **/
public class SalesAmazonFbaShipNoticeEntryProvider {


    public String getEntryInfo(SalesAmazonFbaShipNoticeEntry entry) {
        SQL sql = new SQL();
        sql.SELECT("ps.`sku`,\n" +
                "`e_id`,`quantity`,`packages`,\n" +
                "`length_cm`,`width_cm`,`height_cm`, `gw_kg`,\n" +
                "`nw_kg`, `volume_m3`,`se_quantity`,`re_quantity`,`re_date`,\n" +
                "`close_date`,`close_user`" + ProviderSqlStore.statusV + "" +
                "FROM `sales_amazon_fba_ship_notice_entry` AS ne \n");
        sql.INNER_JOIN("`basic_public_sku` AS ps ON ps.`sku_id` = ne.`sku_id`");
        sql.INNER_JOIN("`sales_amazon_fba_ship_notice` AS sn ON sn.`ship_notice_id` = ne.`ship_notice_id`");
        // sku
//        AppendSqlStore.sqlWhere(abandon.getSku(), "ps.`sku`", sql);

        //应发数量
        if (entry.getQuantity() != null) {
            sql.WHERE("quantity=#{quantity}");
        }
        //箱号
        AppendSqlStore.sqlWhere(entry.getPackages(), "`packages`", sql);
        //长度CM
        if (entry.getLengthCm() != null) {
            sql.WHERE("length_cm=#{lengthCm}");
        }
        //宽度CM
        if (entry.getWidthCm() != null) {
            sql.WHERE("width_cm=#{widthCm}");
        }
        //高度CM
        if (entry.getHeightCm() != null) {
            sql.WHERE("height_cm=#{heightCm}");
        }
        //毛重KG
        if (entry.getGwKg() != null) {
            sql.WHERE("gw_kg=#{gwKg}");
        }
        //体积m
        if (entry.getVolumeM3() != null) {
            sql.WHERE("volume_m3=#{volumeM3}");
        }
        //发出数量
        if (entry.getSeQuantity() != null) {
            sql.WHERE("se_quantity=#{seQuantity}");
        }
        //接收数量
        if (entry.getReQuantity() != null) {
            sql.WHERE("re_quantity=#{reQuantity}");
        }
        //接收日期
        if (entry.getReDates() != null && (entry.getReDates().size() > 0)) {
            sql.WHERE("re_date  " + entry.getReDates().get(0) + " " +
                    "AND " + entry.getReDates().get(1) + "");
        }
        ProviderSqlStore.saveUploadStatus(sql, entry);
        return sql.toString();
    }


}
