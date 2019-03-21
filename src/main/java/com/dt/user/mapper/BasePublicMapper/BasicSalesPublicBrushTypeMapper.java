package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicSalesPublicBrushTypeMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/20 15:31
 **/
@Mapper
public interface BasicSalesPublicBrushTypeMapper {


    /**
     * 查询刷单类型
     */
//    @Select("SELECT\n" +
//            "`transport_type_id`,`number`,`transport_type_name`,\n" +
//            "`parent_id`,`transport_type_path`,`is_parent`,`status_id`\n" +
//            "FROM `basic_logisticsmgt_transport_type`")
//    @Results({
//            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
//            @Result(column = "status_id", property = "systemLogStatus",
//                    one = @One(
//                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
//                            fetchType = FetchType.EAGER
//                    )
//            )
//    })
//    List<BasicLogisticsmgtTransportType> findByTypeInfo();


}
