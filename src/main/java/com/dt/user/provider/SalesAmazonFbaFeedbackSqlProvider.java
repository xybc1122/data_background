package com.dt.user.provider;


import com.dt.user.model.SalesAmazon.SalesAmazonFbaFeedback;
import com.dt.user.store.FieldStore;
import com.dt.user.store.ProviderSqlStore;
import org.apache.ibatis.jdbc.SQL;

import java.lang.reflect.Field;


public class SalesAmazonFbaFeedbackSqlProvider {


    public String deleteByFeedback(SalesAmazonFbaFeedback record) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sales_amazon_fba_feedback");
        sql.WHERE("fee_id=#{feeId}");
        return sql.toString();
    }

    public String insertSelective(SalesAmazonFbaFeedback record) {
        return new SQL() {{
            INSERT_INTO("sales_amazon_fba_feedback");
            if (record.getDate() != null) {
                VALUES("date", "#{date,jdbcType=BIGINT}");
            }

            if (record.getShopId() != null) {
                VALUES("shop_id", "#{shopId,jdbcType=INTEGER}");
            }

            if (record.getSiteId() != null) {
                VALUES("site_id", "#{siteId,jdbcType=INTEGER}");
            }

            if (record.getAdd() != null) {
                VALUES("add", "#{add,jdbcType=INTEGER}");
            }

            if (record.getMove() != null) {
                VALUES("move", "#{move,jdbcType=INTEGER}");
            }

            if (record.getRemark() != null) {
                VALUES("remark", "#{remark,jdbcType=VARCHAR}");
            }

            if (record.getStatus() != null) {
                VALUES("status", "#{status,jdbcType=INTEGER}");
            }

            if (record.getCreateDate() != null) {
                VALUES("create_date", "#{createDate,jdbcType=BIGINT}");
            }

            if (record.getCreateUser() != null) {
                VALUES("create_user", "#{createUser,jdbcType=VARCHAR}");
            }

            if (record.getModifyDate() != null) {
                VALUES("modify_date", "#{modifyDate,jdbcType=BIGINT}");
            }

            if (record.getModifyUser() != null) {
                VALUES("modify_user", "#{modifyUser,jdbcType=VARCHAR}");
            }

            if (record.getAuditDate() != null) {
                VALUES("audit_date", "#{auditDate,jdbcType=BIGINT}");
            }

            if (record.getAuditUser() != null) {
                VALUES("audit_user", "#{auditUser,jdbcType=VARCHAR}");
            }

            if (record.getRecordingId() != null) {
                VALUES("recording_id", "#{recordingId,jdbcType=BIGINT}");
            }
        }}.toString();

    }


    public String selectByFeedback(SalesAmazonFbaFeedback record) throws IllegalAccessException {
        SQL sql = new SQL();
        String Alias = "back";
        sql.SELECT("s.`shop_name`, cs.`site_name`,`date`,`add`,`move`," + ProviderSqlStore.statusV + "");
        sql.FROM("sales_amazon_fba_feedback AS " + Alias);
        sql.INNER_JOIN("`basic_public_shop` AS s ON s.`shop_id`=" + Alias + ".`shop_id`");
        sql.INNER_JOIN("`basic_public_site` AS cs ON cs.`site_id` = " + Alias + ".`site_id`");
        Field[] fields = record.getClass().getDeclaredFields();
        FieldStore.query(fields, record.getNameList(), record, sql);
        ProviderSqlStore.saveUploadStatus(sql, record);
        return sql.toString();
    }


    public String updateByExampleSelective(SalesAmazonFbaFeedback record) {
        return new SQL() {{
            UPDATE("sales_amazon_fba_feedback");

            if (record.getFeeId() != null) {
                SET("id = #{record.id,jdbcType=BIGINT}");
            }

            if (record.getDate() != null) {
                SET("date = #{record.date,jdbcType=BIGINT}");
            }

            if (record.getShopId() != null) {
                SET("shop_id = #{record.shopId,jdbcType=INTEGER}");
            }

            if (record.getSiteId() != null) {
                SET("site_id = #{record.siteId,jdbcType=INTEGER}");
            }

            if (record.getAdd() != null) {
                SET("add = #{record.add,jdbcType=INTEGER}");
            }

            if (record.getMove() != null) {
                SET("move = #{record.move,jdbcType=INTEGER}");
            }

            if (record.getRemark() != null) {
                SET("remark = #{record.remark,jdbcType=VARCHAR}");
            }

            if (record.getStatus() != null) {
                SET("status = #{record.status,jdbcType=INTEGER}");
            }

            if (record.getCreateDate() != null) {
                SET("create_date = #{record.createDate,jdbcType=BIGINT}");
            }

            if (record.getCreateUser() != null) {
                SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
            }

            if (record.getModifyDate() != null) {
                SET("modify_date = #{record.modifyDate,jdbcType=BIGINT}");
            }

            if (record.getModifyUser() != null) {
                SET("modify_user = #{record.modifyUser,jdbcType=VARCHAR}");
            }

            if (record.getAuditDate() != null) {
                SET("audit_date = #{record.auditDate,jdbcType=BIGINT}");
            }

            if (record.getAuditUser() != null) {
                SET("audit_user = #{record.auditUser,jdbcType=VARCHAR}");
            }

            if (record.getRecordingId() != null) {
                SET("recording_id = #{record.recordingId,jdbcType=BIGINT}");
            }
        }}.toString();
    }
}
