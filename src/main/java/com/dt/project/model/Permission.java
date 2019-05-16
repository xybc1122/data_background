package com.dt.project.model;

import java.util.Set;

/**
 * @ClassName Permission
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/14 15:08
 * 角色 权限 返回对象表
 **/
public class Permission {

    private Set<String> Roles;


    private Set<String> Permissions;


    public Set<String> getRoles() {
        return Roles;
    }

    public void setRoles(Set<String> roles) {
        Roles = roles;
    }

    public Set<String> getPermissions() {
        return Permissions;
    }

    public void setPermissions(Set<String> permissions) {
        Permissions = permissions;
    }
}
