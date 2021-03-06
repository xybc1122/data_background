package com.dt.project.mapper.salesAmazonMapper;

import com.dt.project.model.salesAmazon.SalesAmazonFbaMonthWarehouseFee;
import com.dt.project.provider.SalesAmazonFbaMonthWarehouseFeeProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

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

    /**
     * 查询月度仓库费用数据
     */
    @SelectProvider(type = SalesAmazonFbaMonthWarehouseFeeProvider.class, method = "getMWarInfo")
    List<SalesAmazonFbaMonthWarehouseFee> findByListMWar(SalesAmazonFbaMonthWarehouseFee mWar);

}
