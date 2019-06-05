package com.dt.project.mapper.purchaseMapper;

import com.dt.project.model.purchasePo.PurchasePoOrder;

import java.util.List;

import com.dt.project.provider.PurchasePoOrderSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

public interface PurchasePoOrderMapper {
    @SelectProvider(type = PurchasePoOrderSqlProvider.class, method = "countByExample")
    int countByExample(PurchasePoOrder example);

    @DeleteProvider(type = PurchasePoOrderSqlProvider.class, method = "deleteByExample")
    int deleteByExample(PurchasePoOrder example);

    /**
     * 新增采购订单
     *
     * @param record
     * @return
     */
    @Insert({
            "insert into purchase_po_order (po_id, date, ",
            "no, po_style_id, explanation, ",
            "fetch_add, currency_id, ",
            "dept_id, emp_id, manger_id, ",
            "exchange_rate, children, ",
            "closed, supplier_id, ",
            "contact_person, tel_phone, ",
            "pre_pay_id, pre_pay_amt, ",
            "class_type_id, settlement_date, ",
            "settlement_method_id, po_amt, ",
            "inbound_amt, company_id, ",
            "invoice_type_id, pay_id, ",
            "pay_amt, erase_amt, ",
            "tran_type, tran_status, ",
            "order_confirm,print_count)",
            "values (#{poId,jdbcType=BIGINT}, #{date,jdbcType=BIGINT}, ",
            "#{no,jdbcType=VARCHAR}, #{poStyleId,jdbcType=INTEGER}, #{explanation,jdbcType=VARCHAR}, ",
            "#{fetchAdd,jdbcType=VARCHAR}, #{currencyId,jdbcType=INTEGER}, ",
            "#{deptId,jdbcType=INTEGER}, #{empId,jdbcType=INTEGER}, #{mangerId,jdbcType=INTEGER}, ",
            "#{exchangeRate,jdbcType=DECIMAL}, #{children,jdbcType=BIT}, ",
            "#{closed,jdbcType=INTEGER}, #{supplierId,jdbcType=INTEGER}, ",
            "#{contactPerson,jdbcType=VARCHAR}, #{telPhone,jdbcType=VARCHAR}, ",
            "#{prePayId,jdbcType=BIGINT}, #{prePayAmt,jdbcType=DECIMAL}, ",
            "#{classTypeId,jdbcType=INTEGER}, #{settlementDate,jdbcType=BIGINT}, ",
            "#{settlementMethodId,jdbcType=INTEGER}, #{poAmt,jdbcType=DECIMAL}, ",
            "#{inboundAmt,jdbcType=DECIMAL}, #{companyId,jdbcType=INTEGER}, ",
            "#{invoiceTypeId,jdbcType=INTEGER}, #{payId,jdbcType=BIGINT}, ",
            "#{payAmt,jdbcType=DECIMAL}, #{eraseAmt,jdbcType=DECIMAL}, ",
            "#{tranType,jdbcType=INTEGER}, #{tranStatus,jdbcType=INTEGER}, ",
            "#{orderConfirm,jdbcType=INTEGER},#{printCount,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "poId", keyColumn = "po_id")
    int insertPoOrder(PurchasePoOrder record);


    @InsertProvider(type = PurchasePoOrderSqlProvider.class, method = "insertSelective")
    int insertSelective(PurchasePoOrder record);

    /**
     * 查询采购订单表
     *
     * @return
     */
    @SelectProvider(type = PurchasePoOrderSqlProvider.class, method = "selectByPoOrder")
    @Results({
            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<PurchasePoOrder> selectByPoOrder(PurchasePoOrder record);

    /**
     * 修改采购订单外表
     *
     * @param record
     * @return
     */
    @UpdateProvider(type = PurchasePoOrderSqlProvider.class, method = "updateByPoOrder")
    int updateByPoOrder(PurchasePoOrder record);

    @UpdateProvider(type = PurchasePoOrderSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PurchasePoOrder record);
}