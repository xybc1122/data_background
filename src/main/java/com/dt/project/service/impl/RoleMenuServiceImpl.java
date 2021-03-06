package com.dt.project.service.impl;


import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.RoleMenuMapper;
import com.dt.project.model.RoleMenu;
import com.dt.project.redis.RedisService;
import com.dt.project.service.RoleMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    private RoleMenuMapper roleMenuMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public List<String> gerRoleMenus(Integer rid) {
        return roleMenuMapper.gerRoleMenus(rid);
    }

    @Override
    @Transactional
    public ResponseBase addAndDelMenu(Map<String, Object> menuMap) {
        Integer rid = (Integer) menuMap.get("rid");
        String menuIds = (String) menuMap.get("menuIds");
        if (StringUtils.isNotBlank(menuIds)) {
            //前端传来的数据
            List<String> resultMenuIds = Arrays.asList(menuIds.split(","));
            RoleMenu roleMenu = new RoleMenu();
            roleMenu.setRid(rid);
            roleMenuMapper.delRoleMenu(roleMenu);
            if (resultMenuIds.size() != 0) {
                //新增菜单
                for (int i = 0; i < resultMenuIds.size(); i++) {
                    String menuId = resultMenuIds.get(i);
                    roleMenuMapper.addRoleMenu(Integer.parseInt(menuId), rid);
                }
                redisService.setString("tokenMenu", "success");
                return JsonData.setResultSuccess("添加菜单成功");
            }
        }
        return JsonData.setResultError("添加菜单失败");
    }
}
