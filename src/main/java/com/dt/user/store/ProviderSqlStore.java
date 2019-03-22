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
            //有效日期
            if (logStatus.getEffectiveDates() != null && (logStatus.getEffectiveDates().size() > 0)) {
                sql.WHERE("ls.effective_date BETWEEN  " + logStatus.getEffectiveDates().get(0) + " AND " + logStatus.getEffectiveDates().get(1) + "");
            }
            //备注
            if (StringUtils.isNotBlank(logStatus.getRemark())) {
                sql.WHERE("ls.remark=#{systemLogStatus.remark}");
            }
            //状态
            if (logStatus.getStatus() != null) {
                sql.WHERE("ls.status=#{systemLogStatus.status}");
            }
            //创建时间
            if (logStatus.getCreateDates() != null && (logStatus.getCreateDates().size() > 0)) {
                sql.WHERE("ls.create_date BETWEEN  " + logStatus.getCreateDates().get(0) + " AND " + logStatus.getCreateDates().get(1) + "");
            }
            //创建人
            if (StringUtils.isNotBlank(logStatus.getCreateUser())) {
                sql.WHERE("ls.create_user=#{systemLogStatus.createUser}");
            }
            //修改日期
            if (logStatus.getModifyDates() != null && (logStatus.getModifyDates().size() > 0)) {
                sql.WHERE("ls.modify_date BETWEEN  " + logStatus.getModifyDates().get(0) + " AND " + logStatus.getModifyDates().get(1) + "");
            }
            //修改人
            if (StringUtils.isNotBlank(logStatus.getModifyUser())) {
                sql.WHERE("ls.modify_user=#{systemLogStatus.modifyUser}");
            }
            //审核时间
            if (logStatus.getAuditDates() != null && (logStatus.getAuditDates().size() > 0)) {
                sql.WHERE("ls.audit_date BETWEEN  " + logStatus.getAuditDates().get(0) + " AND " + logStatus.getAuditDates().get(1) + "");
            }
            //审核人
            if (StringUtils.isNotBlank(logStatus.getAuditUser())) {
                sql.WHERE("ls.audit_user=#{systemLogStatus.auditUser}");
            }
        }

    }
}
