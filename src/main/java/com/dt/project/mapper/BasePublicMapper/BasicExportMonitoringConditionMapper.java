package com.dt.project.mapper.basePublicMapper;

import com.dt.project.model.basePublicModel.BasicExportMonitoringCondition;
import com.dt.project.provider.BasicExportMonitoringConditionProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @ClassName BasicExportMonitoringConditionMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 9:00
 **/
public interface BasicExportMonitoringConditionMapper {

    /**
     * 查询监管方式
     */
    @SelectProvider(type = BasicExportMonitoringConditionProvider.class, method = "findMonitoring")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.systemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicExportMonitoringCondition> findByConditionList(BasicExportMonitoringCondition condition);

}
