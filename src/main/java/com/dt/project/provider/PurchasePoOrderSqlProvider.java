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

import com.dt.project.model.purchasePo.PurchasePoOrder;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.store.FieldStore;
import com.dt.project.store.ProviderSqlStore;
import com.dt.project.toos.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class PurchasePoOrderSqlProvider {

    public String countByExample(PurchasePoOrder example) {
        BEGIN();
        SELECT("count(*)");
        FROM("purchase_po_order");

        return SQL();
    }

    public String deleteByExample(PurchasePoOrder example) {
        BEGIN();
        DELETE_FROM("purchase_po_order");

        return SQL();
    }

    public String insertSelective(PurchasePoOrder record) {
        BEGIN();
        INSERT_INTO("purchase_po_order");

        if (record.getPoId() != null) {
            VALUES("po_id", "#{poId,jdbcType=BIGINT}");
        }

        if (record.getDate() != null) {
            VALUES("date", "#{date,jdbcType=BIGINT}");
        }

        if (record.getNo() != null) {
            VALUES("no", "#{no,jdbcType=VARCHAR}");
        }

        if (record.getPoStyleId() != null) {
            VALUES("po_style_id", "#{poStyleId,jdbcType=INTEGER}");
        }

        if (record.getExplanation() != null) {
            VALUES("explanation", "#{explanation,jdbcType=VARCHAR}");
        }

        if (record.getFetchAdd() != null) {
            VALUES("fetch_add", "#{fetchAdd,jdbcType=VARCHAR}");
        }

        if (record.getCurrencyId() != null) {
            VALUES("currency_id", "#{currencyId,jdbcType=INTEGER}");
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

        if (record.getExchangeRate() != null) {
            VALUES("exchange_rate", "#{exchangeRate,jdbcType=DECIMAL}");
        }

        if (record.getChildren() != null) {
            VALUES("children", "#{children,jdbcType=BIT}");
        }

        if (record.getClosed() != null) {
            VALUES("closed", "#{closed,jdbcType=INTEGER}");
        }

        if (record.getSupplierId() != null) {
            VALUES("supplier_id", "#{supplierId,jdbcType=INTEGER}");
        }

        if (record.getContactPerson() != null) {
            VALUES("contact_person", "#{contactPerson,jdbcType=VARCHAR}");
        }

        if (record.getTelPhone() != null) {
            VALUES("tel_phone", "#{telPhone,jdbcType=VARCHAR}");
        }

        if (record.getPrePayId() != null) {
            VALUES("pre_pay_no", "#{prePayNo,jdbcType=VARCHAR}");
        }

        if (record.getPrePayAmt() != null) {
            VALUES("pre_pay_amt", "#{prePayAmt,jdbcType=DECIMAL}");
        }

        if (record.getClassTypeId() != null) {
            VALUES("class_type_id", "#{classTypeId,jdbcType=INTEGER}");
        }

        if (record.getSettlementDate() != null) {
            VALUES("settlement_date", "#{settlementDate,jdbcType=BIGINT}");
        }

        if (record.getSettlementMethodId() != null) {
            VALUES("settlement_method_id", "#{settlementMethodId,jdbcType=INTEGER}");
        }

        if (record.getPoAmt() != null) {
            VALUES("po_amt", "#{poAmt,jdbcType=DECIMAL}");
        }

        if (record.getInboundAmt() != null) {
            VALUES("inbound_amt", "#{inboundAmt,jdbcType=DECIMAL}");
        }
//
//        if (record.getInvoiceCompanyId() != null) {
//            VALUES("invoice_company_id", "#{invoiceCompanyId,jdbcType=INTEGER}");
//        }

        if (record.getInvoiceTypeId() != null) {
            VALUES("invoice_type_id", "#{invoiceTypeId,jdbcType=INTEGER}");
        }
//
//        if (record.getPayNo() != null) {
//            VALUES("pay_no", "#{payNo,jdbcType=VARCHAR}");
//        }

        if (record.getPayAmt() != null) {
            VALUES("pay_amt", "#{payAmt,jdbcType=DECIMAL}");
        }

        if (record.getEraseAmt() != null) {
            VALUES("erase_amt", "#{eraseAmt,jdbcType=DECIMAL}");
        }

        if (record.getTranType() != null) {
            VALUES("tran_type", "#{tranType,jdbcType=INTEGER}");
        }

        if (record.getTranStatus() != null) {
            VALUES("tran_status", "#{tranStatus,jdbcType=INTEGER}");
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

    public String selectByPoOrder(PurchasePoOrder poOrder) throws IllegalAccessException {
        String alias = "po";
        SQL sql = new SQL();
        sql.SELECT("fit.`type_name`,psm.`name`,bpc.`company_name`,rpp.`no` AS perPayNo,bps.`supplier_full_name`," +
                "cu.`currency_id`,cu.`currency_name`,dep.`dept_name`,se.`employee_name` AS empName," +
                "se1.`employee_name` AS mangerName," + alias + ".`po_id`," + alias + ".`date`," +
                "" + alias + ".`no`,`po_style_id`," + alias + ".`explanation`,\n" +
                "`fetch_add`," + alias + ".`emp_id`,\n" +
                "" + alias + ".`manger_id`," + alias + ".`exchange_rate`,`children`,`closed`,\n" +
                "" + alias + ".`supplier_id`," + alias + ".`contact_person`," + alias + ".`tel_phone`," + alias + ".`pre_pay_id`,\n" +
                "`pre_pay_amt`,`class_type_id`,`settlement_date`,\n" +
                "`settlement_method_id`,`po_amt`,`inbound_amt`," + alias + ".`company_id`,\n" +
                "" + alias + ".`invoice_type_id`," + alias + ".`pay_id`,`pay_amt`,`erase_amt`,`tran_type`, `tran_status`,\n" +
                "`order_confirm`,`print_count`,\n" +
                "" + alias + ".`status_id`," + alias + ".`version` FROM `purchase_po_order` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("basic_public_currency AS cu ON cu.`currency_id` = " + alias + ".`currency_id`");
        sql.LEFT_OUTER_JOIN("hr_archives_department AS dep ON dep.`dept_id`=" + alias + ".`dept_id`");
        sql.LEFT_OUTER_JOIN("`hr_archives_employee` AS se ON se.`s_id` = " + alias + ".`emp_id`");
        sql.LEFT_OUTER_JOIN("`hr_archives_employee` AS se1 ON se1.`s_id` = " + alias + ".`manger_id`");
        sql.LEFT_OUTER_JOIN("`basic_purchase_supplier` AS bps ON bps.`supplier_id` = " + alias + ".`supplier_id`");
        sql.LEFT_OUTER_JOIN("`financial_receive_payment_pre_pay` AS rpp ON rpp.`pre_pay_id` = " + alias + ".`pre_pay_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_company` AS bpc ON bpc.`company_id` = " + alias + ".`company_id`");
        sql.LEFT_OUTER_JOIN("`financial_receive_payment_pay` AS rp ON bpc.`company_id` = " + alias + ".`company_id`");
        sql.LEFT_OUTER_JOIN("`basic_purchase_settlement_method` AS psm ON psm.`sm_id` = " + alias + ".`settlement_method_id`");
        sql.LEFT_OUTER_JOIN("`basic_financial_invoice_type` AS fit ON fit.`it_id` = " + alias + ".`invoice_type_id`");
        //查询币别名称
        AppendSqlStore.sqlWhere(poOrder.getCurrencyName(), "cu.`currency_name`", sql, Constants.SELECT);
        //查询部门名称
        AppendSqlStore.sqlWhere(poOrder.getDeptName(), "dep.`dept_name`", sql, Constants.SELECT);
        //查询业务员
        AppendSqlStore.sqlWhere(poOrder.getEmpName(), "se.`employee_name`", sql, Constants.SELECT);
        //查询主管
        AppendSqlStore.sqlWhere(poOrder.getMangerName(), "se1.`employee_name`", sql, Constants.SELECT);
        //查询供应商
        AppendSqlStore.sqlWhere(poOrder.getMangerName(), "dep.`dept_name`", sql, Constants.SELECT);
        //查询预付单号
        AppendSqlStore.sqlWhere(poOrder.getPerPayNo(), "rpp.`no`", sql, Constants.SELECT);
        //发票抬头公司名称
        AppendSqlStore.sqlWhere(poOrder.getCurrencyName(), "bpc.`company_name`", sql, Constants.SELECT);
        //结算方式名称
        AppendSqlStore.sqlWhere(poOrder.getName(), "psm.`name`", sql, Constants.SELECT);

        //发票类型名称
        AppendSqlStore.sqlWhere(poOrder.getTypeName(), "fit.`type_name`", sql, Constants.SELECT);

        //sql动态查询
        FieldStore.query(poOrder.getClass(), poOrder.getJavaSqlName(), poOrder, sql);
        ProviderSqlStore.selectStatus(poOrder.getSystemLogStatus(), alias, sql);
        return sql.toString();
    }

    public String updateByPoOrder(PurchasePoOrder record) {
        SQL sql = new SQL();
        sql.UPDATE("purchase_po_order");
        if (record.getDate() != null) {
            sql.SET("date = #{date,jdbcType=BIGINT}");
        }

        if (StringUtils.isNotBlank(record.getNo())) {
            sql.SET("no = #{no,jdbcType=VARCHAR}");
        }

        if (record.getPoStyleId() != null) {
            sql.SET("po_style_id = #{poStyleId,jdbcType=INTEGER}");
        }

        if (StringUtils.isNotBlank(record.getExplanation())) {
            sql.SET("explanation = #{explanation,jdbcType=VARCHAR}");
        }

        if (StringUtils.isNotBlank(record.getFetchAdd())) {
            sql.SET("fetch_add = #{fetchAdd,jdbcType=VARCHAR}");
        }

        if (record.getCurrencyId() != null) {
            sql.SET("currency_id = #{currencyId,jdbcType=INTEGER}");
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

        if (record.getExchangeRate() != null) {
            sql.SET("exchange_rate = #{exchangeRate,jdbcType=DECIMAL}");
        }

        if (record.getChildren() != null) {
            sql.SET("children = #{children,jdbcType=BIT}");
        }

        if (record.getClosed() != null) {
            sql.SET("closed = #{closed,jdbcType=INTEGER}");
        }

        if (record.getSupplierId() != null) {
            sql.SET("supplier_id = #{supplierId,jdbcType=INTEGER}");
        }

        if (StringUtils.isNotBlank(record.getContactPerson())) {
            sql.SET("contact_person = #{contactPerson,jdbcType=VARCHAR}");
        }

        if (StringUtils.isNotBlank(record.getTelPhone())) {
            sql.SET("tel_phone = #{telPhone,jdbcType=VARCHAR}");
        }

        if (record.getPrePayId() == null) {
            sql.SET("pre_pay_id = #{prePayId,jdbcType=BIGINT}");
        }

        if (record.getPrePayAmt() != null) {
            sql.SET("pre_pay_amt = #{prePayAmt,jdbcType=DECIMAL}");
        }

        if (record.getClassTypeId() != null) {
            sql.SET("class_type_id = #{classTypeId,jdbcType=INTEGER}");
        }

        if (record.getSettlementDate() != null) {
            sql.SET("settlement_date = #{settlementDate,jdbcType=BIGINT}");
        }

        if (record.getSettlementMethodId() != null) {
            sql.SET("settlement_method_id = #{settlementMethodId,jdbcType=INTEGER}");
        }

        if (record.getPoAmt() != null) {
            sql.SET("po_amt = #{poAmt,jdbcType=DECIMAL}");
        }

        if (record.getInboundAmt() != null) {
            sql.SET("inbound_amt = #{inboundAmt,jdbcType=DECIMAL}");
        }

        if (record.getCompanyId() != null) {
            sql.SET("company_id = #{companyId,jdbcType=INTEGER}");
        }

        if (record.getInvoiceTypeId() != null) {
            sql.SET("invoice_type_id = #{invoiceTypeId,jdbcType=INTEGER}");
        }

        if (record.getPayId() != null) {
            sql.SET("pay_id = #{payId,jdbcType=BIGINT}");
        }

        if (record.getPayAmt() != null) {
            sql.SET("pay_amt = #{payAmt,jdbcType=DECIMAL}");
        }

        if (record.getEraseAmt() != null) {
            sql.SET("erase_amt = #{eraseAmt,jdbcType=DECIMAL}");
        }

        if (record.getTranType() != null) {
            sql.SET("tran_type = #{tranType,jdbcType=INTEGER}");
        }

        if (record.getTranStatus() != null) {
            sql.SET("tran_status = #{tranStatus,jdbcType=INTEGER}");
        }

        if (record.getOrderConfirm() != null) {
            sql.SET("order_confirm = #{orderConfirm,jdbcType=INTEGER}");
        }
//
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

        if (record.getStatusId() != null) {
            sql.SET("status_id = #{statusId,jdbcType=BIGINT}");
        }
        sql.WHERE("po_id = #{poId,jdbcType=BIGINT}");
        ProviderSqlStore.setVersion(sql, record.getVersion());
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("purchase_po_order");

        SET("po_id = #{record.poId,jdbcType=BIGINT}");
        SET("date = #{record.date,jdbcType=BIGINT}");
        SET("po_no = #{record.poNo,jdbcType=VARCHAR}");
        SET("po_style_id = #{record.poStyleId,jdbcType=INTEGER}");
        SET("explanation = #{record.explanation,jdbcType=VARCHAR}");
        SET("fetch_add = #{record.fetchAdd,jdbcType=VARCHAR}");
        SET("currency_id = #{record.currencyId,jdbcType=INTEGER}");
        SET("dept_id = #{record.deptId,jdbcType=INTEGER}");
        SET("emp_id = #{record.empId,jdbcType=INTEGER}");
        SET("manger_id = #{record.mangerId,jdbcType=INTEGER}");
        SET("exchange_rate = #{record.exchangeRate,jdbcType=DECIMAL}");
        SET("children = #{record.children,jdbcType=BIT}");
        SET("closed = #{record.closed,jdbcType=INTEGER}");
        SET("supplier_id = #{record.supplierId,jdbcType=INTEGER}");
        SET("contact_person = #{record.contactPerson,jdbcType=VARCHAR}");
        SET("tel_phone = #{record.telPhone,jdbcType=VARCHAR}");
        SET("pre_pay_no = #{record.prePayNo,jdbcType=VARCHAR}");
        SET("pre_pay_amt = #{record.prePayAmt,jdbcType=DECIMAL}");
        SET("class_type_id = #{record.classTypeId,jdbcType=INTEGER}");
        SET("settlement_date = #{record.settlementDate,jdbcType=BIGINT}");
        SET("settlement_method_id = #{record.settlementMethodId,jdbcType=INTEGER}");
        SET("po_amt = #{record.poAmt,jdbcType=DECIMAL}");
        SET("inbound_amt = #{record.inboundAmt,jdbcType=DECIMAL}");
        SET("invoice_company_id = #{record.invoiceCompanyId,jdbcType=INTEGER}");
        SET("invoice_type_id = #{record.invoiceTypeId,jdbcType=INTEGER}");
        SET("pay_no = #{record.payNo,jdbcType=VARCHAR}");
        SET("pay_amt = #{record.payAmt,jdbcType=DECIMAL}");
        SET("erase_amt = #{record.eraseAmt,jdbcType=DECIMAL}");
        SET("tran_type = #{record.tranType,jdbcType=INTEGER}");
        SET("tran_status = #{record.tranStatus,jdbcType=INTEGER}");
        SET("total_cost_for = #{record.totalCostFor,jdbcType=REAL}");
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