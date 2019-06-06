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


    public String selectByPoOrder(PurchasePoOrder poOrder) throws IllegalAccessException {
        String alias = "po";
        SQL sql = new SQL();
        sql.SELECT("" + ProviderSqlStore.docV() + ",fit.`type_name`,psm.`name`,bpc.`company_name`,rpp.`no` AS perPayNo," +
                "cu.`currency_id`,cu.`currency_name`," + alias + ".`po_id`," + alias + ".`date`," +
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
        sql.LEFT_OUTER_JOIN("`financial_receive_payment_pre_pay` AS rpp ON rpp.`pre_pay_id` = " + alias + ".`pre_pay_id`");
        sql.LEFT_OUTER_JOIN("`basic_public_company` AS bpc ON bpc.`company_id` = " + alias + ".`company_id`");
        sql.LEFT_OUTER_JOIN("`basic_purchase_settlement_method` AS psm ON psm.`sm_id` = " + alias + ".`settlement_method_id`");
        sql.LEFT_OUTER_JOIN("`basic_financial_invoice_type` AS fit ON fit.`it_id` = " + alias + ".`invoice_type_id`");

        //外表体通用设计
        ProviderSqlStore.setDocument(sql, alias, poOrder);

        //查询币别名称
        AppendSqlStore.sqlWhere(poOrder.getCurrencyName(), "cu.`currency_name`", sql, Constants.SELECT,alias);

        //查询预付单号
        AppendSqlStore.sqlWhere(poOrder.getPerPayNo(), "rpp.`no`", sql, Constants.SELECT,alias);

        //发票抬头公司名称
        AppendSqlStore.sqlWhere(poOrder.getCompanyName(), "bpc.`company_name`", sql, Constants.SELECT,alias);

        //结算方式名称
        AppendSqlStore.sqlWhere(poOrder.getName(), "psm.`name`", sql, Constants.SELECT,alias);

        //发票类型名称
        AppendSqlStore.sqlWhere(poOrder.getTypeName(), "fit.`type_name`", sql, Constants.SELECT,alias);

        //sql动态查询
        FieldStore.query(poOrder.getClass(), poOrder.getJsonArray(), poOrder, sql,alias);
        ProviderSqlStore.selectStatus(poOrder.getSystemLogStatus(), alias, sql);
        return sql.toString();
    }

    public String updateByPoOrder(PurchasePoOrder record) {
        SQL sql = new SQL();
        sql.UPDATE("purchase_po_order");
        if (record.getDate() != null) {
            sql.SET("date = #{date,jdbcType=BIGINT}");
        }

        if (StringUtils.isNotBlank(record.getPoNo())) {
            sql.SET("no = #{poNo,jdbcType=VARCHAR}");
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


}