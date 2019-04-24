package com.dt.user.mapper.SystemMapper;

import com.dt.user.model.System.SystemShopRole;

import java.util.List;

import com.dt.user.provider.SystemShopRoleSqlProvider;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SystemShopRoleMapper {
    @SelectProvider(type = SystemShopRoleSqlProvider.class, method = "countByExample")
    int countByExample(SystemShopRole example);

    @DeleteProvider(type = SystemShopRoleSqlProvider.class, method = "deleteByExample")
    int deleteByExample(SystemShopRole example);

    /**
     * 添加店铺角色数据
     *
     * @param shopRole
     * @return
     */
    @Insert({
            "insert into system_shop_role (`s_id`, `r_id`,`create_date`,`create_user`)",
            "values (#{sId,jdbcType=TINYINT}, #{rId,jdbcType=INTEGER},#{createDate},#{createUser})"
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