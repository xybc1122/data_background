package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicHrEmployeeType;
import com.dt.user.model.BasePublicModel.BasicHrEmploymentType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicHrEmploymentTypeMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 14:25
 **/
public interface BasicHrEmploymentTypeMapper {


    /**
     * 查看雇佣类型
     *
     * @return
     */
    @Select("SELECT\n" +
            "`employment_type_id`,\n" +
            "`number`,`employment_type_name`\n" +
            "FROM`basic_hr_employment_type`")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicHrEmploymentType> findByListHrEmployment();
}
