package com.dt.user.mapper.BasePublicMapper;


import com.dt.user.model.ParentTree;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BasicPublicWarehouseMapper {


    /**
     * 查询仓库信息
     */
    @Select("SELECT`warehouse_id`,`path`,`warehouse_name`,parent_id,is_parent \n" +
            "FROM`basic_public_warehouse`")
    @Results({
            @Result(column = "warehouse_id", property = "treeId"),
            @Result(column = "warehouse_name", property = "treeName"),
    })
    List<ParentTree> findByWarehouseInfo();
}
