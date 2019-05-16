package com.dt.project.mapper.BasePublicMapper;

import com.dt.project.model.BasePublicModel.BasicLogisticsmgtTransportProperty;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface BasicLogisticsmgtTransportPropertyMapper {



    /**
     * 查询运输性质
     *
     * @return
     */
    @Select("SELECT\n" +
            "`transport_property_id`,`number`,`transport_property_name`,`status_id`\n" +
            "FROM `basic_logisticsmgt_transport_property`")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicLogisticsmgtTransportProperty> findByListProperty();


}
