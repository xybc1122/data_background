package com.dt.user.service.impl;

import com.dt.user.config.BaseRedisService;
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
    @Autowired
    private BaseRedisService redisService;

    @Override
    public List<String> gerRoleMenus(Long rid) {
        return roleMenuMapper.gerRoleMenus(rid);
    }

    @Override
    @Transactional
    //添加菜单跟删除有问题
    public ResponseBase addAndDelMenu(Map<String, Object> menuMap) {
        String rid = (String) menuMap.get("rid");
        String menuIds = (String) menuMap.get("menuIds");
        if (StringUtils.isNotBlank(menuIds)) {
            //前端传来的数据
            List<String> arrMenuIds = Arrays.asList(menuIds.split(","));
            //后端查询已有的关联菜单
            List<String> roleMenuList = roleMenuMapper.gerRoleMenus(Long.parseLong(rid));
            //比较
            List<Long> resultMenuIds = menuListRoles(arrMenuIds, roleMenuList, rid);
            if (resultMenuIds.size() != 0) {
                //新增菜单
                for (int i = 0; i < resultMenuIds.size(); i++) {
                    Long menuId = resultMenuIds.get(i);
                    roleMenuMapper.addRoleMenu(menuId, Long.parseLong(rid));
                }
                redisService.setString("tokenMenu", "success");
                return JsonData.setResultSuccess("添加菜单成功");
            }
        }
        return JsonData.setResultSuccess("修改菜单成功");
    }

    /**
     * 前后端对比数据 如果一直 添加进数组
     *
     * @param arrMenuIds
     * @param roleMenuList
     * @return
     */
    public List<Long> menuListRoles(List<String> arrMenuIds, List<String> roleMenuList, String rid) {
        if (arrMenuIds.size() < roleMenuList.size()) {
            return set(arrMenuIds, roleMenuList, rid);
        }
        return set(roleMenuList, arrMenuIds, rid);
    }

    /**
     * 封装
     *
     * @param strList1
     * @param stringList2
     * @return
     */
    public List<Long> set(List<String> strList1, List<String> stringList2, String rid) {
        List<Long> resultMenuIds = new ArrayList<>();
        for (int i = 0; i < strList1.size(); i++) {
            //前端
            String arrIds = strList1.get(i);
            boolean flag = false;
            for (int j = 0; j < stringList2.size(); j++) {
                //数据库
                String mId = stringList2.get(j);
                //如果一样的添加进去
                if (arrIds.equals(mId)) {
                    stringList2.remove(j);
                    flag = true;
                    break;
                }
            }
            //不一样的删除
            if (!flag) {
                resultMenuIds.add(Long.parseLong(arrIds));
            }
        }
        RoleMenu roleMenu = new RoleMenu();
        //删除之前已关联的菜单
        for (int k = 0; k < stringList2.size(); k++) {
            roleMenu.setrId(Long.parseLong(rid));
            roleMenu.setmId(Long.parseLong(stringList2.get(k)));
            roleMenuMapper.delRoleMenu(roleMenu);
        }
        return resultMenuIds;
    }
}
