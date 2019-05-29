package com.dt.project.provider;

import com.dt.project.model.basePublicModel.BasicSalesAmazonCsvTxtXslHeader;
import com.dt.project.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class BasicSalesAmazonCsvTxtXslHeaderProvider {

    public String getTemplate(BasicSalesAmazonCsvTxtXslHeader header) {
        SQL sql = new SQL();
        String alias = "h";
        sql.SELECT(" h.status_id,h.`id`,h.`import_templet`,h.`is_import`,h.`open_close`,h.`sort`,\n" +
                "  m.`m_name`,si.`site_name`,s.`shop_name`\n" +
                "from `basic_sales_amazon_csv_txt_xsl_header` as " + alias + "");
        sql.LEFT_OUTER_JOIN("`system_user_menu` AS m ON m.`menu_id`=h.`menu_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_site` AS si ON si.`site_id` = h.`site_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_shop` AS s ON s.`shop_id` = h.`shop_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(header.getSystemLogStatus(), alias, sql);
        //对应表头字段
        if (StringUtils.isNotBlank(header.getImportTemplet())) {
            sql.WHERE(alias + ".import_templet=#{importTemplet}");
        }
        //后台开关控制导入字段数据
        if (header.getOpenClose() != null) {
            sql.WHERE(alias + ".open_close=#{openClose}");
        }
        //排序
        if (header.getSort() != null) {
            sql.WHERE(alias + ".sort=#{sort}");
        }
        //是否导入(0不导入;1导入;2禁用)
        if (header.getIsImport() != null) {
            sql.WHERE(alias + ".is_import=#{isImport}");
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
            if (shopId != null) {
                WHERE("shop_id=" + shopId);
            }
            //查询对比表头的字段
            WHERE("head_contrast= true");
            ORDER_BY("sort_file asc");
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
            if (shopId != null) {
                WHERE("shop_id=" + shopId);
            }
            if (menuId != null) {
                WHERE("menu_id=" + menuId);
            }
            //查询是否导入的字段
            WHERE("is_import= 1");
            ORDER_BY("sort asc");
        }}.toString();

    }
}
