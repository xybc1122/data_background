package com.dt.project.mapper.purchaseMapper;

import com.dt.project.provider.PurchasePoReceiptNoticeSqlProvider;
import com.dt.project.model.purchasePo.PurchasePoReceiptNotice;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PurchasePoReceiptNoticeMapper {
    @SelectProvider(type= PurchasePoReceiptNoticeSqlProvider.class, method="countByExample")
    int countByExample(PurchasePoReceiptNotice example);

    @DeleteProvider(type=PurchasePoReceiptNoticeSqlProvider.class, method="deleteByExample")
    int deleteByExample(PurchasePoReceiptNotice example);

    @Insert({
        "insert into purchase_po_receipt_notice (rn_id, date, ",
        "rn_no, explanation, ",
        "fetch_add, dept_id, ",
        "emp_id, manger_id, ",
        "children, closed, order_confirm, ",
        "source_type_id, source_id, ",
        "print_count, status_id, ",
        "version, del_or_not)",
        "values (#{rnId,jdbcType=BIGINT}, #{date,jdbcType=BIGINT}, ",
        "#{rnNo,jdbcType=VARCHAR}, #{explanation,jdbcType=VARCHAR}, ",
        "#{fetchAdd,jdbcType=VARCHAR}, #{deptId,jdbcType=INTEGER}, ",
        "#{empId,jdbcType=INTEGER}, #{mangerId,jdbcType=INTEGER}, ",
        "#{children,jdbcType=BIT}, #{closed,jdbcType=INTEGER}, #{orderConfirm,jdbcType=INTEGER}, ",
        "#{sourceTypeId,jdbcType=BIGINT}, #{sourceId,jdbcType=BIGINT}, ",
        "#{printCount,jdbcType=INTEGER}, #{statusId,jdbcType=BIGINT}, ",
        "#{version,jdbcType=INTEGER}, #{delOrNot,jdbcType=BIT})"
    })
    int insert(PurchasePoReceiptNotice record);

    @InsertProvider(type=PurchasePoReceiptNoticeSqlProvider.class, method="insertSelective")
    int insertSelective(PurchasePoReceiptNotice record);

    @SelectProvider(type=PurchasePoReceiptNoticeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="rn_id", property="rnId", jdbcType=JdbcType.BIGINT),
        @Result(column="date", property="date", jdbcType=JdbcType.BIGINT),
        @Result(column="rn_no", property="rnNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="explanation", property="explanation", jdbcType=JdbcType.VARCHAR),
        @Result(column="fetch_add", property="fetchAdd", jdbcType=JdbcType.VARCHAR),
        @Result(column="dept_id", property="deptId", jdbcType=JdbcType.INTEGER),
        @Result(column="emp_id", property="empId", jdbcType=JdbcType.INTEGER),
        @Result(column="manger_id", property="mangerId", jdbcType=JdbcType.INTEGER),
        @Result(column="children", property="children", jdbcType=JdbcType.BIT),
        @Result(column="closed", property="closed", jdbcType=JdbcType.INTEGER),
        @Result(column="order_confirm", property="orderConfirm", jdbcType=JdbcType.INTEGER),
        @Result(column="source_type_id", property="sourceTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="source_id", property="sourceId", jdbcType=JdbcType.BIGINT),
        @Result(column="print_count", property="printCount", jdbcType=JdbcType.INTEGER),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="del_or_not", property="delOrNot", jdbcType=JdbcType.BIT)
    })
    List<PurchasePoReceiptNotice> selectByExample(PurchasePoReceiptNotice example);

    @UpdateProvider(type=PurchasePoReceiptNoticeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PurchasePoReceiptNotice record, @Param("example") PurchasePoReceiptNotice example);

    @UpdateProvider(type=PurchasePoReceiptNoticeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PurchasePoReceiptNotice record, @Param("example") PurchasePoReceiptNotice example);
}