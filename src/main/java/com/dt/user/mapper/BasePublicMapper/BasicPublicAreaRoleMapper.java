package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.dto.AreaRoleDto;
import com.dt.user.provider.BasicPublicAreaRoleSqlProvider;
import com.dt.user.model.BasePublicModel.BasicPublicAreaRole;

import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface BasicPublicAreaRoleMapper {


    @SelectProvider(type = BasicPublicAreaRoleSqlProvider.class, method = "countByExample")
    int countByExample(BasicPublicAreaRole example);

    /**
     * 删除接口
     *
     * @param record
     * @return
     */
    @DeleteProvider(type = BasicPublicAreaRoleSqlProvider.class, method = "deleteByAreaRole")
    int deleteByARole(AreaRoleDto record);

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