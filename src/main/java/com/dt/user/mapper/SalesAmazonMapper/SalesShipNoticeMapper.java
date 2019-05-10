package com.dt.user.mapper.SalesAmazonMapper;

import com.dt.user.provider.SalesShipNoticeSqlProvider;
import com.dt.user.model.SalesAmazon.SalesShipNotice;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface SalesShipNoticeMapper {
    @SelectProvider(type = SalesShipNoticeSqlProvider.class, method = "countByExample")
    int countByExample(SalesShipNotice example);

    @DeleteProvider(type = SalesShipNoticeSqlProvider.class, method = "deleteByExample")
    int deleteByExample(SalesShipNotice example);

    @Insert({
            "insert into sales_ship_notice (ship_notice_id, no, ",
            "date, platform_type_id, ",
            "delivery_date, arrive_date, ",
            "transport_type_id, shop_id, ",
            "site_id, fba_shipment_id, ",
            "aw_id, warehouse_id, ",
            "ttl_qty, ttl_packages, ",
            "ttl_volume, ttl_gw_kg, ",
            "source_type_id, source_id, ",
            "remark, status, ",
            "create_date, create_user, ",
            "modify_date, modify_user, ",
            "audit_date, audit_user, ",
            "close_date, close_user, ",
            "version, del_or_not)",
            "values (#{shipNoticeId,jdbcType=BIGINT}, #{no,jdbcType=VARCHAR}, ",
            "#{date,jdbcType=BIGINT}, #{platformTypeId,jdbcType=INTEGER}, ",
            "#{deliveryDate,jdbcType=BIGINT}, #{arriveDate,jdbcType=BIGINT}, ",
            "#{transportTypeId,jdbcType=INTEGER}, #{shopId,jdbcType=INTEGER}, ",
            "#{siteId,jdbcType=INTEGER}, #{fbaShipmentId,jdbcType=VARCHAR}, ",
            "#{awId,jdbcType=INTEGER}, #{warehouseId,jdbcType=BIGINT}, ",
            "#{ttlQty,jdbcType=INTEGER}, #{ttlPackages,jdbcType=INTEGER}, ",
            "#{ttlVolume,jdbcType=DECIMAL}, #{ttlGwKg,jdbcType=DECIMAL}, ",
            "#{sourceTypeId,jdbcType=BIGINT}, #{sourceId,jdbcType=BIGINT}, ",
            "#{remark,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
            "#{createDate,jdbcType=BIGINT}, #{createUser,jdbcType=VARCHAR}, ",
            "#{modifyDate,jdbcType=BIGINT}, #{modifyUser,jdbcType=BIGINT}, ",
            "#{auditDate,jdbcType=BIGINT}, #{auditUser,jdbcType=BIGINT}, ",
            "#{closeDate,jdbcType=BIGINT}, #{closeUser,jdbcType=BIGINT}, ",
            "#{version,jdbcType=INTEGER}, #{delOrNot,jdbcType=BIT})"
    })
    int insert(SalesShipNotice record);

    @InsertProvider(type = SalesShipNoticeSqlProvider.class, method = "insertSelective")
    int insertSelective(SalesShipNotice record);


    /**
     * 查询发货通知单
     *
     * @param example
     * @return
     */
    @SelectProvider(type = SalesShipNoticeSqlProvider.class, method = "selectByNotice")
    @Results(value = {
            @Result(property = "shipNoticeId", column = "ship_notice_id",
                    many = @Many(select = "com.dt.user.mapper.SalesAmazonMapper.selectByNoticeEntry"))
    })
    List<SalesShipNotice> selectByNotice(SalesShipNotice example);







    @UpdateProvider(type = SalesShipNoticeSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SalesShipNotice record);

    @UpdateProvider(type = SalesShipNoticeSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") SalesShipNotice record);
}