package com.dt.user.store;

import com.dt.user.model.Parent.ParentUploadInfo;
import com.dt.user.model.SystemLogStatus;
import com.dt.user.utils.ReqUtils;
import com.dt.user.utils.StrUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import java.util.Date;

/**
 * @ClassName ProviderSqlStore
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 9:58
 **/
public class ProviderSqlStore {
    /**
     * 通用查询sql 所有状态
     */
    public static String statusV(String alias) {

        return alias + ".`remark`," + alias + ".`status`," + alias + ".`create_date`, " + alias + ".`create_user`, " +
                "" + alias + ".`modify_date`," + alias + ".`modify_user`," + alias + ".`audit_date`," + alias + ".`audit_user`," + alias + ".`version` \n ";
    }

    /**
     * 通用存入sql部分状态
     */
    public static String setV() {

        return "`create_date`,`create_user`,`recording_id`";
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
//            //有效日期
//            if (logStatus.getEffectiveDates() != null && (logStatus.getEffectiveDates().size() > 0)) {
//                sql.WHERE("ls.effective_date BETWEEN  " + logStatus.getEffectiveDates().get(0) + " AND " + logStatus.getEffectiveDates().get(1) + "");
//            }
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
    public static void joinTable(SQL sql, String alias) {
        sql.INNER_JOIN("`basic_public_shop` AS s ON s.`shop_id`=" + alias + ".`shop_id`");
        sql.INNER_JOIN("(SELECT s_id FROM system_shop_role AS c_pr  " +
                "WHERE " + StrUtils.in(ReqUtils.getRoleId(), "c_pr.r_id") + " GROUP BY s_id) AS pr ON  pr.s_id  = s.`shop_id`");
        sql.INNER_JOIN("`basic_public_site` AS cs ON cs.`site_id` = " + alias + ".`site_id`");
        sql.INNER_JOIN("`basic_public_area_role_site` AS ars ON ars.`se_id`=cs.`site_id`");
        sql.INNER_JOIN("(SELECT ar_id FROM `basic_public_area_role` AS c_ar  WHERE " + StrUtils.in(ReqUtils.getRoleId(), "c_ar.r_id ") + " " +
                " GROUP BY a_id) AS ar ON ar.`ar_id` = ars.`ar_id`");
    }

    /**
     * 临时的
     * 设置站点 join table
     */
    public static String siteJoinTable(SQL sql, String alias) {
        String s = "(SELECT DISTINCT ars.`se_id`\n" +
                "FROM `basic_public_area_role_site` AS ars\n" +
                "INNER JOIN (SELECT`ar_id`FROM `basic_public_area_role`WHERE " + StrUtils.in(ReqUtils.getRoleId(), "r_id") + ") AS ar ON  ar.ar_id=ars.`ar_id`\n" +
                ") AS b \n";
        sql.WHERE("b.se_id=" + alias + ".`site_id`");
        return s;
    }

//    /**
//     * 这里这样写是性能优化后的sql
//     * 设置通过用链表
//     */
//    public static String fsbJoinTable(SQL sql, String alias) {
//        String s = "(SELECT DISTINCT ars.`se_id`\n" +
//                "FROM `basic_public_area_role_site` AS ars\n" +
//                "INNER JOIN (SELECT`ar_id`FROM `basic_public_area_role`WHERE " + StrUtils.in(ReqUtils.getRoleId(), "r_id") + ") AS ar ON  ar.ar_id=ars.`ar_id`\n" +
//                ") AS b \n";
//        sql.WHERE("b.se_id=" + alias + ".`site_id`");
//        return s;
//    }

    /**
     * 通用更新 数据状态
     *
     * @param sql
     * @param p
     */
    public static void setStatus(SQL sql, ParentUploadInfo p) {
        if (StringUtils.isNotBlank(p.getRemark())) {
            sql.SET("`remark` = #{remark,jdbcType=VARCHAR}");
        }

        if (p.getStatus() != null) {
            sql.SET("`status` = #{status,jdbcType=INTEGER}");
        }


        if (StringUtils.isNotBlank(p.getCreateUser())) {
            sql.SET("`create_user` = #{createUser,jdbcType=BIGINT}");

        }
        if (p.getCreateDate() != null) {
            sql.SET("`create_date` = #{createDate,jdbcType=BIGINT}");
        }


        if (StringUtils.isNotBlank(p.getModifyUser())) {
            sql.SET("`modify_user` = #{modifyUser,jdbcType=BIGINT}");

        }
        if (p.getModifyDate() != null) {
            sql.SET("`modify_date` = #{modifyDate,jdbcType=BIGINT}");
        }


        if (StringUtils.isNotBlank(p.getAuditUser())) {
            sql.SET("`audit_user` = #{auditUser,jdbcType=BIGINT}");

        }
        if (p.getAuditDate() != null) {
            sql.SET("`audit_date` = #{auditDate,jdbcType=BIGINT}");
        }
        Integer version = p.getVersion();
        sql.SET("version=" + version + "+1");
        sql.WHERE("version=" + version);
    }

    /**
     * 通用查询 文件类 数据状态
     *
     * @param sql
     * @param p
     */
    public static void selectUploadStatus(SQL sql, ParentUploadInfo p, String alias) {
        if (StringUtils.isNotBlank(p.getShopName())) {
            sql.WHERE(alias + ".`shop_id`=#{shopId}");
        }
        //站点名称
        if (StringUtils.isNotBlank(p.getSiteName())) {
            sql.WHERE(alias + ".`site_id`=#{siteId}");
        }
        //文件已有时间
        if (p.getDates() != null && (p.getDates().size() > 0)) {
            sql.WHERE(alias + ".date  BETWEEN " + p.getDates().get(0) + " AND " + p.getDates().get(1) + "");
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
        sql.WHERE(alias + ".del_or_not=0");
    }
    /**
     * 上传文件通用删除
     */
    public static String upDel(SQL sql, String table, String alias, int version) {
        sql.UPDATE(table + " AS " + alias);
        sql.SET(alias + ".`del_or_not` = 1");
        sql.SET(alias + ".`modify_date` =" + new Date().getTime());
        sql.SET(alias + ".`modify_user` = " + "'" + ReqUtils.getUserName() + "'");
        sql.SET("version=" + version + "+1");
        sql.WHERE("version=" + version);
        return sql.toString();
    }
}
