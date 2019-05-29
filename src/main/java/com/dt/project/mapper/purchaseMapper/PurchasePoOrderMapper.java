package com.dt.project.mapper.purchaseMapper;

import com.dt.project.model.purchasePo.PurchasePoOrder;

import java.util.List;

import com.dt.project.provider.PurchasePoOrderSqlProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface PurchasePoOrderMapper {
    @SelectProvider(type = PurchasePoOrderSqlProvider.class, method = "countByExample")
    int countByExample(PurchasePoOrder example);

    @DeleteProvider(type = PurchasePoOrderSqlProvider.class, method = "deleteByExample")
    int deleteByExample(PurchasePoOrder example);

    @Insert({
            "insert into purchase_po_order (po_id, date, ",
            "po_no, po_style_id, ",
            "explanation, fetch_add, ",
            "currency_id, dept_id, ",
            "emp_id, manger_id, ",
            "exchange_rate, children, ",
            "closed, supplier_id, ",
            "contact_person, tel_phone, ",
            "pre_pay_no, pre_pay_amt, ",
            "class_type_id, settlement_date, ",
            "settlement_method_id, po_amt, ",
            "inbound_amt, invoice_company_id, ",
            "invoice_type_id, pay_no, ",
            "pay_amt, erase_amt, ",
            "tran_type, tran_status, ",
            "total_cost_for, order_confirm, ",
            "source_type_id, source_id, ",
            "print_count, status_id, ",
            "version, del_or_not)",
            "values (#{poId,jdbcType=BIGINT}, #{date,jdbcType=BIGINT}, ",
            "#{poNo,jdbcType=VARCHAR}, #{poStyleId,jdbcType=INTEGER}, ",
            "#{explanation,jdbcType=VARCHAR}, #{fetchAdd,jdbcType=VARCHAR}, ",
            "#{currencyId,jdbcType=INTEGER}, #{deptId,jdbcType=INTEGER}, ",
            "#{empId,jdbcType=INTEGER}, #{mangerId,jdbcType=INTEGER}, ",
            "#{exchangeRate,jdbcType=DECIMAL}, #{children,jdbcType=BIT}, ",
            "#{closed,jdbcType=INTEGER}, #{supplierId,jdbcType=INTEGER}, ",
            "#{contactPerson,jdbcType=VARCHAR}, #{telPhone,jdbcType=VARCHAR}, ",
            "#{prePayNo,jdbcType=VARCHAR}, #{prePayAmt,jdbcType=DECIMAL}, ",
            "#{classTypeId,jdbcType=INTEGER}, #{settlementDate,jdbcType=BIGINT}, ",
            "#{settlementMethodId,jdbcType=INTEGER}, #{poAmt,jdbcType=DECIMAL}, ",
            "#{inboundAmt,jdbcType=DECIMAL}, #{invoiceCompanyId,jdbcType=INTEGER}, ",
            "#{invoiceTypeId,jdbcType=INTEGER}, #{payNo,jdbcType=VARCHAR}, ",
            "#{payAmt,jdbcType=DECIMAL}, #{eraseAmt,jdbcType=DECIMAL}, ",
            "#{tranType,jdbcType=INTEGER}, #{tranStatus,jdbcType=INTEGER}, ",
            "#{totalCostFor,jdbcType=REAL}, #{orderConfirm,jdbcType=INTEGER}, ",
            "#{sourceTypeId,jdbcType=BIGINT}, #{sourceId,jdbcType=BIGINT}, ",
            "#{printCount,jdbcType=INTEGER}, #{statusId,jdbcType=BIGINT}, ",
            "#{version,jdbcType=INTEGER}, #{delOrNot,jdbcType=BIT})"
    })
    int insert(PurchasePoOrder record);

    @InsertProvider(type = PurchasePoOrderSqlProvider.class, method = "insertSelective")
    int insertSelective(PurchasePoOrder record);

    /**
     * 查询采购订单表
     *
     * @return
     */
    @SelectProvider(type = PurchasePoOrderSqlProvider.class, method = "selectByPoOrder")
    List<PurchasePoOrder> selectByPoOrder(PurchasePoOrder record);


    @UpdateProvider(type = PurchasePoOrderSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PurchasePoOrder record);

    @UpdateProvider(type = PurchasePoOrderSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PurchasePoOrder record);
}