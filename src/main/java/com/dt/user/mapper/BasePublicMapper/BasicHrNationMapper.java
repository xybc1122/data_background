package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicHrLeaveType;
import com.dt.user.model.BasePublicModel.BasicHrNation;
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
                            select = "com.dt.user.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicHrNation> findByListHrNation();


}
