package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicSalesAmazonHandlingClass;
import com.dt.user.provider.BasicSalesAmazonDescriptionProvider;
import com.dt.user.provider.BasicSalesAmazonHandlingClassProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicSalesAmazonHandlingClassMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 16:31
 **/
@Mapper
public interface BasicSalesAmazonHandlingClassMapper {


    /**
     * 查询订单处理类
     *
     * @return
     */
    @SelectProvider(type = BasicSalesAmazonHandlingClassProvider.class, method = "getHandlingClass")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicSalesAmazonHandlingClass> findByListClass(BasicSalesAmazonHandlingClass handlingClass);


}
