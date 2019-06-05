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

    public String insertSelective(WarehouseIncArriveConfirm record) {
        BEGIN();
        INSERT_INTO("warehouse_inc_arrive_confirm");

        if (record.getAcId() != null) {
            VALUES("ac_id", "#{acId,jdbcType=BIGINT}");
        }

        if (record.getDate() != null) {
            VALUES("date", "#{date,jdbcType=BIGINT}");
        }

        if (record.getNo() != null) {
            VALUES("no", "#{no,jdbcType=VARCHAR}");
        }

        if (record.getExplanation() != null) {
            VALUES("explanation", "#{explanation,jdbcType=VARCHAR}");
        }

        if (record.getDeptId() != null) {
            VALUES("dept_id", "#{deptId,jdbcType=INTEGER}");
        }

        if (record.getEmpId() != null) {
            VALUES("emp_id", "#{empId,jdbcType=INTEGER}");
        }

        if (record.getMangerId() != null) {
            VALUES("manger_id", "#{mangerId,jdbcType=INTEGER}");
        }

        if (record.getChildren() != null) {
            VALUES("children", "#{children,jdbcType=BIT}");
        }

        if (record.getClosed() != null) {
            VALUES("closed", "#{closed,jdbcType=INTEGER}");
        }

        if (record.getCloseUser() != null) {
            VALUES("close_user", "#{closeUser,jdbcType=VARCHAR}");
        }

        if (record.getCloseDate() != null) {
            VALUES("close_date", "#{closeDate,jdbcType=BIGINT}");
        }

        if (record.getOrderConfirm() != null) {
            VALUES("order_confirm", "#{orderConfirm,jdbcType=INTEGER}");
        }

        if (record.getStatusId() != null) {
            VALUES("status_id", "#{statusId,jdbcType=BIGINT}");
        }

        if (record.getVersion() != null) {
            VALUES("version", "#{version,jdbcType=INTEGER}");
        }

        if (record.getDelOrNot() != null) {
            VALUES("del_or_not", "#{delOrNot,jdbcType=BIT}");
        }

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
        AppendSqlStore.sqlWhere(record.getDeptName(), "dep.`dept_name`", sql, Constants.SELECT);
        //查询业务员
        AppendSqlStore.sqlWhere(record.getEmpName(), "se.`employee_name`", sql, Constants.SELECT);
        //查询主管
        AppendSqlStore.sqlWhere(record.getMangerName(), "se1.`employee_name`", sql, Constants.SELECT);


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

        if (record.getNo() != null) {
            SET("no = #{record.no,jdbcType=VARCHAR}");
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

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("warehouse_inc_arrive_confirm");

        SET("ac_id = #{record.acId,jdbcType=BIGINT}");
        SET("date = #{record.date,jdbcType=BIGINT}");
        SET("no = #{record.no,jdbcType=VARCHAR}");
        SET("explanation = #{record.explanation,jdbcType=VARCHAR}");
        SET("dept_id = #{record.deptId,jdbcType=INTEGER}");
        SET("emp_id = #{record.empId,jdbcType=INTEGER}");
        SET("manger_id = #{record.mangerId,jdbcType=INTEGER}");
        SET("children = #{record.children,jdbcType=BIT}");
        SET("closed = #{record.closed,jdbcType=INTEGER}");
        SET("close_user = #{record.closeUser,jdbcType=VARCHAR}");
        SET("close_date = #{record.closeDate,jdbcType=BIGINT}");
        SET("order_confirm = #{record.orderConfirm,jdbcType=INTEGER}");
        SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");


        return SQL();
    }

}