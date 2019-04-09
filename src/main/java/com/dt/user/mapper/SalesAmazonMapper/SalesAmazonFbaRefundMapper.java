package com.dt.user.mapper.SalesAmazonMapper;

import com.dt.user.model.SalesAmazon.SalesAmazonFbaRefund;
import com.dt.user.provider.SalesAmazonFbaRefundProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;


public interface SalesAmazonFbaRefundMapper {



    /**
     * 存入退货数据
     *
     * @return
     */
    @InsertProvider(type = SalesAmazonFbaRefundProvider.class, method = "addRefund")
    int AddSalesAmazonAdRefundList(@Param("refundList") List<SalesAmazonFbaRefund> refundList);


    /**
     * 查询退货报告数据
     */
    @SelectProvider(type = SalesAmazonFbaRefundProvider.class, method = "getRefundInfo")
    List<SalesAmazonFbaRefund> findByListRefund(SalesAmazonFbaRefund report);

}
