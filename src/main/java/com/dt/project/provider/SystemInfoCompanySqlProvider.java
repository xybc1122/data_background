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

import com.dt.project.model.System.SystemInfoCompany;
import com.dt.project.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class SystemInfoCompanySqlProvider {

    public String countByExample(SystemInfoCompany example) {
        BEGIN();
        SELECT("count(*)");
        FROM("system_info_company");
        return SQL();
    }

    public String deleteByExample(SystemInfoCompany example) {
        BEGIN();
        DELETE_FROM("system_info_company");
        return SQL();
    }

    public String insertSelective(SystemInfoCompany record) {
        BEGIN();
        INSERT_INTO("system_info_company");

        if (record.getCid() != null) {
            VALUES("c_id", "#{cId,jdbcType=INTEGER}");
        }

        if (record.getCompanyName() != null) {
            VALUES("company_name", "#{companyName,jdbcType=VARCHAR}");
        }

        if (record.getSystemName() != null) {
            VALUES("system_name", "#{systemName,jdbcType=VARCHAR}");
        }

        if (record.getLogoUrl() != null) {
            VALUES("logo_url", "#{logoUrl,jdbcType=VARCHAR}");
        }


        if (record.getVersion() != null) {
            VALUES("version", "#{version,jdbcType=INTEGER}");
        }

        if (record.getDelOrNot() != null) {
            VALUES("del_or_not", "#{delOrNot,jdbcType=BIT}");
        }

        return SQL();
    }

    public String selectByInfoCompany(SystemInfoCompany c) {
        SQL sql = new SQL();
        sql.SELECT("`c_id`,`company_name`,`system_name`,`logo_url`,`status_id`");
        sql.FROM("system_info_company AS oc");
        if (StringUtils.isNotBlank(c.getCompanyName())) {
            sql.WHERE("company_name=#{companyName}");
        }
        if (StringUtils.isNotBlank(c.getSystemName())) {
            sql.WHERE("system_name=#{systemName}");
        }
        if (StringUtils.isNotBlank(c.getLogoUrl())) {
            sql.WHERE("logo_url=#{logoUrl}");
        }
        ProviderSqlStore.selectStatus(c.getSystemLogStatus(), "oc", sql);
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SystemInfoCompany record = (SystemInfoCompany) parameter.get("record");


        BEGIN();
        UPDATE("system_info_company");

        if (record.getCid() != null) {
            SET("c_id = #{record.cId,jdbcType=INTEGER}");
        }

        if (record.getCompanyName() != null) {
            SET("company_name = #{record.companyName,jdbcType=VARCHAR}");
        }

        if (record.getSystemName() != null) {
            SET("system_name = #{record.systemName,jdbcType=VARCHAR}");
        }

        if (record.getLogoUrl() != null) {
            SET("logo_url = #{record.logoUrl,jdbcType=VARCHAR}");
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
        UPDATE("system_info_company");

        SET("c_id = #{record.cId,jdbcType=INTEGER}");
        SET("company_name = #{record.companyName,jdbcType=VARCHAR}");
        SET("system_name = #{record.systemName,jdbcType=VARCHAR}");
        SET("logo_url = #{record.logoUrl,jdbcType=VARCHAR}");
        SET("create_date = #{record.createDate,jdbcType=BIGINT}");
        SET("create_user = #{record.createUser,jdbcType=VARCHAR}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");


        return SQL();
    }

}