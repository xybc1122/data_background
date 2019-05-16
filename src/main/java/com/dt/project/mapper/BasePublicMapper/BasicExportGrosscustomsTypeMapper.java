package com.dt.project.mapper.BasePublicMapper;

import com.dt.project.model.BasePublicModel.BasicExportGrosscustomsType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicExportGrosscustomsTypeMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 13:23
 **/
public interface BasicExportGrosscustomsTypeMapper {
    /**
     * 查询清关类型
     * @return
     */
    @Select("SELECT\n" +
            "`grosscustoms_type_id`,`number`,`grosscustoms_type_name`,`status_id`\n" +
            "FROM`basic_export_grosscustoms_type`")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicExportGrosscustomsType> findByListGrosscustoms();

}
