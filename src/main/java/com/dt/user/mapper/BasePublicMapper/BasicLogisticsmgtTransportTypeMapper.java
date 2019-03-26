package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.ParentTree;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BasicLogisticsmgtTransportTypeMapper {


    /**
     * 查询运输类型
     */
    @Select("SELECT\n" +
            "`transport_type_id`,`path`,`transport_type_name`,\n" +
            "`parent_id`,`transport_type_path`,`is_parent`\n" +
            "FROM `basic_logisticsmgt_transport_type`")
    @Results({
            @Result(column = "transport_type_id", property = "treeId"),
            @Result(column = "transport_type_name", property = "treeName"),
    })
    List<ParentTree> findByTypeInfo();


}
