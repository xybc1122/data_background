package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicPublicUnit;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface BasicPublicUnitMapper {

    /**
     * 查询计量单位
     *
     * @return
     */
    @Select("SELECT\n" +
            "`unit_id`,`number`, `unit_name`,\n" +
            "`parent_id`, `unit_name_eng`,`unit_name_eng_s`,\n" +
            "`unit_short_name_eng`,`is_parent`,`status_id`\n" +
            "FROM `basic_public_unit`")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicPublicUnit> findByListUnit();

}
