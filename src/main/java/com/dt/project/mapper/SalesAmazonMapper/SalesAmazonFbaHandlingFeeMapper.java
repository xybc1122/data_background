package com.dt.project.mapper.salesAmazonMapper;

import com.dt.project.model.salesAmazon.SalesAmazonFbaHandlingFee;
import com.dt.project.provider.SalesAmazonFbaHandlingFeeProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

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


    /**
     * 查询订单处理费
     *
     * @param hFee
     * @return
     */
    @SelectProvider(type = SalesAmazonFbaHandlingFeeProvider.class, method = "selectByHFee")
    List<SalesAmazonFbaHandlingFee> selectByHandLFee(SalesAmazonFbaHandlingFee hFee);


}
