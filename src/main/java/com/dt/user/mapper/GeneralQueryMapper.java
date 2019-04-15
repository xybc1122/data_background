package com.dt.user.mapper;


import com.dt.user.provider.GeneralQueryProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * @ClassName GeneralQueryMapper 通用查询Mapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/11 11:04
 **/
public interface GeneralQueryMapper {

    /**
     * 通用查询 statusId
     * @param sqlId  数据库表的ID
     * @param paramId 要查询的ID
     * @param table   要查询的表
     */
    @SelectProvider(type = GeneralQueryProvider.class, method = "findGeneralQueryPro")
    Long getStatusId(@Param("sqlId") String sqlId, @Param("paramId") Long paramId, @Param("table") String table);
}
