package com.dt.project.store;

import com.dt.project.model.parent.ParentConfTable;
import com.dt.project.model.parent.ParentDocument;
import com.dt.project.model.parent.ParentDocumentChild;
import com.dt.project.model.parent.ParentUploadInfo;
import com.dt.project.model.SystemLogStatus;
import com.dt.project.toos.Constants;
import com.dt.project.utils.ReqUtils;
import com.dt.project.utils.StrUtils;
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
     * 单据主表通用sql拼接字段
     *
     * @return
     */

    public static String docV() {
        return "bps.`supplier_full_name`, dep.`dept_name`,se.`employee_name` AS empName," +
                "se1.`employee_name` AS mangerName";
    }

    /**
     * 单据子表通用sql拼接字段
     *
     * @return
     */
    public static String docChildV() {
        return "bqiM.`inspection_quarantine_name`,bpp.`inspection_method_id`," +
                "bpp.`unit_id`,bpu.`unit_name`,bpp.`model`,bpp.`product_code`,bpw.`warehouse_name`,bpp.`product_name`";
    }

    /**
     * 通用存入sql部分状态
     */
    public static String setV() {

        return "`create_date`,`create_user`,`recording_id`";
    }

    /**
     * 通用删除
     */

    public static void del(String alias, SQL sql) {
        sql.WHERE(alias + ".`del_or_not`=0");
    }

    /**
     * 单据父表通用查询数据
     *
     * @param sql
     * @param alias
     * @param p
     */
    public static void setDocument(SQL sql, String alias, ParentDocument p) {
        sql.LEFT_OUTER_JOIN("hr_archives_department AS dep ON dep.`dept_id`=" + alias + ".`dept_id`");
        sql.LEFT_OUTER_JOIN("`hr_archives_employee` AS se ON se.`s_id` = " + alias + ".`emp_id`");
        sql.LEFT_OUTER_JOIN("`hr_archives_employee` AS se1 ON se1.`s_id` = " + alias + ".`manger_id`");
        sql.LEFT_OUTER_JOIN("`basic_purchase_supplier` AS bps ON bps.`supplier_id` = " + alias + ".`supplier_id`");
        //查询部门名称
        AppendSqlStore.sqlWhere(p.getDeptName(), "dep.`dept_name`", sql, Constants.SELECT,alias);
        //查询业务员
        AppendSqlStore.sqlWhere(p.getEmpName(), "se.`employee_name`", sql, Constants.SELECT,alias);
        //查询主管
        AppendSqlStore.sqlWhere(p.getMangerName(), "se1.`employee_name`", sql, Constants.SELECT,alias);
        //查询供应商
        AppendSqlStore.sqlWhere(p.getSupplierFullName(), "bps.`supplier_full_name`", sql, Constants.SELECT,alias);
    }

    /**
     * 单据子表通用查询数据
     *
     * @param sql
     * @param alias
     * @param p
     */
    public static void setDocumentChild(SQL sql, String alias, ParentDocumentChild p) {
        sql.LEFT_OUTER_JOIN("basic_public_product AS bpp on bpp.product_id = " + alias + ".`product_id`");
        sql.LEFT_OUTER_JOIN("basic_public_unit AS bpu on bpu.unit_id = bpp.`unit_id`");
        sql.LEFT_OUTER_JOIN("basic_quality_inspection_method AS bqiM on bqiM.inspection_method_id = bpp.`inspection_method_id`");
        sql.LEFT_OUTER_JOIN("basic_public_warehouse AS bpw on bpw.warehouse_id = " + alias + ".`warehouse_id`");
        sql.LEFT_OUTER_JOIN("basic_public_warehouse_position AS bpwP on bpwP.position_id = " + alias + ".`position_id`");
        //查询计量单位
        AppendSqlStore.sqlWhere(p.getUnitName(), "bpu.`unit_name`", sql, Constants.SELECT,alias);
        //查询产品名
        AppendSqlStore.sqlWhere(p.getProductName(), "bpp.`product_name`", sql, Constants.SELECT,alias);
        //查询产品代码
        AppendSqlStore.sqlWhere(p.getProductCode(), "bpp.`product_code`", sql, Constants.SELECT,alias);
        //查询规格型号
        AppendSqlStore.sqlWhere(p.getModel(), "bpp.`model`", sql, Constants.SELECT,alias);
        //查询仓库名
        AppendSqlStore.sqlWhere(p.getWarehouseName(), "bpw.`warehouse_name`", sql, Constants.SELECT,alias);
        //查询仓位
        AppendSqlStore.sqlWhere(p.getPositionName(), "bpwP.`position_name`", sql, Constants.SELECT,alias);
    }

    /**
     * 通用 查询 系统类状态
     *
     * @param logStatus
     * @param as
     * @param sql
     */
    public static void selectStatus(SystemLogStatus logStatus, String alias, SQL sql) {
        if (logStatus != null) {
            sql.LEFT_OUTER_JOIN("`system_log_status` AS ls ON ls.status_id=" + alias + ". `status_id`");
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
        sql.WHERE(alias + ".del_or_not=0");
    }

    /**
     * 设置 角色 链表查询
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
    public static void setStatus(SQL sql, ParentConfTable p) {
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
        setVersion(sql, version);
    }


    /**
     * ParentConfTable类型通用查询
     *
     * @param sql
     * @param p
     */
    public static void selectDocumentStatus(SQL sql, ParentConfTable p, String alias) {
        //备注
        if (StringUtils.isNotBlank(p.getRemark())) {
            sql.WHERE("POSITION('" + p.getRemark() + "' IN " + alias + ".`remark`)");
        }
        //状态
        if (p.getStatus() != null) {
            sql.WHERE(alias + ".status=#{status}");
        }
        //创建时间
        if (p.getCreateDates() != null && (p.getCreateDates().size() > 0)) {
            sql.WHERE(alias + ".create_date BETWEEN  " + p.getCreateDates().get(0) + " AND " + p.getCreateDates().get(1) + "");
        }
        //创建人
        if (StringUtils.isNotBlank(p.getCreateUser())) {
            sql.WHERE(alias + ".create_user=#{createUser}");
        }
        //修改日期
        if (p.getModifyDates() != null && (p.getModifyDates().size() > 0)) {
            sql.WHERE(alias + ".modify_date BETWEEN  " + p.getModifyDates().get(0) + " AND " + p.getModifyDates().get(1) + "");
        }
        //修改人
        if (StringUtils.isNotBlank(p.getModifyUser())) {
            sql.WHERE(alias + ".modify_user=#{modifyUser}");
        }
        //审核时间
        if (p.getAuditDates() != null && (p.getAuditDates().size() > 0)) {
            sql.WHERE(alias + ".audit_date BETWEEN  " + p.getAuditDates().get(0) + " AND " + p.getAuditDates().get(1) + "");
        }
        //审核人
        if (StringUtils.isNotBlank(p.getAuditUser())) {
            sql.WHERE(alias + ".audit_user=#{auditUser}");
        }

        //关闭时间
        if (p.getCreateDates() != null && (p.getCreateDates().size() > 0)) {
            sql.WHERE(alias + ".close_date BETWEEN  " + p.getCreateDates().get(0) + " AND " + p.getCreateDates().get(1) + "");
        }
        //关闭人
        if (StringUtils.isNotBlank(p.getCloseUser())) {
            sql.WHERE(alias + ".close_user=#{closeUser}");
        }

        sql.WHERE(alias + ".del_or_not=0");
    }


    /**
     * 通用查询 文件类 数据状态
     *
     * @param sql
     * @param p
     */
    public static void selectUploadStatus(SQL sql, ParentUploadInfo p, String alias) {
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
     * 上传文件通用 物理删除 更新 del_or_not=1
     */
    public static void uploadDel(SQL sql, String table, String alias, int version) {
        sql.UPDATE(table + " AS " + alias);
        sql.SET(alias + ".`del_or_not` = 1");
        sql.SET(alias + ".`modify_date` =" + new Date().getTime());
        sql.SET(alias + ".`modify_user` = " + "'" + ReqUtils.getUserName() + "'");
        setVersion(sql, version);
    }

    /**
     * 更新version
     *
     * @param sql
     * @param version
     */
    public static void setVersion(SQL sql, int version) {
        sql.SET("version=" + version + "+1");
        sql.WHERE("version=" + version);
    }
}
