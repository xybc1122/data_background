package com.dt.project.mapper.BasePublicMapper;

import com.dt.project.model.BasePublicModel.BasicLogisticsmgtTransportCompany;
import com.dt.project.provider.BasicLogisticsmgtTransportCompanyProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface BasicLogisticsmgtTransportCompanyMapper {

    /**
     * 查询货运公司
     *
     * @return
     */
    @SelectProvider(type = BasicLogisticsmgtTransportCompanyProvider.class, method = "findFreight")
    @Results({
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.project.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicLogisticsmgtTransportCompany> findByListFreight(BasicLogisticsmgtTransportCompany company);

}