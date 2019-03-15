package com.dt.user.provider;

import com.dt.user.model.BasePublicModel.BasicSalesAmazonCsvTxtXslHeader;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class BasicSalesAmazonCsvTxtXslHeaderProvider {

    public String getTemplate(BasicSalesAmazonCsvTxtXslHeader header) {
        return new SQL() {{
            SELECT("  h.status_id,h.`id`,h.`import_templet`,h.`is_import`,h.`open_close`,h.`sort`,\n" +
                    "  m.`m_name`,si.`site_name`,s.`shop_name`\n" +
                    "from `basic_sales_amazon_csv_txt_xsl_header` as h");
            LEFT_OUTER_JOIN("`system_user_menu` AS m ON m.`menu_id`=h.`tb_id`");
            LEFT_OUTER_JOIN("`basic_public_site` AS si ON si.`site_id` = h.`site_id`");
            LEFT_OUTER_JOIN("`basic_public_shop` AS s ON s.`shop_id` = h.`shop_id`");
            if (header.getSystemLogStatus() != null) {
                LEFT_OUTER_JOIN("`system_log_status` AS ls ON ls.status_id=h.`status_id`");
                //备注
                if (StringUtils.isNotBlank(header.getSystemLogStatus().getRemark())) {
                    WHERE("ls.remark=#{systemLogStatus.remark}");
                }
                //状态
                if (header.getSystemLogStatus().getStatus() != null) {
                    WHERE("ls.status=#{systemLogStatus.status}");
                }
                //创建时间
                if (header.getSystemLogStatus().getCreateDate() != null) {
                    WHERE("ls.create_date=#{systemLogStatus.createDate}");
                }
                //创建人
                if (header.getSystemLogStatus().getCreateUser() != null) {
                    WHERE("ls.create_user=#{systemLogStatus.createUser}");
                }
                //修改日期
                if (header.getSystemLogStatus().getModifyDate() != null) {
                    WHERE("ls.modify_date=#{systemLogStatus.modifyDate}");
                }
                //修改人
                if (header.getSystemLogStatus().getModifyUser() != null) {
                    WHERE("ls.modify_user=#{systemLogStatus.modifyUser}");
                }
                //审核时间
                if (header.getSystemLogStatus().getAuditDate() != null) {
                    WHERE("ls.audit_date=#{systemLogStatus.auditDate}");
                }
                //审核人
                if (header.getSystemLogStatus().getAuditUser() != null) {
                    WHERE("ls.audit_user=#{systemLogStatus.auditUser}");
                }
            }
            //对应表头字段
            if (StringUtils.isNotBlank(header.getImportTemplet())) {
                WHERE("h.import_templet=#{importTemplet}");
            }
            //后台开关控制导入字段数据
            if (header.getOpenClose() != null) {
                WHERE("h.open_close=#{openClose}");
            }
            //排序
            if (header.getSort() != null) {
                WHERE("h.sort=#{sort}");
            }
            //是否导入(0不导入;1导入;2禁用)
            if (header.getIsImport() != null) {
                WHERE("h.is_import=#{isImport}");
            }
            //菜单名称
            if (StringUtils.isNotBlank(header.getmName())) {
                WHERE("m.`m_name`=#{mName}");
            }
            //站点名称
            if (StringUtils.isNotBlank(header.getSiteName())) {
                WHERE("si.`site_name`=#{siteName}");
            }
            //店铺名称
            if (StringUtils.isNotBlank(header.getShopName())) {
                WHERE("s.`shop_name`=#{shopName}");
            }
        }}.toString();

    }


    public String findHeadInfo(Map<String, Object> mapHead) {
        Integer seId = (Integer) mapHead.get("seId");
        Integer tbId = (Integer) mapHead.get("tbId");
        Integer areaId = (Integer) mapHead.get("areaId");
        Integer shopId = (Integer) mapHead.get("shopId");
        return new SQL() {{
            SELECT("import_templet");
            FROM("`basic_sales_amazon_csv_txt_xsl_header`");
            if (seId != null) {
                WHERE("site_id=" + seId);
            }
            if (tbId != null) {
                WHERE("tb_id=" + tbId);
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
        Integer tbId = (Integer) mapHead.get("tbId");
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
            WHERE("tb_id=" + tbId);
            WHERE("is_import= 1");
            ORDER_BY("sort asc");
        }}.toString();

    }
}
