package com.dt.project.mapper.BasePublicMapper;

import com.dt.project.model.BasePublicModel.BasicSalesAmazonType;
import com.dt.project.provider.BasicSalesAmazonTypeProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicSalesAmazonTypeMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/20 10:41
 **/
public interface BasicSalesAmazonTypeMapper {


    /**
     * 查询亚马逊-订单类型'
     */
    @SelectProvider(type = BasicSalesAmazonTypeProvider.class, method = "findAmazonType")
    @Results({
            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicSalesAmazonType> findByListAmazonType(BasicSalesAmazonType amazonType);
}
