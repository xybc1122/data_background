package com.dt.user.provider;

import com.dt.user.model.RoleMenu;
import org.apache.ibatis.jdbc.SQL;

public class RoleMenuProvider {


    public String delRoleMenu(RoleMenu roleMenu) {
        return new SQL() {{
            //通过角色id 去删除
            if (roleMenu.getmId() == null) {
                DELETE_FROM("`system_user_role_menu`");
                WHERE("r_id=" + roleMenu.getrId());
            } else {
                //通过角色id 跟菜单id 去删除
                DELETE_FROM("`system_user_role_menu`");
                WHERE("r_id=" + roleMenu.getrId() + " and m_id=" + roleMenu.getmId());
            }
        }}.toString();
    }
}
