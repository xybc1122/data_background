package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.parent.ParentTree;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BasicLogisticsmgtTransportAbnormalTypeMapper {


    /**
     * 异常类型
     *
     * @return
     */
    @Select("SELECT\n" +
            "`transport_abnormal_type_id`,`transport_abnormal_type_name`,\n" +
            " `parent_id`,`path`,`parent_node_is`\n" +
            "FROM `basic_logisticsmgt_transport_abnormal_type`")
    @Results({
            @Result(column = "transport_abnormal_type_id", property = "treeId"),
            @Result(column = "transport_abnormal_type_name", property = "treeName"),
    })
    List<ParentTree> findByListAbnormalType();

}
