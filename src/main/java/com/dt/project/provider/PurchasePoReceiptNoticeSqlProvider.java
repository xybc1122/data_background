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

import com.dt.project.model.purchasePo.PurchasePoReceiptNotice;
import com.dt.project.store.FieldStore;
import com.dt.project.store.ProviderSqlStore;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
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

        if (record.getRnNo() != null) {
            VALUES("rn_no", "#{rnNo,jdbcType=VARCHAR}");
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

    public String selectByPoReceiptNotice(PurchasePoReceiptNotice record) {
        SQL sql = new SQL();
        String alias = "prn";
        sql.SELECT("`rn_id`,`date`,`rn_no`,`explanation`,`fetch_add`,`dept_id`,\n" +
                "`emp_id`,`manger_id`,`children`,`closed`,\n" +
                "`order_confirm`,`source_type_id`,`source_id`,\n" +
                "`print_count`,`status_id`,`version`\n" +
                "FROM `purchase_po_receipt_notice` AS  " + alias + "");
        //sql动态查询
        FieldStore.query(record.getClass(), record.getJavaSqlName(), record, sql);


        ProviderSqlStore.selectStatus(record.getSystemLogStatus(), alias, sql);





        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PurchasePoReceiptNotice record = (PurchasePoReceiptNotice) parameter.get("record");

        BEGIN();
        UPDATE("purchase_po_receipt_notice");

        if (record.getRnId() != null) {
            SET("rn_id = #{record.rnId,jdbcType=BIGINT}");
        }

        if (record.getDate() != null) {
            SET("date = #{record.date,jdbcType=BIGINT}");
        }

        if (record.getRnNo() != null) {
            SET("rn_no = #{record.rnNo,jdbcType=VARCHAR}");
        }

        if (record.getExplanation() != null) {
            SET("explanation = #{record.explanation,jdbcType=VARCHAR}");
        }

        if (record.getFetchAdd() != null) {
            SET("fetch_add = #{record.fetchAdd,jdbcType=VARCHAR}");
        }

        if (record.getDeptId() != null) {
            SET("dept_id = #{record.deptId,jdbcType=INTEGER}");
        }

        if (record.getEmpId() != null) {
            SET("emp_id = #{record.empId,jdbcType=INTEGER}");
        }

        if (record.getMangerId() != null) {
            SET("manger_id = #{record.mangerId,jdbcType=INTEGER}");
        }

        if (record.getChildren() != null) {
            SET("children = #{record.children,jdbcType=BIT}");
        }

        if (record.getClosed() != null) {
            SET("closed = #{record.closed,jdbcType=INTEGER}");
        }

        if (record.getOrderConfirm() != null) {
            SET("order_confirm = #{record.orderConfirm,jdbcType=INTEGER}");
        }

        if (record.getSourceTypeId() != null) {
            SET("source_type_id = #{record.sourceTypeId,jdbcType=BIGINT}");
        }

        if (record.getSourceId() != null) {
            SET("source_id = #{record.sourceId,jdbcType=BIGINT}");
        }

        if (record.getPrintCount() != null) {
            SET("print_count = #{record.printCount,jdbcType=INTEGER}");
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