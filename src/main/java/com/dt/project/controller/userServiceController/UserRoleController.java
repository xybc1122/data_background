package com.dt.project.controller.userServiceController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.UserRole;
import com.dt.project.redis.RedisService;
import com.dt.project.service.UserRoleService;
import com.dt.project.toos.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1/ur")
@RestController
public class UserRoleController {

    @Autowired
    private UserRoleService roleService;
    @Autowired
    private RedisService redisService;

    /**
     * 删除角色信息
     *
     * @param delMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @PostMapping("/delRole")
    public ResponseBase delRole(@RequestBody Map<String, Object> delMap) {
        if (delMap.get("rolesId") instanceof List) {
            List<Integer> rid = (List<Integer>) delMap.get("rolesId");
            Integer uid = (Integer) delMap.get("uid");
            for (Integer r : rid) {
                roleService.delUserRole(r.longValue(), uid.longValue());
            }
            redisService.delKey(Constants.TOKEN + ":" + uid);
            return JsonData.setResultSuccess("删除用户成功");
        } else if (delMap.get("rolesId") instanceof String) {
            String rid = (String) delMap.get("rolesId");
            List<Integer> uid = (List<Integer>) delMap.get("uid");
            for (Integer u : uid) {
                roleService.delUserRole(Long.parseLong(rid), u.longValue());
                redisService.delKey(Constants.TOKEN + ":" + u);
            }
            return JsonData.setResultSuccess("角色删除成功");
        }
        return JsonData.setResultError("删除用户失败~");
    }

    /**
     * 增加角色信息
     *
     * @param addMap
     * @return
     */
    @SuppressWarnings("unchecked")
    @PostMapping("/addRole")
    public ResponseBase addRole(@RequestBody Map<String, Object> addMap) {
        UserRole userRole = new UserRole();
        List<UserRole> urList = new ArrayList<>();
        //如果是List类型
        if (addMap.get("rolesId") instanceof List) {
            List<Integer> rolesId = (List<Integer>) addMap.get("rolesId");
            Integer uid = (Integer) addMap.get("uid");
            userRole.setUid(uid.longValue());
            userRole.setRoleIds(rolesId);
            urList.add(userRole);
            //新增角色信息
            roleService.addUserRole(urList);
            redisService.delKey(Constants.TOKEN + ":" + uid);
            return JsonData.setResultSuccess("添加用户成功");
        } else if (addMap.get("rolesId") instanceof String) {
            //如果是String 类型
            String rId = (String) addMap.get("rolesId");
            List<Integer> uid = (List<Integer>) addMap.get("uid");
            userRole.setUserIds(uid);
            userRole.setRid(Long.parseLong(rId));
            urList.add(userRole);
            //新增角色信息
            roleService.addUserRole(urList);
            for (Integer id : uid) {
                redisService.delKey(Constants.TOKEN + ":" + id);
            }
            return JsonData.setResultSuccess("添加角色成功");
        }
        return JsonData.setResultError("添加失败~");
    }

}