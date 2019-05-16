package com.dt.project.mapper.BasePublicMapper;

import com.dt.project.model.BasePublicModel.BasicSalesPublicStarlevel;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicSalesPublicStarlevelMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/20 13:36
 **/
public interface BasicSalesPublicStarlevelMapper {


    /**
     * 查询星级
     *
     * @return
     */
    @Select("SELECT\n" +
            "`star_level_id`,`number`,`star_level_name`,`status_id`\n" +
            "FROM `basic_sales_public_starlevel`")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicSalesPublicStarlevel> findByListStarlevel();
}
