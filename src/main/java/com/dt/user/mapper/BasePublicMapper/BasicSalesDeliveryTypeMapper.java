package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.dto.AreaDto;
import com.dt.user.model.BasePublicModel.BasicSalesDeliveryType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicSalesDeliveryTypeMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/20 13:17
 **/
public interface BasicSalesDeliveryTypeMapper {


    /**
     * 查询发货方式
     *
     * @return
     */
    @Select("SELECT\n" +
            "`delivery_type_id`,\n" +
            "`number`,`delivery_type_name`,`delivery_type_eng`,`status_id`\n" +
            "FROM `basic_sales_delivery_type`")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicSalesDeliveryType> findByListDeliveryType();
}
