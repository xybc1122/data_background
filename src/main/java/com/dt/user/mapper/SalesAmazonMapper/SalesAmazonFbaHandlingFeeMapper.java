package com.dt.user.mapper.SalesAmazonMapper;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaHandlingFee;
import com.dt.user.provider.SalesAmazonFbaHandlingFeeProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName SalesAmazonFbaHandlingFeeMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/18 9:20
 **/
public interface SalesAmazonFbaHandlingFeeMapper {

    /**
     * 存入订单处理费
     *
     * @return
     */
    @InsertProvider(type = SalesAmazonFbaHandlingFeeProvider.class, method = "addAmazonHandLFee")
    int saveAmazonHandLFee(@Param("hLFeeList") List<SalesAmazonFbaHandlingFee> hLFeeList);

    /**
     * 查询是否有文件在里面
     */
    @Select("SELECT `hd_id` FROM `sales_amazon_fba_handlingfee` WHERE shop_id=#{shopId} AND" +
            " site_id=#{siteId} AND sku_id=#{skuId} AND effective_date=#{effectiveDate} LIMIT 0,1")
    Long getExists(SalesAmazonFbaHandlingFee fee);

}
