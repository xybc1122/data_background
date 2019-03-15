package com.dt.user.mapper;

import com.dt.user.dto.UserDto;
import com.dt.user.model.Role;
import com.dt.user.model.UserInfo;
import com.dt.user.provider.RoleProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Set;

@Mapper
public interface RoleMapper {
    //查询角色表的role_sign  角色类型
    @Select("select rid, role_sign from system_user_role where rid in(select r_id from system_user_role_user where u_id=#{uid})")
    Set<String> getAllRolesByUid(@Param("uid") Long uid);

    /**
     * 查询所有的角色
     *
     * @return
     */
    @Select("SELECT `rid`,`r_name`,`role_sign`FROM `system_user_role`")
    List<Role> getRoleList();


    /**
     * 查询一个角色下的所有用户跟 菜单
     *
     * @param
     * @return
     */
    @SelectProvider(type = RoleProvider.class, method = "findByRoleInfo")
    List<UserInfo> findByRoleInfo(UserDto pageDto);


    /**
     * 通过角色名字去查询数据库是否有重复
     */
    @Select("select r_name from system_user_role where r_name=#{rName}")
    String findByRoleName(@Param("rName") String rName);
}
