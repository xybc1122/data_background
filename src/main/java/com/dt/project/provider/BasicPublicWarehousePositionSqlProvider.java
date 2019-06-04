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

import com.dt.project.model.basePublic.BasicPublicWarehousePosition;
import java.util.Map;

public class BasicPublicWarehousePositionSqlProvider {

    public String countByExample(BasicPublicWarehousePosition example) {
        BEGIN();
        SELECT("count(*)");
        FROM("basic_public_warehouse_position");

        return SQL();
    }

    public String deleteByExample(BasicPublicWarehousePosition example) {
        BEGIN();
        DELETE_FROM("basic_public_warehouse_position");
        return SQL();
    }

    public String insertSelective(BasicPublicWarehousePosition record) {
        BEGIN();
        INSERT_INTO("basic_public_warehouse_position");
//
//        if (record.getPositionId() != null) {
//            VALUES("position_id", "#{positionId,jdbcType=BIGINT}");
//        }
//
        if (record.getNumber() != null) {
            VALUES("number", "#{number,jdbcType=BIGINT}");
        }
//
//        if (record.getPositionName() != null) {
//            VALUES("position_name", "#{positionName,jdbcType=VARCHAR}");
//        }
//
        if (record.getParentId() != null) {
            VALUES("parent_id", "#{parentId,jdbcType=INTEGER}");
        }
        
        if (record.getPositionAddress() != null) {
            VALUES("position_address", "#{positionAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            VALUES("path", "#{path,jdbcType=VARCHAR}");
        }
        
        if (record.getParentNodeIs() != null) {
            VALUES("parent_node_is", "#{parentNodeIs,jdbcType=BIT}");
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

    public String selectByExample(BasicPublicWarehousePosition example) {

        SELECT("number");
        SELECT("position_name");
        SELECT("parent_id");
        SELECT("position_address");
        SELECT("path");
        SELECT("parent_node_is");
        SELECT("status_id");
        SELECT("version");
        SELECT("del_or_not");
        FROM("basic_public_warehouse_position");

        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        BasicPublicWarehousePosition record = (BasicPublicWarehousePosition) parameter.get("record");

        
        BEGIN();
        UPDATE("basic_public_warehouse_position");
        
//        if (record.getPositionId() != null) {
//            SET("position_id = #{record.positionId,jdbcType=BIGINT}");
//        }
//
        if (record.getNumber() != null) {
            SET("number = #{record.number,jdbcType=BIGINT}");
        }
//
//        if (record.getPositionName() != null) {
//            SET("position_name = #{record.positionName,jdbcType=VARCHAR}");
//        }
//
        if (record.getParentId() != null) {
            SET("parent_id = #{record.parentId,jdbcType=INTEGER}");
        }
        
        if (record.getPositionAddress() != null) {
            SET("position_address = #{record.positionAddress,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            SET("path = #{record.path,jdbcType=VARCHAR}");
        }
        
        if (record.getParentNodeIs() != null) {
            SET("parent_node_is = #{record.parentNodeIs,jdbcType=BIT}");
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
        UPDATE("basic_public_warehouse_position");
        
        SET("position_id = #{record.positionId,jdbcType=BIGINT}");
        SET("number = #{record.number,jdbcType=BIGINT}");
        SET("position_name = #{record.positionName,jdbcType=VARCHAR}");
        SET("parent_id = #{record.parentId,jdbcType=INTEGER}");
        SET("position_address = #{record.positionAddress,jdbcType=VARCHAR}");
        SET("path = #{record.path,jdbcType=VARCHAR}");
        SET("parent_node_is = #{record.parentNodeIs,jdbcType=BIT}");
        SET("status_id = #{record.statusId,jdbcType=BIGINT}");
        SET("version = #{record.version,jdbcType=INTEGER}");
        SET("del_or_not = #{record.delOrNot,jdbcType=BIT}");

        return SQL();
    }
}