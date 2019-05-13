package com.dt.user.mapper.SalesAmazonMapper;

import com.dt.user.model.SalesAmazon.SalesShipNoticeEntry;

import java.util.List;

import com.dt.user.provider.SalesShipNoticeEntrySqlProvider;
import org.apache.ibatis.annotations.*;

public interface SalesShipNoticeEntryMapper {
    @SelectProvider(type = SalesShipNoticeEntrySqlProvider.class, method = "countByExample")
    int countByExample(SalesShipNoticeEntry example);

    @DeleteProvider(type = SalesShipNoticeEntrySqlProvider.class, method = "deleteByExample")
    int deleteByExample(SalesShipNoticeEntry example);

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

    @InsertProvider(type = SalesShipNoticeEntrySqlProvider.class, method = "insertSelective")
    int insertSelective(SalesShipNoticeEntry record);


    /**
     * 查询发货通知表体    用于一对多查询
     *
     * @return
     */
//    @Select("SELECT\n" +
//            "`e_id` AS eid ,`e_id`,`entry_id`, `ship_notice_id`,`sku_id`,\n" +
//            "`quantity`,`packages`,`length_cm`,\n" +
//            "`width_cm`,`height_cm`,`gw_kg`,\n" +
//            "`nw_kg`,`volume_m3`,`packing_status`,`se_quantity`,\n" +
//            "`re_quantity`,`re_date`,`remark`,\n" +
//            "`status`, `close_date`,`close_user`,`version`\n" +
//            "FROM `sales_ship_notice_entry` where ship_notice_id =#{shipNoticeId}")
    @SelectProvider(type = SalesShipNoticeEntrySqlProvider.class, method = "selectByNoticeEntry")
//    @Results(value = {
//            @Result(property = "pEList", column = "eid",
//                    many = @Many(select = "com.dt.user.mapper.SalesAmazonMapper.SalesShipNoticePackingListEntryMapper.selectPackingListEntry",
//                            fetchType = FetchType.LAZY))
//    })
    List<SalesShipNoticeEntry> selectByNoticeEntry(SalesShipNoticeEntry shipNoticeEntry);


    @UpdateProvider(type = SalesShipNoticeEntrySqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SalesShipNoticeEntry record);

    @UpdateProvider(type = SalesShipNoticeEntrySqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") SalesShipNoticeEntry record);
}