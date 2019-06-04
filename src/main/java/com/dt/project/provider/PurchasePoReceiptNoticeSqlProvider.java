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

import com.dt.project.model.purchasePo.PurchasePoReceiptNotice;
import com.dt.project.store.FieldStore;
import com.dt.project.store.ProviderSqlStore;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class PurchasePoReceiptNoticeSqlProvider {

    public String countByExample(PurchasePoReceiptNotice example) {
        BEGIN();
        SELECT("count(*)");
        FROM("purchase_po_receipt_notice");

        return SQL();
    }

    public String deleteByExample(PurchasePoReceiptNotice example) {
        BEGIN();
        DELETE_FROM("purchase_po_receipt_notice");
        return SQL();
    }

    public String insertSelective(PurchasePoReceiptNotice record) {
        BEGIN();
        INSERT_INTO("purchase_po_receipt_notice");

        if (record.getRnId() != null) {
            VALUES("rn_id", "#{rnId,jdbcType=BIGINT}");
        }

        if (record.getDate() != null) {
            VALUES("date", "#{date,jdbcType=BIGINT}");
        }

        if (record.getNo() != null) {
            VALUES("no", "#{no,jdbcType=VARCHAR}");
        }

        if (record.getExplanation() != null) {
            VALUES("explanation", "#{explanation,jdbcType=VARCHAR}");
        }

        if (record.getFetchAdd() != null) {
            VALUES("fetch_add", "#{fetchAdd,jdbcType=VARCHAR}");
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

//        if (record.getSourceTypeId() != null) {
//            VALUES("source_type_id", "#{sourceTypeId,jdbcType=BIGINT}");
//        }
//
//        if (record.getSourceId() != null) {
//            VALUES("source_id", "#{sourceId,jdbcType=BIGINT}");
//        }

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

    public String selectByPoReceiptNotice(PurchasePoReceiptNotice record) throws IllegalAccessException {
        SQL sql = new SQL();
        String alias = "prn";
        sql.SELECT("" + alias + ".`supplier_id`,`rn_id`,`date`,`no`,`explanation`,`fetch_add`,`dept_id`,\n" +
                "`emp_id`,`manger_id`,`children`,`closed`,\n" +
                "`order_confirm`,`source_type_id`,`source_id`,\n" +
                "`print_count`," + alias + ".`status_id`," + alias + ".`version`\n" +
                "FROM `purchase_po_receipt_notice` AS  " + alias + "");
        //sql动态查询
        FieldStore.query(record.getClass(), record.getJavaSqlName(), record, sql);
        ProviderSqlStore.selectStatus(record.getSystemLogStatus(), alias, sql);
        return sql.toString();
    }

    public String updateByPoReceiptNotice(PurchasePoReceiptNotice record) {
        SQL sql = new SQL();
        sql.UPDATE("purchase_po_receipt_notice");
        if (record.getSupplierId() != null) {
            sql.SET("supplier_id = #{supplierId,jdbcType=INTEGER}");
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

        if (StringUtils.isNotBlank(record.getFetchAdd())) {
            sql.SET("fetch_add = #{fetchAdd,jdbcType=VARCHAR}");
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

//        if (record.getSourceTypeId() != null) {
//            sql.SET("source_type_id = #{sourceTypeId,jdbcType=BIGINT}");
//        }
//
//        if (record.getSourceId() != null) {
//            sql.SET("source_id = #{sourceId,jdbcType=BIGINT}");
//        }

        if (record.getPrintCount() != null) {
            sql.SET("print_count = #{printCount,jdbcType=INTEGER}");
        }
        sql.WHERE("rn_id = #{rnId,jdbcType=BIGINT}");
        ProviderSqlStore.setVersion(sql, record.getVersion());
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("purchase_po_receipt_notice");

        SET("rn_id = #{record.rnId,jdbcType=BIGINT}");
        SET("date = #{record.date,jdbcType=BIGINT}");
        SET("rn_no = #{record.rnNo,jdbcType=VARCHAR}");
        SET("explanation = #{record.explanation,jdbcType=VARCHAR}");
        SET("fetch_add = #{record.fetchAdd,jdbcType=VARCHAR}");
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