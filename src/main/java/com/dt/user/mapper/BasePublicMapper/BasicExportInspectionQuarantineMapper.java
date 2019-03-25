package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicExportInspectionQuarantine;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicExportInspectionQuarantineMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 10:02
 **/
@Mapper
public interface BasicExportInspectionQuarantineMapper {


    /**
     * 查询检验检疫类别
     */
    @Select("SELECT\n" +
            "`inspection_quarantine_id`,\n" +
            "`c_number`,`inspection_quarantine_name`, `status_id`\n" +
            "FROM `basic_export_inspection_quarantine`")
    @Results({
            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicExportInspectionQuarantine> findByQuarantineInfo();



}
