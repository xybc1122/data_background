package com.dt.project.mapper.basePublicMapper;

import com.dt.project.dto.AreaRoleDto;
import com.dt.project.provider.BasicPublicAreaRoleSqlProvider;
import com.dt.project.model.basePublicModel.BasicPublicAreaRole;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface BasicPublicAreaRoleMapper {

    /**
     * 通过角色id 跟 区域id 查找  arid  用于删除 下面关联的站点
     *
     * @param aid
     * @param rid
     * @return
     */
    @Select("SELECT `ar_id`FROM `basic_public_area_role` WHERE r_id =#{rid} AND a_id =#{aid}")
    Integer selectArId(@Param("aid") Integer aid, @Param("rid") Integer rid);

    /**
     * 通过aid 跟角色id 删除区域关联表信息
     *
     * @return
     */
    @Delete("DELETE FROM `basic_public_area_role` WHERE a_id =#{aid} AND r_id=#{rid}")
    int deleteByARole(@Param("aid") Integer aid, @Param("rid") Integer rid);

    /**
     * 存入配置 角色 区域数据
     *
     * @param record
     * @return
     */
    @Insert({
            "insert into basic_public_area_role (a_id, ",
            "r_id, create_user, ",
            "create_date)",
            "values ( #{aid,jdbcType=INTEGER},#{rid,jdbcType=INTEGER}, #{createUser,jdbcType=VARCHAR}," +
                    "#{createDate,jdbcType=BINARY})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "arId", keyColumn = "ar_id")
    int insertARole(AreaRoleDto record);


    @InsertProvider(type = BasicPublicAreaRoleSqlProvider.class, method = "insertSelective")
    int insertSelective(BasicPublicAreaRole record);

    @SelectProvider(type = BasicPublicAreaRoleSqlProvider.class, method = "selectByExampleWithBLOBs")
    @Results({
            @Result(column = "ar_id", property = "arId", jdbcType = JdbcType.INTEGER),
            @Result(column = "a_id", property = "aId", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_id", property = "rId", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_user", property = "createUser", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_date", property = "createDate", jdbcType = JdbcType.BINARY)
    })
    List<BasicPublicAreaRole> selectByExampleWithBLOBs(BasicPublicAreaRole example);

    @SelectProvider(type = BasicPublicAreaRoleSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "ar_id", property = "arId", jdbcType = JdbcType.INTEGER),
            @Result(column = "a_id", property = "aId", jdbcType = JdbcType.INTEGER),
            @Result(column = "r_id", property = "rId", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_user", property = "createUser", jdbcType = JdbcType.VARCHAR)
    })
    List<BasicPublicAreaRole> selectByExample(BasicPublicAreaRole example);

    @UpdateProvider(type = BasicPublicAreaRoleSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BasicPublicAreaRole record);

    @UpdateProvider(type = BasicPublicAreaRoleSqlProvider.class, method = "updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") BasicPublicAreaRole record);

    @UpdateProvider(type = BasicPublicAreaRoleSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") BasicPublicAreaRole record);
}