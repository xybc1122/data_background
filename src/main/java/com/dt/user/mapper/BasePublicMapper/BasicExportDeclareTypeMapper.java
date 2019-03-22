package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicExportDeclareType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicExportDeclareTypeMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 13:16
 **/
@Mapper
public interface BasicExportDeclareTypeMapper {
    /**
     * 查询报关类型
     * @return
     */
    @Select("SELECT\n" +
            "`declare_type_id`,`number`,`declare_type_name`, `status_id`\n" +
            "FROM`basic_export_declare_type`")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicExportDeclareType> findByListDeclare();

}
