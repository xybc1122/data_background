package com.dt.project.provider;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import com.dt.project.model.basePublic.BasicQualityInspectionMethod;

import java.util.Map;

public class BasicQualityInspectionMethodSqlProvider {

    public String countByExample(BasicQualityInspectionMethod example) {
        BEGIN();
        SELECT("count(*)");
        FROM("basic_quality_inspection_method");
        return SQL();
    }

    public String deleteByExample(BasicQualityInspectionMethod example) {
        BEGIN();
        DELETE_FROM("basic_quality_inspection_method");
        return SQL();
    }

    public String insertSelective(BasicQualityInspectionMethod record) {
        BEGIN();
        INSERT_INTO("basic_quality_inspection_method");

        if (record.getInspectionMethodId() != null) {
            VALUES("inspection_method_id", "#{inspectionMethodId,jdbcType=INTEGER}");
        }

        if (record.getNumber() != null) {
            VALUES("number", "#{number,jdbcType=VARCHAR}");
        }

        if (record.getInspectionQuarantineName() != null) {
            VALUES("inspection_quarantine_name", "#{inspectionQuarantineName,jdbcType=VARCHAR}");
        }

        if (record.getStatusId() != null) {
            VALUES("status_id", "#{statusId,jdbcType=BIGINT}");
        }

        if (record.getVersion() != null) {
            VALUES("version", "#{version,jdbcType=INTEGER}");
        }

        if (record.getDelOrNot() != null) {
            VALUES("del_or_not", "#{delOrNot,jdbcType=BIT}");
        }

        return SQL();
    }

    public String selectByExample(BasicQualityInspectionMethod example) {

        SELECT("number");
        SELECT("inspection_quarantine_name");
        SELECT("status_id");
        SELECT("version");
        SELECT("del_or_not");
        FROM("basic_quality_inspection_method");

        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BasicQualityInspectionMethod record = (BasicQualityInspectionMethod) parameter.get("record");


        BEGIN();
        UPDATE("basic_quality_inspection_method");

        if (record.getInspectionMethodId() != null) {
            SET("inspection_method_id = #{record.inspectionMethodId,jdbcType=INTEGER}");
        }

        if (record.getNumber() != null) {
            SET("number = #{record.number,jdbcType=VARCHAR}");
        }

        if (record.getInspectionQuarantineName() != null) {
            SET("inspection_quarantine_name = #{record.inspectionQuarantineName,jdbcType=VARCHAR}");
        }

        if (record.getStatusId() != null) {
            SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        }

        if (record.getVersion() != null) {
            SET("version = #{record.version,jdbcType=INTEGER}");
        }

        if (record.getDelOrNot() != null) {
            SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");
        }


        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("basic_quality_inspection_method");

        SET("inspection_method_id = #{record.inspectionMethodId,jdbcType=INTEGER}");
        SET("number = #{record.number,jdbcType=VARCHAR}");
        SET("inspection_quarantine_name = #{record.inspectionQuarantineName,jdbcType=VARCHAR}");
        SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");
        return SQL();
    }

}