package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportFreightLevel;
import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportValuationMethod;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicLogisticsmgtTransportValuationMethodMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 16:54
 **/
@Mapper
public interface BasicLogisticsmgtTransportValuationMethodMapper {

    /**
     * 查询计价类型
     */
    @Select("SELECT\n" +
            "`transport_valuation_method_id`,\n" +
            "`number`,`transport_valuation_method_name`,`parent_id`,\n" +
            "`transport_valuation_method_path`,\n" +
            "`is_parent`,`status_id`\n" +
            "FROM`basic_logisticsmgt_transport_valuation_method`")
    @Results({
            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicLogisticsmgtTransportValuationMethod> findByValuationMethodInfo();
}
