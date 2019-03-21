package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicSalesAmazonWarehouse;
import com.dt.user.provider.BasicSalesAmazonWarehouseProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface BasicSalesAmazonWarehouseMapper {

    /**
     * 通过fc 查找站点ID 仓库id
     *
     * @return
     */
    @Select("SELECT\n" +
            "amazon_warehouse_id,`site_id`\n" +
            "FROM `basic_sales_amazon_warehouse`\n" +
            "WHERE warehouse_code=#{fc}\n" +
            "LIMIT 0 ,1\n")
    BasicSalesAmazonWarehouse getWarehouse(@Param("fc") String fc);

    /**
     * 查询亚马逊-亚马逊仓库'
     */
    @SelectProvider(type = BasicSalesAmazonWarehouseProvider.class, method = "findAmazonWarehouse")
    @Results({
            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicSalesAmazonWarehouse> findByListAmazonWarehouse(BasicSalesAmazonWarehouse warehouse);

}
