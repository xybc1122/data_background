package com.dt.project.mapper;

import com.dt.project.model.RoleMenu;
import com.dt.project.provider.RoleMenuProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMenuMapper {


    /**
     * 通过角色id来查询拥有的菜单
     **/
    @Select("select m_id from system_user_role_menu where r_id=#{rid}")
    List<String> gerRoleMenus(@Param("rid") Integer rid);

    /**
     * 添加角色跟菜单
     */
    @Insert("INSERT INTO `system_user_role_menu` (`m_id`, `r_id`) values(#{menuId}, #{rid})")
    int addRoleMenu(@Param("menuId") Integer menuId, @Param("rid") Integer rid);


    /**
     * 删除角色的菜单
     */
    @DeleteProvider(type = RoleMenuProvider.class, method = "delRoleMenu")
    int delRoleMenu(RoleMenu roleMenu);
}
