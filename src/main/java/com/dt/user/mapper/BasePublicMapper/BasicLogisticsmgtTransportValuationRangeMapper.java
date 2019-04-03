package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportValuationRange;
import com.dt.user.model.BasePublicModel.BasicPublicPlatformType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicLogisticsmgtTransportValuationRangeMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 9:36
 **/
public interface BasicLogisticsmgtTransportValuationRangeMapper {


    /**
     * 查询 计价范围
     *
     * @return
     */
    @Select("SELECT\n" +
            "r.`transport_valuation_range_id`,\n" +
            "r.`number`,r.`transport_valuation_range_name`,r.`status_id`,\n" +
            "m.`transport_valuation_method_name`\n" +
            "FROM `basic_logisticsmgt_transport_valuation_range` AS r\n" +
            "LEFT JOIN `basic_logisticsmgt_transport_valuation_method` AS m \n" +
            "ON m.`transport_valuation_method_id` =r.`transport_valuation_method_id`")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicLogisticsmgtTransportValuationRange> findByListValuationRange();


}
