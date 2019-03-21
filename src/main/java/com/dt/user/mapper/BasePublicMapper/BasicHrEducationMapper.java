package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicHrEducation;
import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportAbnormalType;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicHrEducationMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 14:24
 **/
@Mapper
public interface BasicHrEducationMapper {

    /**
     * 查看学历
     *
     * @return
     */
    @Select("SELECT\n" +
            "`education_id`,`number`,\n" +
            "`education_name`, `education_name_eng`,`status_id`\n" +
            " FROM `basic_hr_education`")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicHrEducation> findByListHrEdu();
}
