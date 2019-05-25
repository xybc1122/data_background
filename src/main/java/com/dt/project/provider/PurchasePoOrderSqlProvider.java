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

import com.dt.project.model.PurchasePo.PurchasePoOrder;
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

        if (record.getPoNo() != null) {
            VALUES("po_no", "#{poNo,jdbcType=VARCHAR}");
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

        if (record.getPrePayNo() != null) {
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

        if (record.getInvoiceCompanyId() != null) {
            VALUES("invoice_company_id", "#{invoiceCompanyId,jdbcType=INTEGER}");
        }

        if (record.getInvoiceTypeId() != null) {
            VALUES("invoice_type_id", "#{invoiceTypeId,jdbcType=INTEGER}");
        }

        if (record.getPayNo() != null) {
            VALUES("pay_no", "#{payNo,jdbcType=VARCHAR}");
        }

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

        if (record.getTotalCostFor() != null) {
            VALUES("total_cost_for", "#{totalCostFor,jdbcType=REAL}");
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

    public String selectByPoOrder(PurchasePoOrder poOrder) {
        SQL sql = new SQL();












        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PurchasePoOrder record = (PurchasePoOrder) parameter.get("record");


        BEGIN();
        UPDATE("purchase_po_order");

        if (record.getPoId() != null) {
            SET("po_id = #{record.poId,jdbcType=BIGINT}");
        }

        if (record.getDate() != null) {
            SET("date = #{record.date,jdbcType=BIGINT}");
        }

        if (record.getPoNo() != null) {
            SET("po_no = #{record.poNo,jdbcType=VARCHAR}");
        }

        if (record.getPoStyleId() != null) {
            SET("po_style_id = #{record.poStyleId,jdbcType=INTEGER}");
        }

        if (record.getExplanation() != null) {
            SET("explanation = #{record.explanation,jdbcType=VARCHAR}");
        }

        if (record.getFetchAdd() != null) {
            SET("fetch_add = #{record.fetchAdd,jdbcType=VARCHAR}");
        }

        if (record.getCurrencyId() != null) {
            SET("currency_id = #{record.currencyId,jdbcType=INTEGER}");
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

        if (record.getExchangeRate() != null) {
            SET("exchange_rate = #{record.exchangeRate,jdbcType=DECIMAL}");
        }

        if (record.getChildren() != null) {
            SET("children = #{record.children,jdbcType=BIT}");
        }

        if (record.getClosed() != null) {
            SET("closed = #{record.closed,jdbcType=INTEGER}");
        }

        if (record.getSupplierId() != null) {
            SET("supplier_id = #{record.supplierId,jdbcType=INTEGER}");
        }

        if (record.getContactPerson() != null) {
            SET("contact_person = #{record.contactPerson,jdbcType=VARCHAR}");
        }

        if (record.getTelPhone() != null) {
            SET("tel_phone = #{record.telPhone,jdbcType=VARCHAR}");
        }

        if (record.getPrePayNo() != null) {
            SET("pre_pay_no = #{record.prePayNo,jdbcType=VARCHAR}");
        }

        if (record.getPrePayAmt() != null) {
            SET("pre_pay_amt = #{record.prePayAmt,jdbcType=DECIMAL}");
        }

        if (record.getClassTypeId() != null) {
            SET("class_type_id = #{record.classTypeId,jdbcType=INTEGER}");
        }

        if (record.getSettlementDate() != null) {
            SET("settlement_date = #{record.settlementDate,jdbcType=BIGINT}");
        }

        if (record.getSettlementMethodId() != null) {
            SET("settlement_method_id = #{record.settlementMethodId,jdbcType=INTEGER}");
        }

        if (record.getPoAmt() != null) {
            SET("po_amt = #{record.poAmt,jdbcType=DECIMAL}");
        }

        if (record.getInboundAmt() != null) {
            SET("inbound_amt = #{record.inboundAmt,jdbcType=DECIMAL}");
        }

        if (record.getInvoiceCompanyId() != null) {
            SET("invoice_company_id = #{record.invoiceCompanyId,jdbcType=INTEGER}");
        }

        if (record.getInvoiceTypeId() != null) {
            SET("invoice_type_id = #{record.invoiceTypeId,jdbcType=INTEGER}");
        }

        if (record.getPayNo() != null) {
            SET("pay_no = #{record.payNo,jdbcType=VARCHAR}");
        }

        if (record.getPayAmt() != null) {
            SET("pay_amt = #{record.payAmt,jdbcType=DECIMAL}");
        }

        if (record.getEraseAmt() != null) {
            SET("erase_amt = #{record.eraseAmt,jdbcType=DECIMAL}");
        }

        if (record.getTranType() != null) {
            SET("tran_type = #{record.tranType,jdbcType=INTEGER}");
        }

        if (record.getTranStatus() != null) {
            SET("tran_status = #{record.tranStatus,jdbcType=INTEGER}");
        }

        if (record.getTotalCostFor() != null) {
            SET("total_cost_for = #{record.totalCostFor,jdbcType=REAL}");
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