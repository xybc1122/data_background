package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.basePublicModel.BasicHrEducation;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicHrEducationMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 14:24
 **/
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
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicHrEducation> findByListHrEdu();
}
