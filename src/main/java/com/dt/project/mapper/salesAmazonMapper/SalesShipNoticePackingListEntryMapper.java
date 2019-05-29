package com.dt.project.mapper.salesAmazonMapper;

import com.dt.project.model.salesAmazon.SalesShipNoticePackingListEntry;

import java.util.List;

import com.dt.project.provider.SalesShipNoticePackingListEntrySqlProvider;
import org.apache.ibatis.annotations.*;

public interface SalesShipNoticePackingListEntryMapper {
    @SelectProvider(type = SalesShipNoticePackingListEntrySqlProvider.class, method = "countByExample")
    int countByExample(SalesShipNoticePackingListEntry example);

    @DeleteProvider(type = SalesShipNoticePackingListEntrySqlProvider.class, method = "deleteByExample")
    int deleteByExample(SalesShipNoticePackingListEntry example);

    @Insert({
            "insert into sales_ship_notice_packinglist_entry (pe_id, packinglist_id, ",
            "e_id, entry_id, quantity, ",
            "packages_beg, packages_end, ",
            "length_cm, width_cm, ",
            "height_cm, gw_kg, ",
            "nw_kg, volume_m3, ",
            "remark, version, ",
            "del_or_not)",
            "values (#{peId,jdbcType=BIGINT}, #{packinglistId,jdbcType=BIGINT}, ",
            "#{eId,jdbcType=BIGINT}, #{entryId,jdbcType=INTEGER}, #{quantity,jdbcType=INTEGER}, ",
            "#{packagesBeg,jdbcType=INTEGER}, #{packagesEnd,jdbcType=INTEGER}, ",
            "#{lengthCm,jdbcType=DECIMAL}, #{widthCm,jdbcType=DECIMAL}, ",
            "#{heightCm,jdbcType=DECIMAL}, #{gwKg,jdbcType=DECIMAL}, ",
            "#{nwKg,jdbcType=DECIMAL}, #{volumeM3,jdbcType=DECIMAL}, ",
            "#{remark,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
            "#{delOrNot,jdbcType=BIT})"
    })
    int insert(SalesShipNoticePackingListEntry record);

    @InsertProvider(type = SalesShipNoticePackingListEntrySqlProvider.class, method = "insertSelective")
    int insertSelective(SalesShipNoticePackingListEntry record);

    /**
     * 查询 装箱单-表体  用于一对多
     *
     * @param
     * @return
     */
    @SelectProvider(type = SalesShipNoticePackingListEntrySqlProvider.class, method = "selectPackingListEntry")
    @Results({
            @Result(property = "plLengthCm", column = "length_cm"),
            @Result(property = "plWidthCm", column = "width_cm"),
            @Result(property = "plHeightCm", column = "height_cm"),
            @Result(property = "plGwKg", column = "gw_kg"),
            @Result(property = "plNwKg", column = "nw_kg"),
            @Result(property = "plVolumeM3", column = "volume_m3"),
            @Result(property = "plRemark", column = "remark")
    })
    List<SalesShipNoticePackingListEntry> selectPackingListEntry(SalesShipNoticePackingListEntry pLEntry);


    @UpdateProvider(type = SalesShipNoticePackingListEntrySqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SalesShipNoticePackingListEntry record);

    @UpdateProvider(type = SalesShipNoticePackingListEntrySqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") SalesShipNoticePackingListEntry record);
}