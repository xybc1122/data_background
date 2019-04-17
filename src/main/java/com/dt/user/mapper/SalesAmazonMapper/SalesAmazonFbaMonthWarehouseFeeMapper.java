package com.dt.user.mapper.SalesAmazonMapper;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaMonthWarehouseFee;
import com.dt.user.provider.SalesAmazonFbaMonthWarehouseFeeProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName SalesAmazonFbaMonthWarehouseFeeMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/17 9:47
 **/
public interface SalesAmazonFbaMonthWarehouseFeeMapper {

    /**
     * 存入月度仓储费用
     *
     * @return
     */
    @InsertProvider(type = SalesAmazonFbaMonthWarehouseFeeProvider.class, method = "addAmazonMonthWar")
    int saveAmazonMonthWar(@Param("mWarList") List<SalesAmazonFbaMonthWarehouseFee> mWarList);


}
