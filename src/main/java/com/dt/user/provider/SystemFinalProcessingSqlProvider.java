package com.dt.user.provider;


import com.dt.user.store.ProviderSqlStore;
import com.dt.user.model.System.SystemFinalProcessing;

import org.apache.ibatis.jdbc.SQL;

import java.util.Map;


public class SystemFinalProcessingSqlProvider {

    public String countByExample(SystemFinalProcessing example) {
        return new SQL() {{
            SELECT("count(*)");
            FROM("system_final_processing");

        }}.toString();

    }

    public String deleteByExample(SystemFinalProcessing example) {
        return new SQL() {{
            DELETE_FROM("system_final_processing");

        }}.toString();
    }

    public String insertSelective(SystemFinalProcessing record) {
        return new SQL() {{
            INSERT_INTO("system_final_processing");

            if (record.getFinalProcessingId() != null) {
                VALUES("final_processing_id", "#{finalProcessingId,jdbcType=BIGINT}");
            }

            if (record.getMenuId() != null) {
                VALUES("menu_id", "#{menuId,jdbcType=BIGINT}");
            }

            if (record.getCloseYears() != null) {
                VALUES("close_years", "#{closeYears,jdbcType=INTEGER}");
            }

            if (record.getClosePeriod() != null) {
                VALUES("close_period", "#{closePeriod,jdbcType=INTEGER}");
            }

            if (record.getCheckoutYears() != null) {
                VALUES("checkout_years", "#{checkoutYears,jdbcType=INTEGER}");
            }

            if (record.getCheckoutPeriod() != null) {
                VALUES("checkout_period", "#{checkoutPeriod,jdbcType=BIGINT}");
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

            if (record.getCreateIdUser() != null) {
                VALUES("create_id_user", "#{createIdUser,jdbcType=BIGINT}");
            }

            if (record.getModifyDate() != null) {
                VALUES("modify_date", "#{modifyDate,jdbcType=INTEGER}");
            }

            if (record.getModifyIdUser() != null) {
                VALUES("modify_id_user", "#{modifyIdUser,jdbcType=INTEGER}");
            }

            if (record.getRecordingId() != null) {
                VALUES("recording_id", "#{recordingId,jdbcType=BIGINT}");
            }

            if (record.getVersion() != null) {
                VALUES("version", "#{version,jdbcType=INTEGER}");
            }

            if (record.getDelOrNot() != null) {
                VALUES("del_or_not", "#{delOrNot,jdbcType=BIT}");
            }
        }}.toString();
    }

    public String selectByExample(SystemFinalProcessing example) {
        SQL sql = new SQL();

        sql.SELECT("menu_id,close_years," +
                "close_period,checkout_years,checkout_period," + ProviderSqlStore.statusV + "");
        sql.FROM("system_final_processing");
        return sql.toString();
    }

    public String updateByExampleSelective(SystemFinalProcessing record) {
        return new SQL() {{
            UPDATE("system_final_processing");

            if (record.getFinalProcessingId() != null) {
                SET("final_processing_id = #{finalProcessingId,jdbcType=BIGINT}");
            }

            if (record.getMenuId() != null) {
                SET("menu_id = #{menuId,jdbcType=BIGINT}");
            }

            if (record.getCloseYears() != null) {
                SET("close_years = #{closeYears,jdbcType=INTEGER}");
            }

            if (record.getClosePeriod() != null) {
                SET("close_period = #{closePeriod,jdbcType=INTEGER}");
            }

            if (record.getCheckoutYears() != null) {
                SET("checkout_years = #{checkoutYears,jdbcType=INTEGER}");
            }

            if (record.getCheckoutPeriod() != null) {
                SET("checkout_period = #{checkoutPeriod,jdbcType=BIGINT}");
            }

            if (record.getRemark() != null) {
                SET("remark = #{remark,jdbcType=VARCHAR}");
            }

            if (record.getStatus() != null) {
                SET("status = #{status,jdbcType=INTEGER}");
            }

            if (record.getCreateDate() != null) {
                SET("create_date = #{createDate,jdbcType=BIGINT}");
            }

            if (record.getCreateIdUser() != null) {
                SET("create_id_user = #{record.createIdUser,jdbcType=BIGINT}");
            }

            if (record.getModifyDate() != null) {
                SET("modify_date = #modifyDate,jdbcType=INTEGER}");
            }

            if (record.getModifyIdUser() != null) {
                SET("modify_id_user = #{modifyIdUser,jdbcType=INTEGER}");
            }

            if (record.getRecordingId() != null) {
                SET("recording_id = #{recordingId,jdbcType=BIGINT}");
            }

            if (record.getVersion() != null) {
                SET("version = #{version,jdbcType=INTEGER}");
            }

            if (record.getDelOrNot() != null) {
                SET("del_or_not = #{delOrNot,jdbcType=BIT}");
            }
        }}.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        return new SQL() {{
            UPDATE("system_final_processing");
            SET("final_processing_id = #{record.finalProcessingId,jdbcType=BIGINT}");
            SET("menu_id = #{record.menuId,jdbcType=BIGINT}");
            SET("close_years = #{record.closeYears,jdbcType=INTEGER}");
            SET("close_period = #{record.closePeriod,jdbcType=INTEGER}");
            SET("checkout_years = #{record.checkoutYears,jdbcType=INTEGER}");
            SET("checkout_period = #{record.checkoutPeriod,jdbcType=BIGINT}");
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
            SET("status = #{record.status,jdbcType=INTEGER}");
            SET("create_date = #{record.createDate,jdbcType=BIGINT}");
            SET("create_id_user = #{record.createIdUser,jdbcType=BIGINT}");
            SET("modify_date = #{record.modifyDate,jdbcType=INTEGER}");
            SET("modify_id_user = #{record.modifyIdUser,jdbcType=INTEGER}");
            SET("recording_id = #{record.recordingId,jdbcType=BIGINT}");
            SET("version = #{record.version,jdbcType=INTEGER}");
            SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");
        }}.toString();
    }
}
