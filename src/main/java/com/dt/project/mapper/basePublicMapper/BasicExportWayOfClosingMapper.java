package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.basePublic.BasicExportWayOfClosing;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicExportWayOfClosingMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 10:30
 **/
public interface BasicExportWayOfClosingMapper {


    /**
     * 查询成交方式
     */
    @Select("SELECT\n" +
            "`way_of_closing_id`,\n" +
            "`c_number`,`way_of_closing_name`,`way_of_closing_shortname_eng`,\n" +
            "`way_of_closing_name_eng`,`status_id`\n" +
            "FROM `basic_export_way_of_closing`")
    @Results({
            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicExportWayOfClosing> findByWayOfInfo();
}
