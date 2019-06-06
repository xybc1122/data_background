package com.dt.project.provider;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;

import com.dt.project.model.warehouse.WarehouseIncArriveConfirm;
import com.dt.project.store.AppendSqlStore;
import com.dt.project.toos.Constants;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

public class WarehouseIncArriveConfirmSqlProvider {

    public String countByExample(WarehouseIncArriveConfirm example) {
        BEGIN();
        SELECT("count(*)");
        FROM("warehouse_inc_arrive_confirm");
        return SQL();
    }

    public String deleteByExample(WarehouseIncArriveConfirm example) {
        BEGIN();
        DELETE_FROM("warehouse_inc_arrive_confirm");
        return SQL();
    }


    public String selectByWarIncArrive(WarehouseIncArriveConfirm record) {
        SQL sql = new SQL();
        String alias = "wiaC";
        sql.SELECT(" `ac_id`," + alias + ".`date`,`no`,\n" +
                "`explanation`," + alias + ".`dept_id`," + alias + ".`emp_id`," + alias + ".`manger_id`,`children`,\n" +
                "`closed`,`close_user`,`close_date`,`order_confirm`,\n" +
                "" + alias + ".`status_id`," + alias + ".`version`\n" +
                "FROM `warehouse_inc_arrive_confirm` AS " + alias + "");
        sql.LEFT_OUTER_JOIN("`hr_archives_department` AS dep ON dep.`dept_id`=" + alias + ".`dept_id`");
        sql.LEFT_OUTER_JOIN("`hr_archives_employee` AS se ON se.`s_id` = " + alias + ".`emp_id`");
        sql.LEFT_OUTER_JOIN("`hr_archives_employee` AS se1 ON se1.`s_id` = " + alias + ".`manger_id`");
        //查询部门名称
        AppendSqlStore.sqlWhere(record.getDeptName(), "dep.`dept_name`", sql, Constants.SELECT,alias);
        //查询业务员
        AppendSqlStore.sqlWhere(record.getEmpName(), "se.`employee_name`", sql, Constants.SELECT,alias);
        //查询主管
        AppendSqlStore.sqlWhere(record.getMangerName(), "se1.`employee_name`", sql, Constants.SELECT,alias);


        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        WarehouseIncArriveConfirm record = (WarehouseIncArriveConfirm) parameter.get("record");


        BEGIN();
        UPDATE("warehouse_inc_arrive_confirm");

        if (record.getAcId() != null) {
            SET("ac_id = #{record.acId,jdbcType=BIGINT}");
        }

        if (record.getDate() != null) {
            SET("date = #{record.date,jdbcType=BIGINT}");
        }

        if (record.getAcNo() != null) {
            SET("no = #{acNo,jdbcType=VARCHAR}");
        }

        if (record.getExplanation() != null) {
            SET("explanation = #{record.explanation,jdbcType=VARCHAR}");
        }

        if (record.getDeptId() != null) {
            SET("dept_id = #{record.deptId,jdbcType=INTEGER}");
        }

        if (record.getEmpId() != null) {
            SET("emp_id = #{record.empId,jdbcType=INTEGER}");
        }

        if (record.getMangerId() != null) {
            SET("manger_id = #{record.mangerId,jdbcType=INTEGER}");
        }

        if (record.getChildren() != null) {
            SET("children = #{record.children,jdbcType=BIT}");
        }

        if (record.getClosed() != null) {
            SET("closed = #{record.closed,jdbcType=INTEGER}");
        }

        if (record.getCloseUser() != null) {
            SET("close_user = #{record.closeUser,jdbcType=VARCHAR}");
        }

        if (record.getCloseDate() != null) {
            SET("close_date = #{record.closeDate,jdbcType=BIGINT}");
        }

        if (record.getOrderConfirm() != null) {
            SET("order_confirm = #{record.orderConfirm,jdbcType=INTEGER}");
        }

        if (record.getStatusId() != null) {
            SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        }

        if (record.getVersion() != null) {
            SET("version = #{record.version,jdbcType=INTEGER}");
        }

        if (record.getDelOrNot() != null) {
            SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");
        }


        return SQL();
    }


}