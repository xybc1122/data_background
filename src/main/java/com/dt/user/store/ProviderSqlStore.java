package com.dt.user.store;

import com.dt.user.model.SystemLogStatus;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName ProviderSqlStore
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 9:58
 **/
public class ProviderSqlStore {

    public static void saveStatus(SystemLogStatus logStatus, String as, SQL sql) {
        if (logStatus != null) {
            sql.LEFT_OUTER_JOIN("`system_log_status` AS ls ON ls.status_id=" + as + ". `status_id` ");
            //备注
            if (StringUtils.isNotBlank(logStatus.getRemark())) {
                sql.WHERE("ls.remark=#{systemLogStatus.remark}");
            }
            //状态
            if (logStatus.getStatus() != null) {
                sql.WHERE("ls.status=#{systemLogStatus.status}");
            }
            //创建时间
            if (logStatus.getCreateDate() != null) {
                sql.WHERE("ls.create_date=#{systemLogStatus.createDate}");
            }
            //创建人
            if (logStatus.getCreateUser() != null) {
                sql.WHERE("ls.create_user=#{systemLogStatus.createUser}");
            }
            //修改日期
            if (logStatus.getModifyDate() != null) {
                sql.WHERE("ls.modify_date=#{systemLogStatus.modifyDate}");
            }
            //修改人
            if (logStatus.getModifyUser() != null) {
                sql.WHERE("ls.modify_user=#{systemLogStatus.modifyUser}");
            }
            //审核时间
            if (logStatus.getAuditDate() != null) {
                sql.WHERE("ls.audit_date=#{systemLogStatus.auditDate}");
            }
            //审核人
            if (logStatus.getAuditUser() != null) {
                sql.WHERE("ls.audit_user=#{systemLogStatus.auditUser}");
            }
        }

    }
}
