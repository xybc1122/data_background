package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.basePublic.BasicSalesAmazonHandlingClass;
import com.dt.project.provider.BasicSalesAmazonHandlingClassProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicSalesAmazonHandlingClassMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 16:31
 **/
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
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicSalesAmazonHandlingClass> findByListClass(BasicSalesAmazonHandlingClass handlingClass);


}
