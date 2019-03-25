package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicExportModeOfTransport;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicExportModeOfTransportMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 9:33
 **/
@Mapper
public interface BasicExportModeOfTransportMapper {


    /**
     * 查询运输方式
     */
    @Select("SELECT\n" +
            "`mode_of_transport_id`,\n" +
            "`c_number`, `mode_of_transport_name`,\n" +
            "`mode_of_transport_name_eng`,`status_id`\n" +
            "FROM`basic_export_mode_of_transport`")
    @Results({
            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicExportModeOfTransport> findByModeOfInfo();
}
