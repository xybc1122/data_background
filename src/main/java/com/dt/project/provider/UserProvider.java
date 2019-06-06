package com.dt.project.provider;


import com.dt.project.model.dto.UserDto;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.toos.Constants;
import com.dt.project.utils.MD5Util;
import com.dt.project.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class UserProvider {


    public String findUsers(UserDto userDto) {
        SQL sql = new SQL();
        String alias = "u";
        sql.SELECT("u.uid,u.name,u.computer_name,u.user_name,u.account_status,u.landing_time,u.version," +
                "GROUP_CONCAT(r.`r_name`)as rName,GROUP_CONCAT(r.`rid`)as rid," +
                "s.mobile_phone,u.user_expiration_date,u.pwd_validity_period,u.create_date,u.create_user,u.modify_date," +
                "u.modify_user,u.audit_date,u.audit_user");
        sql.FROM("system_user_info AS " + alias + "");
        sql.LEFT_OUTER_JOIN("system_user_role_user AS ur ON(ur.u_id=u.uid)");
        sql.LEFT_OUTER_JOIN("system_user_role AS r ON(r.rid=ur.r_id)");
        sql.LEFT_OUTER_JOIN("`hr_archives_employee` AS s ON(u.uid=s.u_id)");
        //用户账号
        AppendSqlStore.sqlWhere(userDto.getUserName(), alias + ".`user_name`", sql, Constants.SELECT,alias);
        //用户名
        AppendSqlStore.sqlWhere(userDto.getName(), alias + ".`name`", sql, Constants.SELECT,alias);
        //角色名字
        AppendSqlStore.sqlWhere(userDto.getrName(), "r.r_name", sql, Constants.SELECT,alias);
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
        AppendSqlStore.sqlWhere(userDto.getComputerName(), alias + ".`computer_name`", sql, Constants.SELECT,alias);
        //用户状态
        AppendSqlStore.sqlWhere(userDto.getAccountStatus(), "u.account_status", sql, Constants.SELECT,alias);
        //用户手机
        AppendSqlStore.sqlWhere(userDto.getMobilePhone(), "s.mobile_phone", sql, Constants.SELECT,alias);
        //备注
        AppendSqlStore.sqlWhere(userDto.getRemark(), alias + ".`remark`", sql, Constants.SELECT,alias);
        //创建时间
        if (userDto.getCreateDates() != null && (userDto.getCreateDates().size() > 0)) {
            sql.WHERE("ls.create_date BETWEEN  " + userDto.getCreateDates().get(0) + " AND " + userDto.getCreateDates().get(1) + "");
        }
        //创建人
        AppendSqlStore.sqlWhere(userDto.getCreateUser(), alias + ".`create_user`", sql, Constants.SELECT,alias);
        //修改日期
        if (userDto.getModifyDates() != null && (userDto.getModifyDates().size() > 0)) {
            sql.WHERE("u.modify_date BETWEEN  " + userDto.getModifyDates().get(0) + " AND " + userDto.getModifyDates().get(1) + "");
        }
        //修改人
        AppendSqlStore.sqlWhere(userDto.getModifyUser(), alias + ".`modify_user`", sql, Constants.SELECT,alias);
        //审核时间
        if (userDto.getAuditDates() != null && (userDto.getAuditDates().size() > 0)) {
            sql.WHERE("u.audit_date BETWEEN  " + userDto.getAuditDates().get(0) + " AND " + userDto.getAuditDates().get(1) + "");
        }
        //审核人
        AppendSqlStore.sqlWhere(userDto.getAuditUser(), alias + ".`audit_user`", sql, Constants.SELECT,alias);
        sql.WHERE(alias + ".del_or_not=0");
        sql.GROUP_BY(alias + ".uid");
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
            Integer uid = (Integer) userMap.get("uid");

            SET("version=" + version + "+1");
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
