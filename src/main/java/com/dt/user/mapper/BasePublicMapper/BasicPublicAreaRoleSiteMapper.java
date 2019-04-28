package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.provider.BasicPublicAreaRoleSiteSqlProvider;
import com.dt.user.model.BasePublicModel.BasicPublicAreaRoleSite;

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

public interface BasicPublicAreaRoleSiteMapper {
    @SelectProvider(type = BasicPublicAreaRoleSiteSqlProvider.class, method = "countByExample")
    int countByExample(BasicPublicAreaRoleSite example);

    @DeleteProvider(type = BasicPublicAreaRoleSiteSqlProvider.class, method = "deleteByExample")
    int deleteByExample(BasicPublicAreaRoleSite example);

    /**
     * 添加 区域 角色配置表id 跟站点id
     *
     * @param record
     * @return
     */
    @Insert({
            "insert into basic_public_area_role_site (ar_id, ",
            "se_id, create_date, ",
            "create_user)",
            "values (#{arId,jdbcType=INTEGER}, ",
            "#{seId,jdbcType=INTEGER}, #{createDate,jdbcType=BIGINT}, ",
            "#{createUser,jdbcType=VARCHAR})"
    })
    int insertARSInfo(BasicPublicAreaRoleSite record);

    @InsertProvider(type = BasicPublicAreaRoleSiteSqlProvider.class, method = "insertSelective")
    int insertSelective(BasicPublicAreaRoleSite record);

    @SelectProvider(type = BasicPublicAreaRoleSiteSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "ars_id", property = "arsId", jdbcType = JdbcType.INTEGER),
            @Result(column = "ar_id", property = "arId", jdbcType = JdbcType.INTEGER),
            @Result(column = "se_id", property = "seId", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_date", property = "createDate", jdbcType = JdbcType.BIGINT),
            @Result(column = "create_user", property = "createUser", jdbcType = JdbcType.VARCHAR)
    })
    List<BasicPublicAreaRoleSite> selectByExample(BasicPublicAreaRoleSite example);

    @UpdateProvider(type = BasicPublicAreaRoleSiteSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BasicPublicAreaRoleSite record);

    @UpdateProvider(type = BasicPublicAreaRoleSiteSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") BasicPublicAreaRoleSite record);
}