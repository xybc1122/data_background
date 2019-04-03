package com.dt.user.service.impl;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.mapper.RoleMenuMapper;
import com.dt.user.model.RoleMenu;
import com.dt.user.service.RoleMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class RoleMenuServiceImpl implements RoleMenuService {
    @Autowired
    private RoleMenuMapper roleMenuMapper;

    @Override
    public List<RoleMenu> gerRoleMenus(Long rid) {
        return roleMenuMapper.gerRoleMenus(rid);
    }

    @Override
    @Transactional
    public ResponseBase addAndDelMenu(Map<String, Object> menuMap) {
        String rid = (String) menuMap.get("rid");
        String menuIds = (String) menuMap.get("menuIds");
        if (StringUtils.isNotBlank(menuIds)) {
            List<String> arrMenuIds = Arrays.asList(menuIds.split(","));
            Boolean menuFlg = (Boolean) menuMap.get("menuFlg");
            //true =添加菜单  false =删除菜单
            if (menuFlg) {
                //先查询已有的关联菜单
                List<RoleMenu> roleMenuList = roleMenuMapper.gerRoleMenus(Long.parseLong(rid));
                List<Long> resultMenuIds = menuListRoles(arrMenuIds, roleMenuList);
                if (resultMenuIds.size() != 0) {
                    //新增菜单
                    for (int i = 0; i < resultMenuIds.size(); i++) {
                        Long menuId = resultMenuIds.get(i);
                        roleMenuMapper.addRoleMenu(menuId, Long.parseLong(rid));
                    }
                    return JsonData.setResultSuccess("添加菜单成功");
                }
            } else {
                RoleMenu roleMenu = new RoleMenu();
                //通过arrMenuIds 删除关联的菜单
                for (int i = 0; i < arrMenuIds.size(); i++) {
                    roleMenu.setrId(Long.parseLong(rid));
                    roleMenu.setmId(Long.parseLong(arrMenuIds.get(i)));
                    roleMenuMapper.delRoleMenu(roleMenu);
                }
                return JsonData.setResultSuccess("删除关联成功");
            }
        }
        return JsonData.setResultError("无菜单操作");
    }

    /**
     * 对比两个数组是否是否一直 如果有不一致的 取出不一致的数据
     *
     * @param arrMenuIds
     * @param roleMenuList
     * @return
     */
    public List<Long> menuListRoles(List<String> arrMenuIds, List<RoleMenu> roleMenuList) {
        List<Long> resultMenuIds = new ArrayList<>();
        for (int i = 0; i < arrMenuIds.size(); i++) {
            String arrIds = arrMenuIds.get(i);
            boolean flag = false;
            for (int j = 0; j < roleMenuList.size(); j++) {
                RoleMenu roleMenuIds = roleMenuList.get(j);
                if (arrIds.equals(roleMenuIds.getmId().toString())) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                resultMenuIds.add(Long.parseLong(arrIds));
            }
        }
        return resultMenuIds;
    }

}
