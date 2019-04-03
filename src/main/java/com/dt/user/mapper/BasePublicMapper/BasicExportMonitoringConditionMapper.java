package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.dto.SiteDto;
import com.dt.user.model.BasePublicModel.BasicExportMonitoringCondition;
import com.dt.user.provider.BasicExportMonitoringConditionProvider;
import com.dt.user.provider.BasicPublicSiteProvider;
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
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicExportMonitoringCondition> findByConditionList(BasicExportMonitoringCondition condition);

}
