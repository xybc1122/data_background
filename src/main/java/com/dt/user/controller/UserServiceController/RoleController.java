package com.dt.user.controller.UserServiceController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.RoleDto;
import com.dt.user.model.Role;
import com.dt.user.model.UserInfo;
import com.dt.user.service.RoleService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 查询所有角色信息
     *
     * @return
     */
    @GetMapping("/findByListRoles")
    public ResponseBase findByListRoles() {
        List<Role> roles = roleService.getRoleList();
        return JsonData.setResultSuccess(roles);
    }


    /**
     * 查询一个角色下的所有用户跟菜单
     * @return
     */
    @PostMapping("/getRoles")
    public ResponseBase getRoles(@RequestBody RoleDto roleDto) {
        PageInfoUtils.setPage(roleDto.getPageSize(), roleDto.getCurrentPage());
        List<RoleDto> listRoles = roleService.findByRoleInfo(roleDto);
        return PageInfoUtils.returnPage(listRoles, roleDto.getCurrentPage());
    }
}
