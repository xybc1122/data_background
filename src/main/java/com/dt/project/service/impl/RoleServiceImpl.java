package com.dt.project.service.impl;

import com.dt.project.model.dto.RoleDto;
import com.dt.project.mapper.RoleMapper;
import com.dt.project.model.Role;
import com.dt.project.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper rolesMapper;

    @Override
    public Set<String> getAllRolesByUid(Long uid) {

        return rolesMapper.getAllRolesByUid(uid);
    }

    @Override
    public List<Role> getRoleList() {
        return rolesMapper.getRoleList();
    }

    @Override
    public List<RoleDto> findByRoleInfo(RoleDto roleDto) {
        return rolesMapper.findByRoleInfo(roleDto);
    }

    @Override
    public String findByRoleName(String rName) {
        return rolesMapper.findByRoleName(rName);
    }
}
