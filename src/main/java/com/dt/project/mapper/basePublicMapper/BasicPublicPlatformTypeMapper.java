package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.basePublic.BasicPublicPlatformType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicPublicPlatformTypeMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 16:24
 **/
public interface BasicPublicPlatformTypeMapper {

    /**
     * 查平台类型
     *
     * @return
     */
    @Select("SELECT\n" +
            "mt.`platform_type_id`,mt.`number`,mt.`platform_type_name`,\n" +
            "mt.`platform_type_name_eng`,mt.`status_id`,c.`country_name` \n" +
            "FROM `basic_public_platform_type` AS mt\n" +
            "LEFT JOIN `basic_public_country` AS c ON c.`country_id`=mt.`country_id`")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicPublicPlatformType> findByListPlatform();
}
