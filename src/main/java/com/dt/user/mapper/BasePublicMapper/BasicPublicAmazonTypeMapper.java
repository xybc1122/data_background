package com.dt.user.mapper.BasePublicMapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BasicPublicAmazonTypeMapper {
    /**
     * 查询type中文名称
     * @param site_id
     * @param type
     * @return
     */
    @Select("SELECT `order_type_name`\n" +
            "FROM `basic_sales_amazon_type`\n" +
            "WHERE site_id =#{siteId} AND order_type=#{type}\n")
    String getTypeName(@Param("siteId") Integer siteId, @Param("type") String type);
}
