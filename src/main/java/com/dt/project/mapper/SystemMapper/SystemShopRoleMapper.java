package com.dt.project.mapper.SystemMapper;

import com.dt.project.model.System.SystemShopRole;

import java.util.List;

import com.dt.project.provider.SystemShopRoleSqlProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

public interface SystemShopRoleMapper {
    @SelectProvider(type = SystemShopRoleSqlProvider.class, method = "countByExample")
    int countByExample(SystemShopRole example);


    /**
     * 删除一个角色下的所有关联信息
     *
     * @return
     */
//    @Delete("DELETE FROM `system_shop_role`\n" +
//            "WHERE `r_id` = #{rid} AND s_id IN (#{delSid});")
    @DeleteProvider(type = SystemShopRoleSqlProvider.class, method = "delSr")
    int deleteByShopRole(@Param("rid") Integer rid, @Param("delSid") String delSid);

    /**
     * 添加店铺角色数据
     *
     * @param shopRole
     * @return
     */
    @Insert({
            "insert into system_shop_role (`s_id`, `r_id`,`create_date`,`create_user`)",
            "values (#{sid,jdbcType=TINYINT}, #{rid,jdbcType=INTEGER},#{createDate},#{createUser})"
    })
    int insertShopRole(SystemShopRole shopRole);



    @InsertProvider(type = SystemShopRoleSqlProvider.class, method = "insertSelective")
    int insertSelective(SystemShopRole record);

    @SelectProvider(type = SystemShopRoleSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "s_id", property = "sId", jdbcType = JdbcType.TINYINT),
            @Result(column = "r_id", property = "rId", jdbcType = JdbcType.INTEGER),
            @Result(column = "rs_id", property = "rsId", jdbcType = JdbcType.INTEGER)
    })
    List<SystemShopRole> selectByExample(SystemShopRole example);

    @UpdateProvider(type = SystemShopRoleSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemShopRole record, @Param("example") SystemShopRole example);

    @UpdateProvider(type = SystemShopRoleSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") SystemShopRole record, @Param("example") SystemShopRole example);
}