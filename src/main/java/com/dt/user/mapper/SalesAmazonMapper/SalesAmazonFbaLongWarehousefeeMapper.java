package com.dt.user.mapper.SalesAmazonMapper;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaLongWarehousefee;
import com.dt.user.model.SalesAmazon.SalesAmazonFbaMonthWarehouseFee;
import com.dt.user.provider.SalesAmazonFbaLongWarehousefeeProvider;
import com.dt.user.provider.SalesAmazonFbaMonthWarehouseFeeProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

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
    int saveAmazonLongWar(@Param("longWarList") List<SalesAmazonFbaLongWarehousefee> longWarList);


}
