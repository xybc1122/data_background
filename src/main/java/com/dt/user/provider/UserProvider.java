package com.dt.user.provider;


import com.dt.user.dto.UserDto;
import com.dt.user.utils.MD5Util;
import com.dt.user.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class UserProvider {


    public String findUsers(UserDto userDto) {
        SQL sql = new SQL();
        String Alias = "u";
        sql.SELECT("u.uid,u.name,u.computer_name,u.user_name,u.account_status,u.landing_time,u.version," +
                "GROUP_CONCAT(r.`r_name`)as rName,GROUP_CONCAT(r.`rid`)as rid," +
                "s.mobile_phone,u.user_expiration_date,u.pwd_validity_period,u.create_date,u.create_user,u.modify_date," +
                "u.modify_user,u.audit_date,u.audit_user");
        sql.FROM("system_user_info AS " + Alias + "");
        sql.LEFT_OUTER_JOIN("system_user_role_user AS ur ON(ur.u_id=u.uid)");
        sql.LEFT_OUTER_JOIN("system_user_role AS r ON(r.rid=ur.r_id)");
        sql.LEFT_OUTER_JOIN("`hr_archives_employee` AS s ON(u.uid=s.u_id)");
        //用户账号
        if (StringUtils.isNotBlank(userDto.getUserName())) {
            sql.WHERE("POSITION('" + userDto.getUserName() + "' IN u.`user_name`)");
        }
        //用户名
        if (StringUtils.isNotBlank(userDto.getName())) {
            sql.WHERE("POSITION('" + userDto.getName() + "' IN u.`name`)");
        }
        //角色名字
        if (StringUtils.isNotBlank(userDto.getrName())) {
            sql.WHERE("POSITION('" + userDto.getrName() + "' IN r.r_name)");
        }
        //密码有效期
        if (userDto.getPwdValidityPeriods() != null && userDto.getPwdValidityPeriods().size() > 0) {
            sql.WHERE("u.pwd_validity_period BETWEEN  " + userDto.getPwdValidityPeriods().get(0) + " AND " + userDto.getPwdValidityPeriods().get(1) + "");
            //始终有效
        } else if (userDto.isPwdAlways()) {
            sql.WHERE("u.pwd_validity_period=0");
        }
        //登陆时间
        if (userDto.getLandingTimes() != null && userDto.getLandingTimes().size() > 0) {
            sql.WHERE("u.landing_time BETWEEN  " + userDto.getLandingTimes().get(0) + " AND " + userDto.getLandingTimes().get(1) + "");
        }
        //用户有效期间
        if (userDto.getUserExpirationDates() != null && userDto.getUserExpirationDates().size() > 0) {
            sql.WHERE("u.user_expiration_date BETWEEN  " + userDto.getUserExpirationDates().get(0) + " AND " + userDto.getUserExpirationDates().get(1) + "");
            //始终有效
        } else if (userDto.isuAlways()) {
            sql.WHERE("u.user_expiration_date=0");
        }
        //计算机名
        if (StringUtils.isNotBlank(userDto.getComputerName())) {
            sql.WHERE("POSITION('" + userDto.getComputerName() + "' IN u.computer_name)");
        }
        //用户状态
        if (userDto.getAccountStatus() != null) {
            sql.WHERE("u.account_status=#{accountStatus}");
        }
        //用户手机
        if (StringUtils.isNotBlank(userDto.getMobilePhone())) {
            sql.WHERE("POSITION('" + userDto.getMobilePhone() + "' IN s.mobile_phone)");
        }
        //备注
        if (StringUtils.isNotBlank(userDto.getRemark())) {
            sql.WHERE("u.remark=#{remark}");
        }
        //创建时间
        if (userDto.getCreateDates() != null && (userDto.getCreateDates().size() > 0)) {
            sql.WHERE("ls.create_date BETWEEN  " + userDto.getCreateDates().get(0) + " AND " + userDto.getCreateDates().get(1) + "");
        }
        //创建人
        if (StringUtils.isNotBlank(userDto.getCreateUser())) {
            sql.WHERE("u.create_user=#{createUser}");
        }
        //修改日期
        if (userDto.getModifyDates() != null && (userDto.getModifyDates().size() > 0)) {
            sql.WHERE("u.modify_date BETWEEN  " + userDto.getModifyDates().get(0) + " AND " + userDto.getModifyDates().get(1) + "");
        }
        //修改人
        if (StringUtils.isNotBlank(userDto.getModifyUser())) {
            sql.WHERE("u.modify_user=#{modifyUser}");
        }
        //审核时间
        if (userDto.getAuditDates() != null && (userDto.getAuditDates().size() > 0)) {
            sql.WHERE("u.audit_date BETWEEN  " + userDto.getAuditDates().get(0) + " AND " + userDto.getAuditDates().get(1) + "");
        }
        //审核人
        if (StringUtils.isNotBlank(userDto.getAuditUser())) {
            sql.WHERE("u.audit_user=#{auditUser}");
        }
        sql.WHERE("u.del_or_not=0");
        sql.GROUP_BY("u.uid");
        return sql.toString();
    }


    public String upUserInfo(Map<String, Object> userMap) {
        return new SQL() {{
            UPDATE("`system_user_info`");
            String name = (String) userMap.get("name");
            if (StringUtils.isNotBlank(name)) {
                SET("name=" + "'" + name + "'");
            }
            String pwd = (String) userMap.get("pwd");
            if (StringUtils.isNotBlank(pwd)) {
                String userName = (String) userMap.get("userName");
                if (StringUtils.isNotBlank(userName)) {
                    //md5盐值密码加密
                    String md5Pwd = MD5Util.saltMd5(userName, pwd);
                    SET("pwd=" + "'" + md5Pwd + "'");
                }
            }
            //如果勾选用户始终有效
            Boolean pwdAlways = (Boolean) userMap.get("pwdAlways");
            if (pwdAlways != null) {
                if (pwdAlways) {
                    SET("user_expiration_date=" + 0);
                } else if (userMap.get("userExpirationDate") != null) {
                    Long userExpirationDate = (Long) userMap.get("userExpirationDate");
                    SET("user_expiration_date=" + userExpirationDate);
                }
            }
            //如果勾选密码始终有效
            Boolean uAlways = (Boolean) userMap.get("uAlways");
            if (uAlways != null) {
                if (uAlways) {
                    SET("pwd_validity_period=" + 0);
                } else if (userMap.get("pwdValidityPeriod") != null) {
                    Long pwdValidityPeriod = (Long) userMap.get("pwdValidityPeriod");
                    SET("pwd_validity_period=" + pwdValidityPeriod);
                }
            }
            if (userMap.get("accountStatus") != null) {
                Integer accountStatus = (Integer) userMap.get("accountStatus");
                SET("account_status=" + accountStatus);
            }
            //勾选了首次登陆修改密码
            Boolean checkedUpPwd = (Boolean) userMap.get("checkedUpPwd");
            if (checkedUpPwd != null) {
                SET("is_first_login=" + checkedUpPwd);
            }
            Integer version = (Integer) userMap.get("version");
            SET("version=" + version + "+1");
            Integer uid = (Integer) userMap.get("uid");
            WHERE("version=" + version);
            WHERE("uid=" + uid);
        }}.toString();
    }


    public String findByRoleInfo(UserDto userDto) {
        return new SQL() {{
            SELECT(" r.r_name,GROUP_CONCAT(DISTINCT u.user_name)as userName,GROUP_CONCAT(DISTINCT m.name)as menuName FROM system_user_info AS u");
            INNER_JOIN("system_user_role_user AS ur ON ur.`u_id`=u.`uid`");
            INNER_JOIN("system_user_role AS r ON ur.`r_id`=r.`rid`");
            LEFT_OUTER_JOIN("system_user_role_menu AS rm ON rm.`r_id`=r.`rid`");
            LEFT_OUTER_JOIN("menu AS m ON m.`menu_id`=rm.`m_id`");
            GROUP_BY("r.rid");
        }}.toString();
    }

    public String delUserInfo(Map<String, Object> mapDel) {
        String uidIds = mapDel.get("uidIds").toString();
        return StrUtils.updateSql(uidIds,
                "UPDATE `system_user_info`\n" + "SET `del_or_not` = ", "1", ",`modify_date` = ", "uid");

    }

    public String reUserInfo(Map<String, Object> mapDel) {
        String uidIds = mapDel.get("uidIds").toString();
        return StrUtils.updateSql(uidIds,
                "UPDATE `system_user_info`\n" + "SET `del_or_not` = ", "0", "`modify_date` = ", "uid");

    }
}
