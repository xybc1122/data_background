package com.dt.user.mapper.BasePublicMapper;

import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportCompany;
import com.dt.user.provider.BasicLogisticsmgtTransportCompanyProvider;
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
                            select = "com.dt.user.mapper.SystemMapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<BasicLogisticsmgtTransportCompany> findByListFreight(BasicLogisticsmgtTransportCompany company);

}
