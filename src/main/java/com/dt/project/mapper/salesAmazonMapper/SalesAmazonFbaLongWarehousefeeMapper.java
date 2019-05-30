package com.dt.project.mapper.salesAmazonMapper;

import com.dt.project.model.salesAmazon.SalesAmazonFbaLongWarehouseFee;
import com.dt.project.provider.SalesAmazonFbaLongWarehousefeeProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName SalesAmazonFbaLongWarehousefeeMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/9 15:53
 **/
public interface SalesAmazonFbaLongWarehousefeeMapper {


    /**
     * 存入长期仓库费
     *
     * @return
     */
    @InsertProvider(type = SalesAmazonFbaLongWarehousefeeProvider.class, method = "saveAmazonLongWarList")
    int saveAmazonLongWar(@Param("longWarList") List<SalesAmazonFbaLongWarehouseFee> longWarList);

    /**
     * 查询场地仓库费
     *
     * @param fee
     * @return
     */
    @SelectProvider(type = SalesAmazonFbaLongWarehousefeeProvider.class, method = "selectByLongWarehouseFee")
    List<SalesAmazonFbaLongWarehouseFee> selectByLongWarehouse(SalesAmazonFbaLongWarehouseFee fee);

}
