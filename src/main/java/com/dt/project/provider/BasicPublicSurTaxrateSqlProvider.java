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

import com.dt.project.model.BasePublicModel.BasicPublicSurTaxrate;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class BasicPublicSurTaxrateSqlProvider {

    public String countByExample(BasicPublicSurTaxrate example) {
        BEGIN();
        SELECT("count(*)");
        FROM("basic_public_sur_taxrate");
        return SQL();
    }

    public String deleteByExample(BasicPublicSurTaxrate example) {
        BEGIN();
        DELETE_FROM("basic_public_sur_taxrate");
        return SQL();
    }

    public String insertSelective(BasicPublicSurTaxrate record) {
        BEGIN();
        INSERT_INTO("basic_public_sur_taxrate");

        if (record.getTaxrateId() != null) {
            VALUES("taxrate_id", "#{taxrateId,jdbcType=INTEGER}");
        }

        if (record.getCountryId() != null) {
            VALUES("country_id", "#{countryId,jdbcType=INTEGER}");
        }

        if (record.getProductsId() != null) {
            VALUES("products_id", "#{productsId,jdbcType=INTEGER}");
        }


        if (record.getTaxRate() != null) {
            VALUES("tax_rate", "#{taxRate,jdbcType=DECIMAL}");
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

    public String selectBySurTax(BasicPublicSurTaxrate record) {
        String alias = "sur";
        SQL sql = new SQL();
        sql.SELECT(" cou.country_name,p.products_name,`taxrate_id`,`country_id`,`products_id`," +
                "`all_cate_is`,`tax_rate`,`status_id`,`version` FROM`basic_public_sur_taxrate` AS " + alias + "");
        //国家
        sql.LEFT_OUTER_JOIN("`basic_public_country` AS cou ON cou.`country_id`=" + alias + ".`country_id`");
        //产品类目
        sql.LEFT_OUTER_JOIN("`basic_public_products` AS p ON p.`products_id`=" + alias + ".`products_id`");
        //状态数据查询
        ProviderSqlStore.selectStatus(record.getSystemLogStatus(), alias, sql);
        //国家名
        AppendSqlStore.sqlWhere(record.getCountryName(), "cou.country_name", sql, Constants.SELECT);
        //产品类目名称
        AppendSqlStore.sqlWhere(record.getProductsName(), "p.products_name", sql, Constants.SELECT);
        //是否全品类(0非全品类;1全品类;2部分品类;)
        AppendSqlStore.sqlWhere(record.getAllCateIs(), alias + ".all_cate_is", sql, Constants.SELECT);
        //税率
        AppendSqlStore.sqlWhere(record.getTaxRate(), alias + ".tax_rate", sql, Constants.SELECT);
        sql.WHERE(alias + ".del_or_not=1");
        return sql.toString();

    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BasicPublicSurTaxrate record = (BasicPublicSurTaxrate) parameter.get("record");


        BEGIN();
        UPDATE("basic_public_sur_taxrate");

        if (record.getTaxrateId() != null) {
            SET("taxrate_id = #{record.taxrateId,jdbcType=INTEGER}");
        }

        if (record.getCountryId() != null) {
            SET("country_id = #{record.countryId,jdbcType=INTEGER}");
        }

        if (record.getProductsId() != null) {
            SET("products_id = #{record.productsId,jdbcType=INTEGER}");
        }


        if (record.getTaxRate() != null) {
            SET("tax_rate = #{record.taxRate,jdbcType=DECIMAL}");
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
        UPDATE("basic_public_sur_taxrate");

        SET("taxrate_id = #{record.taxrateId,jdbcType=INTEGER}");
        SET("country_id = #{record.countryId,jdbcType=INTEGER}");
        SET("products_id = #{record.productsId,jdbcType=INTEGER}");
        SET("is_all_cate = #{record.isAllCate,jdbcType=INTEGER}");
        SET("tax_rate = #{record.taxRate,jdbcType=DECIMAL}");
        SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");

        return SQL();
    }


}