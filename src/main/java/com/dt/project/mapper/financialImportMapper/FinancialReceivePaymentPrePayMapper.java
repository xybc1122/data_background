package com.dt.project.mapper.financialImportMapper;

import com.dt.project.model.financial.FinancialReceivePaymentPrePay;

import java.util.List;

import com.dt.project.provider.FinancialReceivePaymentPrePaySqlProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface FinancialReceivePaymentPrePayMapper {
    @SelectProvider(type = FinancialReceivePaymentPrePaySqlProvider.class, method = "countByExample")
    int countByExample(FinancialReceivePaymentPrePay example);

    @DeleteProvider(type = FinancialReceivePaymentPrePaySqlProvider.class, method = "deleteByExample")
    int deleteByExample(FinancialReceivePaymentPrePay example);

    @Insert({
            "insert into financial_receive_payment_pre_pay (pre_pay_id, date, ",
            "years, period, no, ",
            "company_id, supplier_id, ",
            "currency_id, exchange_rate, ",
            "emp_id, dept_id, manger_id, ",
            "amount, explanation, ",
            "annex, pay_user_id, ",
            "status_id, version, ",
            "del_or_not)",
            "values (#{prePayId,jdbcType=BIGINT}, #{date,jdbcType=BIGINT}, ",
            "#{years,jdbcType=INTEGER}, #{period,jdbcType=INTEGER}, #{no,jdbcType=VARCHAR}, ",
            "#{companyId,jdbcType=INTEGER}, #{supplierId,jdbcType=INTEGER}, ",
            "#{currencyId,jdbcType=INTEGER}, #{exchangeRate,jdbcType=DECIMAL}, ",
            "#{empId,jdbcType=INTEGER}, #{deptId,jdbcType=INTEGER}, #{mangerId,jdbcType=INTEGER}, ",
            "#{amount,jdbcType=DECIMAL}, #{explanation,jdbcType=VARCHAR}, ",
            "#{annex,jdbcType=VARCHAR}, #{payUserId,jdbcType=INTEGER}, ",
            "#{statusId,jdbcType=BIGINT}, #{version,jdbcType=INTEGER}, ",
            "#{delOrNot,jdbcType=BIT})"
    })
    int insert(FinancialReceivePaymentPrePay record);

    @InsertProvider(type = FinancialReceivePaymentPrePaySqlProvider.class, method = "insertSelective")
    int insertSelective(FinancialReceivePaymentPrePay record);

    /**
     * 查询预付单号
     *
     * @param record
     * @return
     */
    @SelectProvider(type = FinancialReceivePaymentPrePaySqlProvider.class, method = "selectByFRPaymentPrePay")
    List<FinancialReceivePaymentPrePay> selectByFRPaymentPrePay(FinancialReceivePaymentPrePay record);

    @UpdateProvider(type = FinancialReceivePaymentPrePaySqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FinancialReceivePaymentPrePay record);

    @UpdateProvider(type = FinancialReceivePaymentPrePaySqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") FinancialReceivePaymentPrePay record);
}