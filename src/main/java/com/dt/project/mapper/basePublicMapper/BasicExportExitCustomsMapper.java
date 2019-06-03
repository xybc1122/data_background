package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.basePublic.BasicExportExitCustoms;
import com.dt.project.provider.BasicExportExitCustomsProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicExportExitCustomsMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 10:48
 **/
public interface BasicExportExitCustomsMapper {

    /**
     * 查询出口管理-出境口岸
     */
    @SelectProvider(type = BasicExportExitCustomsProvider.class, method = "findExitCustoms")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicExportExitCustoms> findByExitCustomsList(BasicExportExitCustoms customs);

}
