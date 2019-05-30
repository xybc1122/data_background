package com.dt.project.mapper.purchaseMapper;

import com.dt.project.provider.PurchasePoReceiptNoticeEntrySqlProvider;
import com.dt.project.model.purchasePo.PurchasePoReceiptNoticeEntry;

import java.util.List;

import org.apache.ibatis.annotations.*;

public interface PurchasePoReceiptNoticeEntryMapper {
    @SelectProvider(type = PurchasePoReceiptNoticeEntrySqlProvider.class, method = "countByExample")
    int countByExample(PurchasePoReceiptNoticeEntry example);

    @DeleteProvider(type = PurchasePoReceiptNoticeEntrySqlProvider.class, method = "deleteByExample")
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

    @InsertProvider(type = PurchasePoReceiptNoticeEntrySqlProvider.class, method = "insertSelective")
    int insertSelective(PurchasePoReceiptNoticeEntry record);

    /**
     * 收货通知单一对多查询
     *
     * @param record
     * @return
     */
    @SelectProvider(type = PurchasePoReceiptNoticeEntrySqlProvider.class, method = "selectByPRNoticeEntry")
    @Results({
            @Result(property = "rneRemark", column = "e_remark")
    })
    List<PurchasePoReceiptNoticeEntry> selectByPRNoticeEntry(PurchasePoReceiptNoticeEntry record);


    @UpdateProvider(type = PurchasePoReceiptNoticeEntrySqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PurchasePoReceiptNoticeEntry record, @Param("example") PurchasePoReceiptNoticeEntry example);

    @UpdateProvider(type = PurchasePoReceiptNoticeEntrySqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") PurchasePoReceiptNoticeEntry record, @Param("example") PurchasePoReceiptNoticeEntry example);
}