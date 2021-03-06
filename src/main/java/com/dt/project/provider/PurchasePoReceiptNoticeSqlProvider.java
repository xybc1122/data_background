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
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.FieldStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
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

    public String selectByPoReceiptNotice(PurchasePoReceiptNotice record) throws IllegalAccessException {
        SQL sql = new SQL();
        String alias = "prn";
        sql.SELECT("dep.`dept_name`,se1.`employee_name` AS mangerName,se.`employee_name` AS empName ,bps.`supplier_full_name`," + alias + ".`supplier_id`," +
                "`rn_id`,`date`,`no`,`explanation`,`fetch_add`," + alias + ".`dept_id`,\n" +
                "" + alias + ".`emp_id`," + alias + ".`manger_id`,`children`,`closed`,\n" +
                "`order_confirm`,`source_type_id`,`source_id`,\n" +
                "`print_count`," + alias + ".`status_id`," + alias + ".`version`\n" +
                "FROM `purchase_po_receipt_notice` AS  " + alias + "");
        sql.LEFT_OUTER_JOIN("basic_purchase_supplier AS bps on bps.supplier_id=" + alias + ".`supplier_id`");
        sql.LEFT_OUTER_JOIN("`hr_archives_department` AS dep ON dep.`dept_id`=" + alias + ".`dept_id`");
        sql.LEFT_OUTER_JOIN("`hr_archives_employee` AS se ON se.`s_id` = " + alias + ".`emp_id`");
        sql.LEFT_OUTER_JOIN("`hr_archives_employee` AS se1 ON se1.`s_id` = " + alias + ".`manger_id`");
        //查询供应商名称
        AppendSqlStore.sqlWhere(record.getSupplierFullName(), "bps.`supplier_full_name`", sql, Constants.SELECT,alias);
        //查询部门名称
        AppendSqlStore.sqlWhere(record.getDeptName(), "dep.`dept_name`", sql, Constants.SELECT,alias);
        //查询业务员
        AppendSqlStore.sqlWhere(record.getEmpName(), "se.`employee_name`", sql, Constants.SELECT,alias);
        //查询主管
        AppendSqlStore.sqlWhere(record.getMangerName(), "se1.`employee_name`", sql, Constants.SELECT,alias);
        //sql动态查询
        FieldStore.query(record.getClass(), record.getJsonArray(), record, sql,alias);
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
        if (StringUtils.isNotBlank(record.getPrNo())) {
            sql.SET("no = #{prNo,jdbcType=VARCHAR}");
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