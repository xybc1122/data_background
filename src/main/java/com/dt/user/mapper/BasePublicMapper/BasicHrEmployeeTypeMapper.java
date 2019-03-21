package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicHrEducation;
import com.dt.user.model.BasePublicModel.BasicHrEmployeeType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicHrEmployeeTypeMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 14:24
 **/
@Mapper
public interface BasicHrEmployeeTypeMapper {

    /**
     * 查看员工类型
     *
     * @return
     */
    @Select("SELECT\n" +
            "`employee_type_id`,`number`,\n" +
            "`employee_type_name`,`status_id`\n" +
            "FROM `basic_hr_employee_type`\n")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicHrEmployeeType> findByListHrEmp();

}
