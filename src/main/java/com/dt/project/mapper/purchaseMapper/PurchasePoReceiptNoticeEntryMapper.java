package com.dt.project.mapper.purchaseMapper;

import com.dt.project.provider.PurchasePoReceiptNoticeEntrySqlProvider;
import com.dt.project.model.purchasePo.PurchasePoReceiptNoticeEntry;
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

public interface PurchasePoReceiptNoticeEntryMapper {
    @SelectProvider(type= PurchasePoReceiptNoticeEntrySqlProvider.class, method="countByExample")
    int countByExample(PurchasePoReceiptNoticeEntry example);

    @DeleteProvider(type=PurchasePoReceiptNoticeEntrySqlProvider.class, method="deleteByExample")
    int deleteByExample(PurchasePoReceiptNoticeEntry example);

    @Insert({
        "insert into purchase_po_receipt_notice_entry (rne_id, entry_id, ",
        "rn_id, product_id, ",
        "source_type_id, source_id, ",
        "poe_id, delivery_date, ",
        "recive_warehouse_id, recive_position_id, ",
        "quantity, transport_company_id, ",
        "TrackingNumber, rne_remark, ",
        "row_closed, status_id, ",
        "version, del_or_not)",
        "values (#{rneId,jdbcType=BIGINT}, #{entryId,jdbcType=INTEGER}, ",
        "#{rnId,jdbcType=BIGINT}, #{productId,jdbcType=INTEGER}, ",
        "#{sourceTypeId,jdbcType=BIGINT}, #{sourceId,jdbcType=VARCHAR}, ",
        "#{poeId,jdbcType=BIGINT}, #{deliveryDate,jdbcType=BIGINT}, ",
        "#{reciveWarehouseId,jdbcType=BIGINT}, #{recivePositionId,jdbcType=BIGINT}, ",
        "#{quantity,jdbcType=DECIMAL}, #{transportCompanyId,jdbcType=BIGINT}, ",
        "#{trackingnumber,jdbcType=VARCHAR}, #{rneRemark,jdbcType=VARCHAR}, ",
        "#{rowClosed,jdbcType=INTEGER}, #{statusId,jdbcType=BIGINT}, ",
        "#{version,jdbcType=INTEGER}, #{delOrNot,jdbcType=BIT})"
    })
    int insert(PurchasePoReceiptNoticeEntry record);

    @InsertProvider(type=PurchasePoReceiptNoticeEntrySqlProvider.class, method="insertSelective")
    int insertSelective(PurchasePoReceiptNoticeEntry record);

    @SelectProvider(type=PurchasePoReceiptNoticeEntrySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="rne_id", property="rneId", jdbcType=JdbcType.BIGINT),
        @Result(column="entry_id", property="entryId", jdbcType=JdbcType.INTEGER),
        @Result(column="rn_id", property="rnId", jdbcType=JdbcType.BIGINT),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="source_type_id", property="sourceTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="source_id", property="sourceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="poe_id", property="poeId", jdbcType=JdbcType.BIGINT),
        @Result(column="delivery_date", property="deliveryDate", jdbcType=JdbcType.BIGINT),
        @Result(column="recive_warehouse_id", property="reciveWarehouseId", jdbcType=JdbcType.BIGINT),
        @Result(column="recive_position_id", property="recivePositionId", jdbcType=JdbcType.BIGINT),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.DECIMAL),
        @Result(column="transport_company_id", property="transportCompanyId", jdbcType=JdbcType.BIGINT),
        @Result(column="TrackingNumber", property="trackingnumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="rne_remark", property="rneRemark", jdbcType=JdbcType.VARCHAR),
        @Result(column="row_closed", property="rowClosed", jdbcType=JdbcType.INTEGER),
        @Result(column="status_id", property="statusId", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="del_or_not", property="delOrNot", jdbcType=JdbcType.BIT)
    })
    List<PurchasePoReceiptNoticeEntry> selectByExample(PurchasePoReceiptNoticeEntry example);

    @UpdateProvider(type=PurchasePoReceiptNoticeEntrySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PurchasePoReceiptNoticeEntry record, @Param("example") PurchasePoReceiptNoticeEntry example);

    @UpdateProvider(type=PurchasePoReceiptNoticeEntrySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PurchasePoReceiptNoticeEntry record, @Param("example") PurchasePoReceiptNoticeEntry example);
}