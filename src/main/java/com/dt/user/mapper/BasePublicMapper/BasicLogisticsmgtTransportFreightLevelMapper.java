package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportFreightLevel;
import com.dt.user.model.BasePublicModel.BasicPublicWarehouse;
import com.dt.user.model.ParentTree;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicLogisticsmgtTransportFreightLevelMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 16:41
 **/
public interface BasicLogisticsmgtTransportFreightLevelMapper {
    /**
     * 查询运价等级
     */
    @Select("SELECT\n" +
            "`transport_freight_level_id`,\n" +
            "`transport_freight_level_name`,\n" +
            "`parent_id`,`path`,`is_parent`\n" +
            "FROM `basic_logisticsmgt_transport_freight_level`")
    @Results({
            @Result(column = "transport_freight_level_id", property = "treeId"),
            @Result(column = "transport_freight_level_name", property = "treeName"),
    })
    List<ParentTree> findByFreightLevelInfo();
}
