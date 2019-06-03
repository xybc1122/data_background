package com.dt.project.mapper.basePublicMapper;


import com.dt.project.model.basePublic.BasicPublicWarehouse;
import com.dt.project.model.parent.ParentTree;
import com.dt.project.provider.WarehouseInfoProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BasicPublicWarehouseMapper {


    /**
     * 查询仓库信息
     */
    @Select("SELECT`warehouse_id`,`path`,`warehouse_name`,parent_id,parent_node_is,status_id \n" +
            "FROM `basic_public_warehouse` where del_or_not=0")
    @Results({
            @Result(column = "warehouse_id", property = "treeId"),
            @Result(column = "warehouse_name", property = "treeName"),
    })
    List<ParentTree> findByWarehouseInfo();


    /**
     * 更新仓库信息
     */
    @UpdateProvider(type = WarehouseInfoProvider.class, method = "upWarehousePro")
    int upWarehouses(BasicPublicWarehouse war);

    /**
     * 批量删除数据/更新
     */
    @UpdateProvider(type = WarehouseInfoProvider.class, method = "delWarehousePro")
    int delWarehouses(@Param("thisIds") String thisIds);

    /**
     * 新增仓库数据
     */
    @Insert("INSERT INTO `basic_public_warehouse`(`number`,`warehouse_name`,`parent_id`, " +
            "`warehouse_address`,`path`,`parent_node_is`,`status_id`)" +
            "VALUES (#{number}, #{treeName}," +
            " #{parentId},#{warehouseAddress},\n" +
            "#{path},#{parentNodeIs},#{statusId} )")
    int saveWarehouses(BasicPublicWarehouse war);

}
