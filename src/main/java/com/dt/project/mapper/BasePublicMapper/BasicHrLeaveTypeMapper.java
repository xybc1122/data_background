package com.dt.project.mapper.BasePublicMapper;

import com.dt.project.model.BasePublicModel.BasicHrLeaveType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicHrLeaveTypeMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 14:25
 **/
public interface BasicHrLeaveTypeMapper {

    /**
     * 查看离职类型
     *
     * @return
     */
    @Select("SELECT\n" +
            "`leave_type_id`,\n" +
            "`number`,`leave_type_name`\n" +
            "FROM `basic_hr_leave_type`")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicHrLeaveType> findByListHrLeave();

}
