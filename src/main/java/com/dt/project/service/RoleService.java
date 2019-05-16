package com.dt.project.service;


import com.dt.project.dto.RoleDto;
import com.dt.project.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    //查询角色信息
    Set<String> getAllRolesByUid(Long uid);

    List<Role> getRoleList();

    /**
     * 查询一个角色下的所有用户跟 菜单
     *
     * @return
     */
    List<RoleDto> findByRoleInfo(RoleDto roleDto);


    /**
     * 通过角色名字去查询数据库是否有重复
     */
    String findByRoleName(String rName);
}
