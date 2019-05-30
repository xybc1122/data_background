package com.dt.project.mapper.purchaseMapper;

import com.dt.project.provider.PurchaseIcBillStockSqlProvider;
import com.dt.project.model.purchasePo.PurchaseIcBillStock;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

public interface PurchaseIcBillStockMapper {
    @SelectProvider(type = PurchaseIcBillStockSqlProvider.class, method = "countByExample")
    int countByExample(PurchaseIcBillStock example);

    @DeleteProvider(type = PurchaseIcBillStockSqlProvider.class, method = "deleteByExample")
    int deleteByExample(PurchaseIcBillStock example);

    @Insert({
            "insert into purchase_ic_bill_stock (sb_id, date, ",
            "no, explanation, ",
            "dept_id, emp_id, manger_id, ",
            "children, closed, order_confirm, ",
            "source_type_id, source_id, ",
            "print_count, status_id, ",
            "version, del_or_not)",
            "values (#{sbId,jdbcType=BIGINT}, #{date,jdbcType=BIGINT}, ",
            "#{no,jdbcType=VARCHAR}, #{explanation,jdbcType=VARCHAR}, ",
            "#{deptId,jdbcType=INTEGER}, #{empId,jdbcType=INTEGER}, #{mangerId,jdbcType=INTEGER}, ",
            "#{children,jdbcType=BIT}, #{closed,jdbcType=INTEGER}, #{orderConfirm,jdbcType=INTEGER}, ",
            "#{sourceTypeId,jdbcType=BIGINT}, #{sourceId,jdbcType=BIGINT}, ",
            "#{printCount,jdbcType=INTEGER}, #{statusId,jdbcType=BIGINT}, ",
            "#{version,jdbcType=INTEGER}, #{delOrNot,jdbcType=BIT})"
    })
    int insert(PurchaseIcBillStock record);

    @InsertProvider(type = PurchaseIcBillStockSqlProvider.class, method = "insertSelective")
    int insertSelective(PurchaseIcBillStock record);

    /**
     * 查询外购入库接口
     *
     * @param record
     * @return
     */
    @SelectProvider(type = PurchaseIcBillStockSqlProvider.class, method = "selectByIcBillStock")
    @Results({
            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<PurchaseIcBillStock> selectByIcBillStock(PurchaseIcBillStock record);


    @UpdateProvider(type = PurchaseIcBillStockSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PurchaseIcBillStock record, @Param("example") PurchaseIcBillStock example);

    @UpdateProvider(type = PurchaseIcBillStockSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PurchaseIcBillStock record, @Param("example") PurchaseIcBillStock example);
}