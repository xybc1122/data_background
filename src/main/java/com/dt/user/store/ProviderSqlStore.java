package com.dt.user.store;

import com.dt.user.model.ParentUploadInfo;
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
    /**
     * 通用设置sql状态
     */
    public static String statusV = "`remark`,`status`,`create_date`,`create_user`," +
            "`modify_date`,`modify_user`,`audit_date`,`audit_user` \n";

    /**
     * 通用设置
     *
     * @param logStatus
     * @param as
     * @param sql
     */
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

    /**
     * 通用设置
     *
     * @param sql
     * @param p
     */
    public static void saveUploadStatus(SQL sql, ParentUploadInfo p) {
        //店铺名称
        if (StringUtils.isNotBlank(p.getShopName())) {
            sql.WHERE("POSITION('" + p.getShopName() + "' IN s.`shop_name`)");
        }
        //站点名称
        if (StringUtils.isNotBlank(p.getSiteName())) {
            sql.WHERE("POSITION('" + p.getSiteName() + "' IN cs.`site_name`)");
        }
        //文件已有时间
        if (p.getDates() != null && (p.getDates().size() > 0)) {
            sql.WHERE("date  " + p.getDates().get(0) + " AND " + p.getDates().get(1) + "");
        }
        //有效日期
        if (p.getEffectiveDates() != null && (p.getEffectiveDates().size() > 0)) {
            sql.WHERE("effective_date BETWEEN  " + p.getEffectiveDates().get(0) + " AND " + p.getEffectiveDates().get(1) + "");
        }
        //备注
        if (StringUtils.isNotBlank(p.getRemark())) {
            sql.WHERE("remark=#{remark}");
        }
        //状态
        if (p.getStatus() != null) {
            sql.WHERE("status=#{status}");
        }
        //创建时间
        if (p.getCreateDates() != null && (p.getCreateDates().size() > 0)) {
            sql.WHERE("create_date BETWEEN  " + p.getCreateDates().get(0) + " AND " + p.getCreateDates().get(1) + "");
        }
        //创建人
        if (StringUtils.isNotBlank(p.getCreateUser())) {
            sql.WHERE("create_user=#{createUser}");
        }
        //修改日期
        if (p.getModifyDates() != null && (p.getModifyDates().size() > 0)) {
            sql.WHERE("modify_date BETWEEN  " + p.getModifyDates().get(0) + " AND " + p.getModifyDates().get(1) + "");
        }
        //修改人
        if (StringUtils.isNotBlank(p.getModifyUser())) {
            sql.WHERE("modify_user=#{modifyUser}");
        }
        //审核时间
        if (p.getAuditDates() != null && (p.getAuditDates().size() > 0)) {
            sql.WHERE("audit_date BETWEEN  " + p.getAuditDates().get(0) + " AND " + p.getAuditDates().get(1) + "");
        }
        //审核人
        if (StringUtils.isNotBlank(p.getAuditUser())) {
            sql.WHERE("audit_user=#{auditUser}");
        }

    }
}
