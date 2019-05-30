package com.dt.project.mapper.salesAmazonMapper;

import com.dt.project.provider.SalesShipNoticeSqlProvider;
import com.dt.project.model.salesAmazon.SalesShipNotice;

import java.util.List;

import org.apache.ibatis.annotations.*;

public interface SalesShipNoticeMapper {

    /**
     * 查询是否有重复的
     *
     * @return
     */
    @Select("SELECT `ship_notice_id` FROM `sales_ship_notice` WHERE `date`=#{date} " +
            "AND platform_type_id=#{platformTypeId} AND shop_id=#{shopId} AND site_id=#{siteId} LIMIT 1")
    Long isItRedundant(SalesShipNotice shipNotice);

    @SelectProvider(type = SalesShipNoticeSqlProvider.class, method = "countByExample")
    long countByExample(SalesShipNotice example);


    /**
     * 存入出货通知单表
     *
     * @param record
     * @return
     */
    @Insert({
            "insert into sales_ship_notice (no,",
            "date, platform_type_id, ",
            "delivery_date, arrive_date, ",
            "transport_type_id, shop_id, ",
            "site_id, fba_shipment_id, ",
            "aw_id, warehouse_id, ",
            "ttl_qty, ttl_packages, ",
            "ttl_volume, ttl_gw_kg, ",
            "source_type_id, source_id, ",
            "remark, status,",
            "create_date, create_user, ",
            "modify_date, modify_user, ",
            "audit_date, audit_user, ",
            "close_date, close_user)",
            "values(#{no,jdbcType=VARCHAR},",
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
            "#{closeDate,jdbcType=BIGINT}, #{closeUser,jdbcType=BIGINT})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "shipNoticeId", keyColumn = "ship_notice_id")
    int insertShipNotice(SalesShipNotice record);

    @InsertProvider(type = SalesShipNoticeSqlProvider.class, method = "insertSelective")
    int insertSelective(SalesShipNotice record);


    /**
     * 查询发货通知单
     *
     * @param record
     * @return
     */
    @SelectProvider(type = SalesShipNoticeSqlProvider.class, method = "selectByNotice")
    List<SalesShipNotice> selectByNotice(SalesShipNotice record);


    /**
     * 更新出货通知单外单
     *
     * @param record
     * @return
     */
    @UpdateProvider(type = SalesShipNoticeSqlProvider.class, method = "updateBySalesShipNotice")
    int updateBySalesShipNotice(SalesShipNotice record);

    @UpdateProvider(type = SalesShipNoticeSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") SalesShipNotice record);
}