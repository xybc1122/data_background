package com.dt.project.mapper;

import com.dt.project.model.salesAmazon.SalesShipNoticePackingList;
import java.util.List;

import com.dt.project.provider.SalesShipNoticePackingListSqlProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SalesShipNoticePackingListMapper {
    @SelectProvider(type= SalesShipNoticePackingListSqlProvider.class, method="countByExample")
    int countByExample(SalesShipNoticePackingList example);

    @DeleteProvider(type=SalesShipNoticePackingListSqlProvider.class, method="deleteByExample")
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

    @InsertProvider(type=SalesShipNoticePackingListSqlProvider.class, method="insertSelective")
    int insertSelective(SalesShipNoticePackingList record);

    @SelectProvider(type=SalesShipNoticePackingListSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="packinglist_id", property="packinglistId", jdbcType=JdbcType.BIGINT),
        @Result(column="ship_notice_id", property="shipNoticeId", jdbcType=JdbcType.BIGINT),
        @Result(column="no", property="no", jdbcType=JdbcType.VARCHAR),
        @Result(column="date", property="date", jdbcType=JdbcType.BIGINT),
        @Result(column="ttl_qty", property="ttlQty", jdbcType=JdbcType.INTEGER),
        @Result(column="ttl_packages", property="ttlPackages", jdbcType=JdbcType.INTEGER),
        @Result(column="ttl_volume", property="ttlVolume", jdbcType=JdbcType.DECIMAL),
        @Result(column="ttl_gw_kg", property="ttlGwKg", jdbcType=JdbcType.DECIMAL),
        @Result(column="source_type_id", property="sourceTypeId", jdbcType=JdbcType.BIGINT),
        @Result(column="source_id", property="sourceId", jdbcType=JdbcType.BIGINT),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.BIGINT),
        @Result(column="create_user", property="createUser", jdbcType=JdbcType.BIGINT),
        @Result(column="modify_date", property="modifyDate", jdbcType=JdbcType.BIGINT),
        @Result(column="modify_user", property="modifyUser", jdbcType=JdbcType.BIGINT),
        @Result(column="audit_date", property="auditDate", jdbcType=JdbcType.BIGINT),
        @Result(column="audit_user", property="auditUser", jdbcType=JdbcType.BIGINT),
        @Result(column="close_date", property="closeDate", jdbcType=JdbcType.BIGINT),
        @Result(column="close_user", property="closeUser", jdbcType=JdbcType.BIGINT),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="del_or_not", property="delOrNot", jdbcType=JdbcType.BIT)
    })
    List<SalesShipNoticePackingList> selectByExample(SalesShipNoticePackingList example);

    @UpdateProvider(type=SalesShipNoticePackingListSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SalesShipNoticePackingList record, @Param("example") SalesShipNoticePackingList example);

    @UpdateProvider(type=SalesShipNoticePackingListSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SalesShipNoticePackingList record, @Param("example") SalesShipNoticePackingList example);
}