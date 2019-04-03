package com.dt.user.controller.UserServiceController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.model.RoleMenu;
import com.dt.user.service.RoleMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RequestMapping("/api/v1/rm")
@RestController
public class RoleMenuController {

    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * 角色管理修改页面 点击确定后请求此接口
     * 包含删除菜单，新增菜单
     *
     * @param menuMap
     * @return
     */
    @PostMapping("/upMenus")
    public ResponseBase getMenus(@RequestBody Map<String, Object> menuMap) {
        return roleMenuService.addAndDelMenu(menuMap);
    }

}
