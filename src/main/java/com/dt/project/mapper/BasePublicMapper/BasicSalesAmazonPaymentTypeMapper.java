package com.dt.project.mapper.BasePublicMapper;

import com.dt.project.model.BasePublicModel.BasicSalesAmazonPaymentType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicSalesAmazonPaymentTypeMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 16:09
 **/
public interface BasicSalesAmazonPaymentTypeMapper {

    /**
     * 付款类型
     *
     * @return
     */
    @Select("SELECT\n" +
            "`payment_type_id`,\n" +
            "`number`, `payment_type_name`,`payment_type_name_eng`,status_id\n" +
            "FROM `basic_sales_amazon_payment_type`\n")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicSalesAmazonPaymentType> findByListPayType();

}
