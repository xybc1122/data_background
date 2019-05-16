package com.dt.project.mapper.SystemMapper;

import com.dt.project.provider.SystemFinalProcessingSqlProvider;
import com.dt.project.model.System.SystemFinalProcessing;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface SystemFinalProcessingMapper {


    /**
     * 查询关账时间
     *
     * @return
     */
    @Select(" SELECT  CONCAT_WS('-',checkout_years,checkout_period) FROM system_final_processing WHERE menu_id =#{menuId}")
    String selectByDateCheckout(@Param("menuId") Integer menuId);

    /**
     * 查询总数
     *
     * @param example
     * @return
     */
    @SelectProvider(type = SystemFinalProcessingSqlProvider.class, method = "countByExample")
    int countByExample(SystemFinalProcessing example);

    /**
     * 删除
     *
     * @param example
     * @return
     */
    @DeleteProvider(type = SystemFinalProcessingSqlProvider.class, method = "deleteByExample")
    int deleteByExample(SystemFinalProcessing example);

    @Insert({
            "insert into system_final_processing (final_processing_id, menu_id, ",
            "close_years, close_period, ",
            "checkout_years, checkout_period, ",
            "remark, status, ",
            "create_date, create_id_user, ",
            "modify_date, modify_id_user, ",
            "recording_id, version, ",
            "del_or_not)",
            "values (#{finalProcessingId,jdbcType=BIGINT}, #{menuId,jdbcType=BIGINT}, ",
            "#{closeYears,jdbcType=INTEGER}, #{closePeriod,jdbcType=INTEGER}, ",
            "#{checkoutYears,jdbcType=INTEGER}, #{checkoutPeriod,jdbcType=BIGINT}, ",
            "#{remark,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
            "#{createDate,jdbcType=BIGINT}, #{createIdUser,jdbcType=BIGINT}, ",
            "#{modifyDate,jdbcType=INTEGER}, #{modifyIdUser,jdbcType=INTEGER}, ",
            "#{recordingId,jdbcType=BIGINT}, #{version,jdbcType=INTEGER}, ",
            "#{delOrNot,jdbcType=BIT})"
    })
    int insert(SystemFinalProcessing record);

    @InsertProvider(type = SystemFinalProcessingSqlProvider.class, method = "insertSelective")
    int insertSelective(SystemFinalProcessing record);

    @SelectProvider(type = SystemFinalProcessingSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "final_processing_id", property = "finalProcessingId", jdbcType = JdbcType.BIGINT),
            @Result(column = "menu_id", property = "menuId", jdbcType = JdbcType.BIGINT),
            @Result(column = "close_years", property = "closeYears", jdbcType = JdbcType.INTEGER),
            @Result(column = "close_period", property = "closePeriod", jdbcType = JdbcType.INTEGER),
            @Result(column = "checkout_years", property = "checkoutYears", jdbcType = JdbcType.INTEGER),
            @Result(column = "checkout_period", property = "checkoutPeriod", jdbcType = JdbcType.BIGINT),
            @Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "status", property = "status", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_date", property = "createDate", jdbcType = JdbcType.BIGINT),
            @Result(column = "create_id_user", property = "createIdUser", jdbcType = JdbcType.BIGINT),
            @Result(column = "modify_date", property = "modifyDate", jdbcType = JdbcType.INTEGER),
            @Result(column = "modify_id_user", property = "modifyIdUser", jdbcType = JdbcType.INTEGER),
            @Result(column = "recording_id", property = "recordingId", jdbcType = JdbcType.BIGINT),
            @Result(column = "version", property = "version", jdbcType = JdbcType.INTEGER),
            @Result(column = "del_or_not", property = "delOrNot", jdbcType = JdbcType.BIT)
    })
    List<SystemFinalProcessing> selectByExample(SystemFinalProcessing example);

    @UpdateProvider(type = SystemFinalProcessingSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemFinalProcessing record, @Param("example") SystemFinalProcessing example);

    @UpdateProvider(type = SystemFinalProcessingSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") SystemFinalProcessing record, @Param("example") SystemFinalProcessing example);
}