package com.dt.project.mapper.purchaseMapper;

import com.dt.project.provider.PurchasePoReceiptNoticeSqlProvider;
import com.dt.project.model.purchasePo.PurchasePoReceiptNotice;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

public interface PurchasePoReceiptNoticeMapper {
    @SelectProvider(type = PurchasePoReceiptNoticeSqlProvider.class, method = "countByExample")
    int countByExample(PurchasePoReceiptNotice example);

    @DeleteProvider(type = PurchasePoReceiptNoticeSqlProvider.class, method = "deleteByExample")
    int deleteByExample(PurchasePoReceiptNotice example);


    /**
     * 新增收货通知单
     *
     * @param record
     * @return
     */
    @Insert({
            "insert into purchase_po_receipt_notice (date, ",
            "no, explanation,",
            "fetch_add, dept_id,",
            "emp_id, manger_id,",
            "children, closed, order_confirm,",
            "source_type_id, source_id,",
            "print_count, status_id)",
            "values (#{date,jdbcType=BIGINT},",
            "#{no,jdbcType=VARCHAR}, #{explanation,jdbcType=VARCHAR},",
            "#{fetchAdd,jdbcType=VARCHAR}, #{deptId,jdbcType=INTEGER},",
            "#{empId,jdbcType=INTEGER}, #{mangerId,jdbcType=INTEGER},",
            "#{children,jdbcType=BIT}, #{closed,jdbcType=INTEGER}, #{orderConfirm,jdbcType=INTEGER}, ",
            "#{sourceTypeId,jdbcType=BIGINT}, #{sourceId,jdbcType=BIGINT},",
            "#{printCount,jdbcType=INTEGER}, #{statusId,jdbcType=BIGINT})"
    })
    int insertPoReceiptNotice(PurchasePoReceiptNotice record);

    @InsertProvider(type = PurchasePoReceiptNoticeSqlProvider.class, method = "insertSelective")
    int insertSelective(PurchasePoReceiptNotice record);


    /**
     * 查询收货通知单
     *
     * @param record
     * @return
     */
    @SelectProvider(type = PurchasePoReceiptNoticeSqlProvider.class, method = "selectByPoReceiptNotice")
    @Results({
            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<PurchasePoReceiptNotice> selectByPoReceiptNotice(PurchasePoReceiptNotice record);

    /**
     * 修改发货通知单
     *
     * @param record
     * @return
     */
    @UpdateProvider(type = PurchasePoReceiptNoticeSqlProvider.class, method = "updateByPoReceiptNotice")
    int updateByPoReceiptNotice(PurchasePoReceiptNotice record);


    @UpdateProvider(type = PurchasePoReceiptNoticeSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PurchasePoReceiptNotice record, @Param("example") PurchasePoReceiptNotice example);
}