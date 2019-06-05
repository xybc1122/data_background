package com.dt.project.provider;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.dt.project.model.purchasePo.PurchaseIcBillStock;
import com.dt.project.store.FieldStore;
import com.dt.project.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class PurchaseIcBillStockSqlProvider {

    public String countByExample(PurchaseIcBillStock example) {
        BEGIN();
        SELECT("count(*)");
        FROM("purchase_ic_bill_stock");

        return SQL();
    }

    public String deleteByExample(PurchaseIcBillStock example) {
        BEGIN();
        DELETE_FROM("purchase_ic_bill_stock");

        return SQL();
    }

    public String insertSelective(PurchaseIcBillStock record) {
        BEGIN();
        INSERT_INTO("purchase_ic_bill_stock");

        if (record.getSbId() != null) {
            VALUES("sb_id", "#{sbId,jdbcType=BIGINT}");
        }

//        if (record.getDate() != null) {
//            VALUES("date", "#{date,jdbcType=BIGINT}");
//        }

        if (record.getNo() != null) {
            VALUES("no", "#{no,jdbcType=VARCHAR}");
        }

        if (record.getExplanation() != null) {
            VALUES("explanation", "#{explanation,jdbcType=VARCHAR}");
        }

        if (record.getDeptId() != null) {
            VALUES("dept_id", "#{deptId,jdbcType=INTEGER}");
        }

        if (record.getEmpId() != null) {
            VALUES("emp_id", "#{empId,jdbcType=INTEGER}");
        }

        if (record.getMangerId() != null) {
            VALUES("manger_id", "#{mangerId,jdbcType=INTEGER}");
        }

        if (record.getChildren() != null) {
            VALUES("children", "#{children,jdbcType=BIT}");
        }

        if (record.getClosed() != null) {
            VALUES("closed", "#{closed,jdbcType=INTEGER}");
        }

        if (record.getOrderConfirm() != null) {
            VALUES("order_confirm", "#{orderConfirm,jdbcType=INTEGER}");
        }

        if (record.getSourceTypeId() != null) {
            VALUES("source_type_id", "#{sourceTypeId,jdbcType=BIGINT}");
        }

        if (record.getSourceId() != null) {
            VALUES("source_id", "#{sourceId,jdbcType=BIGINT}");
        }

        if (record.getPrintCount() != null) {
            VALUES("print_count", "#{printCount,jdbcType=INTEGER}");
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

    public String selectByIcBillStock(PurchaseIcBillStock record) throws IllegalAccessException {
        SQL sql = new SQL();
        String alias = "ibs";
        sql.SELECT("" + alias + ".`supplier_id`, `sb_id`,`years`,`period`,`date`,`no`,\n" +
                "`explanation`,`dept_id`,\n" +
                "`emp_id`,`manger_id`,`children`,\n" +
                "`closed`,`order_confirm`,`print_count`," + alias + ".`status_id`," + alias + ".`version`\n" +
                "FROM `purchase_ic_bill_stock` AS " + alias + "");
        //sql动态查询
        FieldStore.query(record.getClass(), record.getJavaSqlName(), record, sql);
        ProviderSqlStore.selectStatus(record.getSystemLogStatus(), alias, sql);
        return sql.toString();
    }

    public String updateByIcBillStock(PurchaseIcBillStock record) {
        SQL sql = new SQL();
        sql.UPDATE("purchase_ic_bill_stock");

        if (record.getSbId() != null) {
            sql.SET("sb_id = #{sbId,jdbcType=BIGINT}");
        }
        if (record.getYears() != null) {
            sql.SET("years = #{years}");
        }
        if (record.getPeriod() != null) {
            sql.SET("period = #{period}");
        }
        if (record.getDate() != null) {
            sql.SET("date = #{date,jdbcType=BIGINT}");
        }

        if (StringUtils.isNotBlank(record.getNo())) {
            sql.SET("no = #{no,jdbcType=VARCHAR}");
        }

        if (StringUtils.isNotBlank(record.getExplanation())) {
            sql.SET("explanation = #{explanation,jdbcType=VARCHAR}");
        }

        if (record.getDeptId() != null) {
            sql.SET("dept_id = #{deptId,jdbcType=INTEGER}");
        }

        if (record.getEmpId() != null) {
            sql.SET("emp_id = #{empId,jdbcType=INTEGER}");
        }

        if (record.getMangerId() != null) {
            sql.SET("manger_id = #{mangerId,jdbcType=INTEGER}");
        }

        if (record.getChildren() != null) {
            sql.SET("children = #{children,jdbcType=BIT}");
        }

        if (record.getClosed() != null) {
            sql.SET("closed = #{closed,jdbcType=INTEGER}");
        }

        if (record.getOrderConfirm() != null) {
            sql.SET("order_confirm = #{orderConfirm,jdbcType=INTEGER}");
        }

        if (record.getSourceTypeId() != null) {
            sql.SET("source_type_id = #{sourceTypeId,jdbcType=BIGINT}");
        }

        if (record.getSourceId() != null) {
            sql.SET("source_id = #{jdbcType=BIGINT}");
        }

        if (record.getPrintCount() != null) {
            sql.SET("print_count = #{printCount,jdbcType=INTEGER}");
        }
        sql.WHERE("sb_id = #{sbId,jdbcType=BIGINT}");
        ProviderSqlStore.setVersion(sql, record.getVersion());
        return sql.toString();
    }


    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("purchase_ic_bill_stock");

        SET("sb_id = #{record.sbId,jdbcType=BIGINT}");
        SET("date = #{record.date,jdbcType=BIGINT}");
        SET("no = #{record.no,jdbcType=VARCHAR}");
        SET("explanation = #{record.explanation,jdbcType=VARCHAR}");
        SET("dept_id = #{record.deptId,jdbcType=INTEGER}");
        SET("emp_id = #{record.empId,jdbcType=INTEGER}");
        SET("manger_id = #{record.mangerId,jdbcType=INTEGER}");
        SET("children = #{record.children,jdbcType=BIT}");
        SET("closed = #{record.closed,jdbcType=INTEGER}");
        SET("order_confirm = #{record.orderConfirm,jdbcType=INTEGER}");
        SET("source_type_id = #{record.sourceTypeId,jdbcType=BIGINT}");
        SET("source_id = #{record.sourceId,jdbcType=BIGINT}");
        SET("print_count = #{record.printCount,jdbcType=INTEGER}");
        SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");


        return SQL();
    }

}