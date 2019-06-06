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

import com.dt.project.model.financial.FinancialReceivePaymentPrePay;
import com.dt.project.store.FieldStore;
import com.dt.project.store.ProviderSqlStore;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class FinancialReceivePaymentPrePaySqlProvider {

    public String countByExample(FinancialReceivePaymentPrePay example) {
        BEGIN();
        SELECT("count(*)");
        FROM("financial_receive_payment_pre_pay");

        return SQL();
    }

    public String deleteByExample(FinancialReceivePaymentPrePay example) {
        BEGIN();
        DELETE_FROM("financial_receive_payment_pre_pay");

        return SQL();
    }

    public String insertSelective(FinancialReceivePaymentPrePay record) {
        BEGIN();
        INSERT_INTO("financial_receive_payment_pre_pay");

        if (record.getPrePayId() != null) {
            VALUES("pre_pay_id", "#{prePayId,jdbcType=BIGINT}");
        }

        if (record.getDate() != null) {
            VALUES("date", "#{date,jdbcType=BIGINT}");
        }

        if (record.getYears() != null) {
            VALUES("years", "#{years,jdbcType=INTEGER}");
        }

        if (record.getPeriod() != null) {
            VALUES("period", "#{period,jdbcType=INTEGER}");
        }

        if (record.getNo() != null) {
            VALUES("no", "#{no,jdbcType=VARCHAR}");
        }

        if (record.getCompanyId() != null) {
            VALUES("company_id", "#{companyId,jdbcType=INTEGER}");
        }

        if (record.getSupplierId() != null) {
            VALUES("supplier_id", "#{supplierId,jdbcType=INTEGER}");
        }

        if (record.getCurrencyId() != null) {
            VALUES("currency_id", "#{currencyId,jdbcType=INTEGER}");
        }

        if (record.getExchangeRate() != null) {
            VALUES("exchange_rate", "#{exchangeRate,jdbcType=DECIMAL}");
        }

        if (record.getEmpId() != null) {
            VALUES("emp_id", "#{empId,jdbcType=INTEGER}");
        }

        if (record.getDeptId() != null) {
            VALUES("dept_id", "#{deptId,jdbcType=INTEGER}");
        }

        if (record.getMangerId() != null) {
            VALUES("manger_id", "#{mangerId,jdbcType=INTEGER}");
        }

        if (record.getAmount() != null) {
            VALUES("amount", "#{amount,jdbcType=DECIMAL}");
        }

        if (record.getExplanation() != null) {
            VALUES("explanation", "#{explanation,jdbcType=VARCHAR}");
        }

        if (record.getAnnex() != null) {
            VALUES("annex", "#{annex,jdbcType=VARCHAR}");
        }

        if (record.getPayUserId() != null) {
            VALUES("pay_user_id", "#{payUserId,jdbcType=INTEGER}");
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

    public String selectByFRPaymentPrePay(FinancialReceivePaymentPrePay record) throws IllegalAccessException {
        String alias = "rpp";
        SQL sql = new SQL();
        sql.SELECT(" `pre_pay_id`,`date`,`years`,`period`,`no`,\n" +
                "`company_id`,`supplier_id`,`currency_id`,`exchange_rate`,\n" +
                "`emp_id`,`dept_id`,`manger_id`,`amount`,\n" +
                "`explanation`,`annex`,`pay_user_id`,`status_id`\n" +
                "FROM `financial_receive_payment_pre_pay` AS " + alias + "\n");
        //sql动态查询
        FieldStore.query(record.getClass(), record.getJsonArray(), record, sql,alias);
        ProviderSqlStore.selectStatus(record.getSystemLogStatus(), alias, sql);
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        FinancialReceivePaymentPrePay record = (FinancialReceivePaymentPrePay) parameter.get("record");

        BEGIN();
        UPDATE("financial_receive_payment_pre_pay");

        if (record.getPrePayId() != null) {
            SET("pre_pay_id = #{record.prePayId,jdbcType=BIGINT}");
        }

        if (record.getDate() != null) {
            SET("date = #{record.date,jdbcType=BIGINT}");
        }

        if (record.getYears() != null) {
            SET("years = #{record.years,jdbcType=INTEGER}");
        }

        if (record.getPeriod() != null) {
            SET("period = #{record.period,jdbcType=INTEGER}");
        }

        if (record.getNo() != null) {
            SET("no = #{record.no,jdbcType=VARCHAR}");
        }

        if (record.getCompanyId() != null) {
            SET("company_id = #{record.companyId,jdbcType=INTEGER}");
        }

        if (record.getSupplierId() != null) {
            SET("supplier_id = #{record.supplierId,jdbcType=INTEGER}");
        }

        if (record.getCurrencyId() != null) {
            SET("currency_id = #{record.currencyId,jdbcType=INTEGER}");
        }

        if (record.getExchangeRate() != null) {
            SET("exchange_rate = #{record.exchangeRate,jdbcType=DECIMAL}");
        }

        if (record.getEmpId() != null) {
            SET("emp_id = #{record.empId,jdbcType=INTEGER}");
        }

        if (record.getDeptId() != null) {
            SET("dept_id = #{record.deptId,jdbcType=INTEGER}");
        }

        if (record.getMangerId() != null) {
            SET("manger_id = #{record.mangerId,jdbcType=INTEGER}");
        }

        if (record.getAmount() != null) {
            SET("amount = #{record.amount,jdbcType=DECIMAL}");
        }

        if (record.getExplanation() != null) {
            SET("explanation = #{record.explanation,jdbcType=VARCHAR}");
        }

        if (record.getAnnex() != null) {
            SET("annex = #{record.annex,jdbcType=VARCHAR}");
        }

        if (record.getPayUserId() != null) {
            SET("pay_user_id = #{record.payUserId,jdbcType=INTEGER}");
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
        UPDATE("financial_receive_payment_pre_pay");

        SET("pre_pay_id = #{record.prePayId,jdbcType=BIGINT}");
        SET("date = #{record.date,jdbcType=BIGINT}");
        SET("years = #{record.years,jdbcType=INTEGER}");
        SET("period = #{record.period,jdbcType=INTEGER}");
        SET("no = #{record.no,jdbcType=VARCHAR}");
        SET("company_id = #{record.companyId,jdbcType=INTEGER}");
        SET("supplier_id = #{record.supplierId,jdbcType=INTEGER}");
        SET("currency_id = #{record.currencyId,jdbcType=INTEGER}");
        SET("exchange_rate = #{record.exchangeRate,jdbcType=DECIMAL}");
        SET("emp_id = #{record.empId,jdbcType=INTEGER}");
        SET("dept_id = #{record.deptId,jdbcType=INTEGER}");
        SET("manger_id = #{record.mangerId,jdbcType=INTEGER}");
        SET("amount = #{record.amount,jdbcType=DECIMAL}");
        SET("explanation = #{record.explanation,jdbcType=VARCHAR}");
        SET("annex = #{record.annex,jdbcType=VARCHAR}");
        SET("pay_user_id = #{record.payUserId,jdbcType=INTEGER}");
        SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");


        return SQL();
    }

}