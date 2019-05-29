package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.basePublicModel.BasicHrNation;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicHrNationMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 13:51
 **/
public interface BasicHrNationMapper {


    /**
     * 查看民族
     *
     * @return
     */
    @Select("SELECT\n" +
            "`nation_id`,`number`,`nation`, `status_id`\n" +
            "FROM `basic_hr_nation`")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicHrNation> findByListHrNation();


}
