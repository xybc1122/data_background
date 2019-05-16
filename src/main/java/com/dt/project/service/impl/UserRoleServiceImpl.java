package com.dt.project.service.impl;

import com.dt.project.mapper.UserRoleMapper;
import com.dt.project.model.UserRole;
import com.dt.project.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public int addUserRole(List<UserRole> urList) {
        return userRoleMapper.addUserRole(urList);
    }

    @Override
    public int delUserRole(Long rid, Long uid) {
        return userRoleMapper.delUserRole(rid, uid);
    }

}