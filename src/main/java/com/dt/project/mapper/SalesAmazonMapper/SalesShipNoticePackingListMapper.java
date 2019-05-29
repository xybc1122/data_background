package com.dt.project.mapper.salesAmazonMapper;

import com.dt.project.model.salesAmazon.SalesShipNoticePackingList;

import java.util.List;

import com.dt.project.provider.SalesShipNoticePackingListSqlProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

public interface SalesShipNoticePackingListMapper {
    @SelectProvider(type = SalesShipNoticePackingListSqlProvider.class, method = "countByExample")
    int countByExample(SalesShipNoticePackingList example);

    @DeleteProvider(type = SalesShipNoticePackingListSqlProvider.class, method = "deleteByExample")
    int deleteByExample(SalesShipNoticePackingList example);

    @Insert({
            "insert into sales_ship_notice_packing_list (packinglist_id, ship_notice_id, ",
            "no, date, ttl_qty, ",
            "ttl_packages, ttl_volume, ",
            "ttl_gw_kg, source_type_id, ",
            "source_id, remark, ",
            "status, create_date, ",
            "create_user, modify_date, ",
            "modify_user, audit_date, ",
            "audit_user, close_date, ",
            "close_user, version, ",
            "del_or_not)",
            "values (#{packinglistId,jdbcType=BIGINT}, #{shipNoticeId,jdbcType=BIGINT}, ",
            "#{no,jdbcType=VARCHAR}, #{date,jdbcType=BIGINT}, #{ttlQty,jdbcType=INTEGER}, ",
            "#{ttlPackages,jdbcType=INTEGER}, #{ttlVolume,jdbcType=DECIMAL}, ",
            "#{ttlGwKg,jdbcType=DECIMAL}, #{sourceTypeId,jdbcType=BIGINT}, ",
            "#{sourceId,jdbcType=BIGINT}, #{remark,jdbcType=VARCHAR}, ",
            "#{status,jdbcType=INTEGER}, #{createDate,jdbcType=BIGINT}, ",
            "#{createUser,jdbcType=BIGINT}, #{modifyDate,jdbcType=BIGINT}, ",
            "#{modifyUser,jdbcType=BIGINT}, #{auditDate,jdbcType=BIGINT}, ",
            "#{auditUser,jdbcType=BIGINT}, #{closeDate,jdbcType=BIGINT}, ",
            "#{closeUser,jdbcType=BIGINT}, #{version,jdbcType=INTEGER}, ",
            "#{delOrNot,jdbcType=BIT})"
    })
    int insert(SalesShipNoticePackingList record);

    @InsertProvider(type = SalesShipNoticePackingListSqlProvider.class, method = "insertSelective")
    int insertSelective(SalesShipNoticePackingList record);


    /**
     * 查询出货装箱单
     *
     * @param record
     * @return
     */
    @SelectProvider(type = SalesShipNoticePackingListSqlProvider.class, method = "selectNoticePackingList")
    List<SalesShipNoticePackingList> selectNoticePackingList(SalesShipNoticePackingList record);

    @UpdateProvider(type = SalesShipNoticePackingListSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SalesShipNoticePackingList record, @Param("example") SalesShipNoticePackingList example);

    @UpdateProvider(type = SalesShipNoticePackingListSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") SalesShipNoticePackingList record, @Param("example") SalesShipNoticePackingList example);
}