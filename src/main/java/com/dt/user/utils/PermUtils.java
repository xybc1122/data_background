package com.dt.user.utils;

import com.dt.user.config.ApplicationContextRegister;
import com.dt.user.exception.LsException;
import com.dt.user.model.Permission;
import com.dt.user.service.PermsMapperService;
import com.dt.user.service.RoleService;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * @ClassName PermUtils
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/14 15:12
 **/
public class PermUtils {
    /**
     * 获得角色跟权限
     *
     * @param request
     * @return
     */
    public static Permission doGetPerm(HttpServletRequest request) {
        Integer uid = (Integer) request.getAttribute("uId");
        RoleService roleService = ApplicationContextRegister.getBean(RoleService.class);
        PermsMapperService permsService = ApplicationContextRegister.getBean(PermsMapperService.class);
        //获得角色
        Set<String> roles = roleService.getAllRolesByUid(uid.longValue());
        //获得权限
        Set<String> perms = permsService.findByPerms(uid.longValue());
        if (perms == null || perms.size() <= 0) throw new LsException("无权操作");
        Permission info = new Permission();
        info.setRoles(roles);
        info.setPermissions(perms);
        return info;
    }

}
