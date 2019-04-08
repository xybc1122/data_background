package com.dt.user.provider;

import com.dt.user.model.BasePublicModel.BasicSalesAmazonCsvTxtXslHeader;
import com.dt.user.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class BasicSalesAmazonCsvTxtXslHeaderProvider {

    public String getTemplate(BasicSalesAmazonCsvTxtXslHeader header) {
        SQL sql = new SQL();
        String Alias = "h";
        sql.SELECT("  h.status_id,h.`id`,h.`import_templet`,h.`is_import`,h.`open_close`,h.`sort`,\n" +
                        "  m.`m_name`,si.`site_name`,s.`shop_name`\n" +
                        "from `basic_sales_amazon_csv_txt_xsl_header` as " + Alias + "");
        sql.LEFT_OUTER_JOIN("`system_user_menu` AS m ON m.`menu_id`=h.`menu_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_site` AS si ON si.`site_id` = h.`site_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_shop` AS s ON s.`shop_id` = h.`shop_id`");
        //状态数据查询
        ProviderSqlStore.saveStatus(header.getSystemLogStatus(), Alias, sql);
        //对应表头字段
        if (StringUtils.isNotBlank(header.getImportTemplet())) {
            sql.WHERE(Alias + ".import_templet=#{importTemplet}");
        }
        //后台开关控制导入字段数据
        if (header.getOpenClose() != null) {
            sql.WHERE(Alias + ".open_close=#{openClose}");
        }
        //排序
        if (header.getSort() != null) {
            sql.WHERE(Alias + ".sort=#{sort}");
        }
        //是否导入(0不导入;1导入;2禁用)
        if (header.getIsImport() != null) {
            sql.WHERE(Alias + ".is_import=#{isImport}");
        }
        //菜单名称
        if (StringUtils.isNotBlank(header.getmName())) {
            sql.WHERE("m.`m_name`=#{mName}");
        }
        //站点名称
        if (StringUtils.isNotBlank(header.getSiteName())) {
            sql.WHERE("si.`site_name`=#{siteName}");
        }
        //店铺名称
        if (StringUtils.isNotBlank(header.getShopName())) {
            sql.WHERE("s.`shop_name`=#{shopName}");
        }
        return sql.toString();

    }


    public String findHeadInfo(Map<String, Object> mapHead) {
        Integer seId = (Integer) mapHead.get("seId");
        Integer menuId = (Integer) mapHead.get("tbId");
        Integer areaId = (Integer) mapHead.get("areaId");
        Integer shopId = (Integer) mapHead.get("shopId");
        return new SQL() {{
            SELECT("import_templet");
            FROM("`basic_sales_amazon_csv_txt_xsl_header`");
            if (seId != null) {
                WHERE("site_id=" + seId);
            }
            if (menuId != null) {
                WHERE("menu_id=" + menuId);
            }
            if (areaId != null) {
                WHERE("area_id=" + areaId);
            }
            WHERE("shop_id=" + shopId);
            ORDER_BY("sort asc");
        }}.toString();

    }

    /**
     * 获得一个对象
     *
     * @param mapHead
     * @return
     */
    public String getHead(Map<String, Object> mapHead) {
        Integer seId = (Integer) mapHead.get("seId");
        Integer menuId = (Integer) mapHead.get("tbId");
        Integer areaId = (Integer) mapHead.get("areaId");
        Integer shopId = (Integer) mapHead.get("shopId");
        return new SQL() {{
            SELECT("import_templet,open_close");
            FROM("`basic_sales_amazon_csv_txt_xsl_header`");
            if (areaId != null) {
                WHERE("area_id=" + areaId);
            }
            if (seId != null) {
                WHERE("site_id=" + seId);
            }
            WHERE("shop_id=" + shopId);
            WHERE("menu_id=" + menuId);
            WHERE("is_import= 1");
            ORDER_BY("sort asc");
        }}.toString();

    }
}
