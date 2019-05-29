package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.basePublicModel.BasicSalesPublicBrushType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicSalesPublicBrushTypeMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/20 15:31
 **/
public interface BasicSalesPublicBrushTypeMapper {


    /**
     * 查询刷单类型
     */
    @Select("SELECT\n" +
            " `brush_type_id`,`number`,`brush_type_name`,`status_id`\n" +
            "FROM `basic_sales_public_brush_type`")
    @Results({
            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicSalesPublicBrushType> findByBrushTypeInfo();


}
