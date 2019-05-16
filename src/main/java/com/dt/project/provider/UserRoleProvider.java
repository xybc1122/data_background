package com.dt.project.provider;

import com.dt.project.model.UserRole;

import java.util.List;
import java.util.Map;

public class UserRoleProvider {

    /**
     * 添加信息
     *
     * @param urMap
     * @return
     */
    public String addUserRole(Map<String, Object> urMap) {
        UserRole ur;
        List<UserRole> urList = (List<UserRole>) urMap.get("userRoleList");
        StringBuilder sb = new StringBuilder();
        sb.append("insert into system_user_role_user(u_id,r_id)values");
        for (UserRole anUrList : urList) {
            ur = anUrList;
            //一个员工添加多个角色
            if (null != ur.getRoleIds()) {
                List<Integer> rIds = anUrList.getRoleIds();
                for (Integer rId1 : rIds) {
                    long rId = rId1.longValue();
                    sb.append("(").append(ur.getUid()).append(",").append(rId).append("),");
                }
            }
            //一个角色添加多个员工
            if (null != ur.getUserIds()) {
                List<Integer> uIds = anUrList.getUserIds();
                for (Integer uId1 : uIds) {
                    long uId = uId1.longValue();
                    sb.append("(").append(uId).append(",").append(ur.getRid()).append("),");
                }
            }
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}
