package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportAbnormalType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface BasicLogisticsmgtTransportAbnormalTypeMapper {


    /**
     * 异常类型
     *
     * @return
     */
    @Select("SELECT\n" +
            "  `transport_abnormal_type_id`,`number`,`transport_abnormal_type_name`,\n" +
            "  `parent_id`,`transport_abnormal_type_path`,`is_parent`,status_id\n" +
            "FROM `basic_logisticsmgt_transport_abnormal_type`")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicLogisticsmgtTransportAbnormalType> findByListAbnormalType();

}
