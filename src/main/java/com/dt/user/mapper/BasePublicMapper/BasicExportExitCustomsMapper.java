package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicExportExitCustoms;
import com.dt.user.model.BasePublicModel.BasicExportMonitoringCondition;
import com.dt.user.provider.BasicExportExitCustomsProvider;
import com.dt.user.provider.BasicExportMonitoringConditionProvider;
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
                            select = "com.dt.user.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicExportExitCustoms> findByExitCustomsList(BasicExportExitCustoms customs);

}
