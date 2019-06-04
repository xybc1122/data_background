package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.basePublic.BasicPublicWarehousePosition;

import java.util.List;

import com.dt.project.model.parent.ParentTree;
import com.dt.project.provider.BasicPublicWarehousePositionSqlProvider;
import org.apache.ibatis.annotations.*;

public interface BasicPublicWarehousePositionMapper {

    /**
     * 查询仓补树形结构
     *
     * @return
     */
    @Select("SELECT\n" +
            "`position_id`,`number`,`position_name`,`parent_id`," +
            "`position_address`,`path`,`parent_node_is` FROM `basic_public_warehouse_position`\n")
    @Results({
            @Result(column = "position_id", property = "treeId"),
            @Result(column = "position_name", property = "treeName"),
    })
    List<ParentTree> selectByWarehousePosition();


    @SelectProvider(type = BasicPublicWarehousePositionSqlProvider.class, method = "countByExample")
    int countByExample(BasicPublicWarehousePosition example);

    @DeleteProvider(type = BasicPublicWarehousePositionSqlProvider.class, method = "deleteByExample")
    int deleteByExample(BasicPublicWarehousePosition example);

    @Insert({
            "insert into basic_public_warehouse_position (position_id, number, ",
            "position_name, parent_id, ",
            "position_address, path, ",
            "parent_node_is, status_id, ",
            "version, del_or_not)",
            "values (#{positionId,jdbcType=BIGINT}, #{number,jdbcType=BIGINT}, ",
            "#{positionName,jdbcType=VARCHAR}, #{parentId,jdbcType=INTEGER}, ",
            "#{positionAddress,jdbcType=VARCHAR}, #{path,jdbcType=VARCHAR}, ",
            "#{parentNodeIs,jdbcType=BIT}, #{statusId,jdbcType=BIGINT}, ",
            "#{version,jdbcType=INTEGER}, #{delOrNot,jdbcType=BIT})"
    })
    int insert(BasicPublicWarehousePosition record);

    @InsertProvider(type = BasicPublicWarehousePositionSqlProvider.class, method = "insertSelective")
    int insertSelective(BasicPublicWarehousePosition record);

    @SelectProvider(type = BasicPublicWarehousePositionSqlProvider.class, method = "selectByExample")
    List<BasicPublicWarehousePosition> selectByExample(BasicPublicWarehousePosition example);

    @UpdateProvider(type = BasicPublicWarehousePositionSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BasicPublicWarehousePosition record, @Param("example") BasicPublicWarehousePosition example);

    @UpdateProvider(type = BasicPublicWarehousePositionSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") BasicPublicWarehousePosition record, @Param("example") BasicPublicWarehousePosition example);
}