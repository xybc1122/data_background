package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.ParentTree;
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
            " `parent_id`,`path`,`is_parent`\n" +
            "FROM `basic_logisticsmgt_transport_abnormal_type`")
    @Results({
            @Result(column = "transport_abnormal_type_id", property = "treeId"),
            @Result(column = "transport_abnormal_type_name", property = "treeName"),
    })
    List<ParentTree> findByListAbnormalType();

}
