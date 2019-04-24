package com.dt.user.provider;

import com.dt.user.model.UserUpload;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class UserUploadProvider {

    public String findUpInfo(UserUpload upload) {
        return new SQL() {{
            SELECT("pt.payment_type_name,`id`,`uuid_name`,`name`,`create_date`,`del_date`,`del_date_id`,`remark`,`file_path`,`write_file_path`,`status`");
            FROM("system_user_upload as ru");
            LEFT_OUTER_JOIN("`basic_sales_amazon_payment_type` AS pt ON pt.`payment_type_id` = ru.`pay_id`");
            if (upload.getUid() != null) {
                WHERE("uid=#{uid}");
            }
            if (upload.getShopId() != null) {
                WHERE("shop_id=#{shopId}");
            }
            if (upload.getSiteId() != null) {
                WHERE("site_id=#{siteId}");
            }
            if (upload.getAreaId() != null) {
                WHERE("area_id=#{areaId}");
            }
            if (upload.getMid() != null) {
                WHERE("m_id=#{mid}");
            }
            if (upload.getPayId() != null) {
                WHERE("pay_id=#{payId}");
            }
            if (StringUtils.isNotBlank(upload.getPaymentTypeName())) {
                WHERE("ru.payment_type_name=#{paymentTypeName}");
            }
            if (StringUtils.isNotBlank(upload.getName())) {
                WHERE("name=#{name}");
            }
            //创建时间
            if (upload.getCreateDates() != null && upload.getCreateDates().size() > 0) {
                WHERE("create_date BETWEEN  " + upload.getCreateDates().get(0) + " AND " + upload.getCreateDates().get(1) + "");
            }
            //删除时间
            if (upload.getDelDates() != null && upload.getDelDates().size() > 0) {
                WHERE("del_date BETWEEN  " + upload.getDelDates().get(0) + " AND " + upload.getDelDates().get(1) + "");
            }
            WHERE("del_mark=0");
        }}.toString();
    }

    /**
     * 更新用户信息
     *
     * @param upload
     * @return
     */
    public String upInfo(UserUpload upload) {
        return new SQL() {{
            UPDATE("`system_user_upload`");
            if (StringUtils.isNotBlank(upload.getRemark())) {
                SET("`remark`=" + "'" + upload.getRemark() + "'");
            }
            if (upload.getStatus() != null) {
                SET("`status`=" + upload.getStatus());
            }
            if (StringUtils.isNotBlank(upload.getName())) {
                SET("`name`=" + "'" + upload.getName() + "'");
            }
            if (StringUtils.isNotBlank(upload.getFilePath())) {
                SET("`file_path`=" + "'" + upload.getFilePath() + "'");
            }
            WHERE("id=" + upload.getId());
        }}.toString();

    }
}
