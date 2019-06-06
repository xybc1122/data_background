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


    /**
     * 新增外购入库表
     *
     * @param record
     * @return
     */
    @Insert({
            "insert into purchase_ic_bill_stock (`supplier_id`,`years`,`period`,date,",
            "no, explanation,",
            "dept_id, emp_id, manger_id, ",
            "children, closed, order_confirm, ",
            "print_count,`status_id`)",
            "values (#{supplierId},#{years},#{period},#{date,jdbcType=BIGINT}, ",
            "#{icNo,jdbcType=VARCHAR}, #{explanation,jdbcType=VARCHAR}, ",
            "#{deptId,jdbcType=INTEGER}, #{empId,jdbcType=INTEGER}, #{mangerId,jdbcType=INTEGER}, ",
            "#{children,jdbcType=BIT}, #{closed,jdbcType=INTEGER}, #{orderConfirm,jdbcType=INTEGER}, ",
            "#{printCount,jdbcType=INTEGER},#{statusId})"
    })
    int insertIcBillStock(PurchaseIcBillStock record);

    /**
     * 查询外购入库接口
     *
     * @param record
     * @return
     */
    @SelectProvider(type = PurchaseIcBillStockSqlProvider.class, method = "selectByIcBillStock")
    @Results({
            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
            @Result(id = true, column = "no", property = "icNo"),
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<PurchaseIcBillStock> selectByIcBillStock(PurchaseIcBillStock record);


    /**
     * 修改入库通知单外表数据
     *
     * @param record
     * @return
     */
    @UpdateProvider(type = PurchaseIcBillStockSqlProvider.class, method = "updateByIcBillStock")
    int updateByIcBillStock(PurchaseIcBillStock record);

}