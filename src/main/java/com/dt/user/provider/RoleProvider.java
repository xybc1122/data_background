package com.dt.user.provider;


import com.dt.user.dto.RoleDto;
import com.dt.user.dto.UserDto;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class RoleProvider {

    public String findByRoleInfo(RoleDto roleDto) {
        return new SQL() {{
            SELECT("r.rid,r.r_name,GROUP_CONCAT(DISTINCT u.user_name)AS userName,GROUP_CONCAT(DISTINCT u.uid)AS uIds , \n" +
                    "GROUP_CONCAT(DISTINCT s.`shop_name`)AS shopName," +
                    "GROUP_CONCAT(DISTINCT s.`shop_id`)AS sIds," +
                    "GROUP_CONCAT(DISTINCT se.`site_id`)AS seIds, \n" +
                    "GROUP_CONCAT(DISTINCT a.`area_id`)AS aids \n" +
                    "FROM system_user_role AS r ");
            LEFT_OUTER_JOIN("`system_user_role_user` AS ur ON ur.`r_id`=r.`rid`");
            LEFT_OUTER_JOIN("`system_user_info` AS u ON u.uid= ur.u_id");
            LEFT_OUTER_JOIN("`system_shop_role` AS sr ON sr.r_id = r.rid");
            LEFT_OUTER_JOIN("`basic_public_shop` AS s ON s.`shop_id` = sr.s_id");
            LEFT_OUTER_JOIN("`basic_public_area_role` AS ar ON ar.`r_id` = r.`rid`");
            LEFT_OUTER_JOIN("`basic_public_area` AS a ON a.`area_id` = ar.`a_id`");
            LEFT_OUTER_JOIN("`basic_public_area_role_site` AS ars ON ars.`ar_id`=ar.`ar_id`");
            LEFT_OUTER_JOIN("`basic_public_site` AS se ON se.`site_id`=ars.`se_id`");
            if (StringUtils.isNotBlank(roleDto.getUserName())) {
                WHERE("u.user_name=#{userName}");
            }
            if (StringUtils.isNotBlank(roleDto.getrName())) {
                WHERE("r.r_name=#{rName}");
            }
            GROUP_BY("r.rid");
        }}.toString();
    }
}
