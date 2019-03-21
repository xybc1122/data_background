package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportFreightLevel;
import com.dt.user.model.BasePublicModel.BasicPublicWarehouse;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicLogisticsmgtTransportFreightLevelMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 16:41
 **/
@Mapper
public interface BasicLogisticsmgtTransportFreightLevelMapper {
    /**
     * 查询运价等级
     */
    @Select("SELECT\n" +
            "`transport_freight_level_id`,`number`,\n" +
            "`transport_freight_level_name`,\n" +
            "`parent_id`,`transport_freight_level_path`,`is_parent`,`status_id`\n" +
            "FROM `basic_logisticsmgt_transport_freight_level`")
    @Results({
            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicLogisticsmgtTransportFreightLevel> findByFreightLevelInfo();
}
