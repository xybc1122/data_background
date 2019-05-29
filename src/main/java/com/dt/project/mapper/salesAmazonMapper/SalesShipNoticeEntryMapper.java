package com.dt.project.mapper.salesAmazonMapper;

import com.dt.project.model.salesAmazon.SalesShipNoticeEntry;

import java.util.List;

import com.dt.project.provider.SalesShipNoticeEntrySqlProvider;
import org.apache.ibatis.annotations.*;

public interface SalesShipNoticeEntryMapper {
    /**
     * 用父ID查询子ID下面是否还有节点
     *
     * @return
     */
    @SelectProvider(type = SalesShipNoticeEntrySqlProvider.class, method = "selIsNull")
    List<Integer> selIsNull(@Param("snIds") List snIds);


    @Insert({
            "insert into sales_ship_notice_entry (e_id, entry_id, ",
            "ship_notice_id, sku_id, ",
            "quantity, packages, ",
            "length_cm, width_cm, ",
            "height_cm, gw_kg, nw_kg, ",
            "volume_m3, packing_status, ",
            "se_quantity, re_quantity, ",
            "re_date, remark, status, ",
            "close_date, close_user, ",
            "version, del_or_not)",
            "values (#{eId,jdbcType=BIGINT}, #{entryId,jdbcType=INTEGER}, ",
            "#{shipNoticeId,jdbcType=BIGINT}, #{skuId,jdbcType=BIGINT}, ",
            "#{quantity,jdbcType=INTEGER}, #{packages,jdbcType=VARCHAR}, ",
            "#{lengthCm,jdbcType=DECIMAL}, #{widthCm,jdbcType=DOUBLE}, ",
            "#{heightCm,jdbcType=DOUBLE}, #{gwKg,jdbcType=DOUBLE}, #{nwKg,jdbcType=DOUBLE}, ",
            "#{volumeM3,jdbcType=DOUBLE}, #{packingStatus,jdbcType=BIT}, ",
            "#{seQuantity,jdbcType=INTEGER}, #{reQuantity,jdbcType=INTEGER}, ",
            "#{reDate,jdbcType=BIGINT}, #{remark,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
            "#{closeDate,jdbcType=BIGINT}, #{closeUser,jdbcType=VARCHAR}, ",
            "#{version,jdbcType=INTEGER}, #{delOrNot,jdbcType=BIT})"
    })
    int insert(SalesShipNoticeEntry record);


    /**
     * 批量插入出库通知单子表数据
     *
     * @param noticeEntryList
     * @return
     */
    @InsertProvider(type = SalesShipNoticeEntrySqlProvider.class, method = "insertShipNoticeEntry")
    int insertShipNoticeEntry(@Param("noticeEntryList") List<SalesShipNoticeEntry> noticeEntryList);


    /**
     * 查询发货通知表体    用于一对多查询
     *
     * @return
     */
    @SelectProvider(type = SalesShipNoticeEntrySqlProvider.class, method = "selectByNoticeEntry")
    @Results({
            @Result(property = "neLengthCm", column = "length_cm"),
            @Result(property = "neWidthCm", column = "width_cm"),
            @Result(property = "neHeightCm", column = "height_cm"),
            @Result(property = "neGwKg", column = "gw_kg"),
            @Result(property = "neNwKg", column = "nw_kg"),
            @Result(property = "neVolumeM3", column = "volume_m3"),
            @Result(property = "neRemark", column = "remark")
    })
    List<SalesShipNoticeEntry> selectByNoticeEntry(SalesShipNoticeEntry shipNoticeEntry);

    @UpdateProvider(type = SalesShipNoticeEntrySqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SalesShipNoticeEntry record);

    @UpdateProvider(type = SalesShipNoticeEntrySqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") SalesShipNoticeEntry record);
}