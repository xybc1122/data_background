package com.dt.project.mapper.BasePublicMapper;

import com.dt.project.model.Parent.ParentTree;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BasicLogisticsmgtTransportTypeMapper {


    /**
     * 查询运输类型
     */
    @Select("SELECT\n" +
            "`transport_type_id`,`path`,`transport_type_name`,\n" +
            "`parent_id`,`parent_node_is`\n" +
            "FROM `basic_logisticsmgt_transport_type`")
    @Results({
            @Result(column = "transport_type_id", property = "treeId"),
            @Result(column = "transport_type_name", property = "treeName"),
    })
    List<ParentTree> findByTypeInfo();


}
