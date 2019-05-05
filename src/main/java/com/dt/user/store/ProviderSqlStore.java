package com.dt.user.store;

import com.dt.user.model.Parent.ParentUploadInfo;
import com.dt.user.model.SystemLogStatus;
import com.dt.user.utils.ReqUtils;
import com.dt.user.utils.StrUtils;
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
    public static String statusV(String alias) {

        return alias + ".`remark`," + alias + ".`status`," + alias + ".`create_date`, " + alias + ".`create_id_user`, " +
                "`modify_date`,`modify_id_user`,`audit_date`,`audit_id_user`," + alias + ".`version` \n ";
    }


    /**
     * 通用 查询 系统类状态
     *
     * @param logStatus
     * @param as
     * @param sql
     */
    public static void selectStatus(SystemLogStatus logStatus, String as, SQL sql) {
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
     * 设置通过用链表
     */
    public static String joinTable(SQL sql, String alias) {
        String s = "(\n" +
                "SELECT ars.`se_id`\n" +
                "FROM `basic_public_area_role_site` AS ars,(SELECT\n" +
                "  `ar_id`  FROM `basic_public_area_role`\n" +
                "WHERE " + StrUtils.in(ReqUtils.getRoleId(), "r_id") + ") AS ar\n" +
                "WHERE ar.ar_id=ars.`ar_id`\n" +
                "GROUP BY ars.se_id) AS b \n";
        sql.WHERE("b.se_id=" + alias + ".`site_id`");
        return s;
    }

    /**
     * 通用查询 文件类 数据状态
     *
     * @param sql
     * @param p
     */
    public static void selectUploadStatus(SQL sql, ParentUploadInfo p, String alias) {
        //店铺名称
        if (p.getShopId() != null) {
            sql.WHERE(alias + ".shop_id=#{shopId}");
        }
        //站点名称
        if (p.getSiteId() != null) {
            sql.WHERE(alias + ".site_id=#{siteId}");
        }
        //文件已有时间
        if (p.getDates() != null && (p.getDates().size() > 0)) {
            sql.WHERE(alias + ".date  " + p.getDates().get(0) + " AND " + p.getDates().get(1) + "");
        }
        //备注
        if (StringUtils.isNotBlank(p.getRemark())) {
            sql.WHERE(alias + ".remark=#{remark}");
        }
        //状态
        if (p.getStatus() != null) {
            sql.WHERE(alias + ".status=#{status}");
        }
        //创建时间
        if (p.getCreateDates() != null && (p.getCreateDates().size() > 0)) {
            sql.WHERE(alias + ".create_date BETWEEN  " + p.getCreateDates().get(0) + " AND " + p.getCreateDates().get(1) + "");
        }
       // sql.WHERE(alias + ".del_or_not=0");
    }
}
