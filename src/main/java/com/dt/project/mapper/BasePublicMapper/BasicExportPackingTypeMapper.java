package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.basePublicModel.BasicExportPackingType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicExportPackingTypeMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 8:45
 **/
public interface BasicExportPackingTypeMapper {


    /**
     * 查询包装种类
     */
    @Select("SELECT\n" +
            "`packing_type_id`,`c_number`,`packing_type_name`,`status_id`\n" +
            "FROM `basic_export_packing_type`")
    @Results({
            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicExportPackingType> findByPackingTypeInfo();


}
