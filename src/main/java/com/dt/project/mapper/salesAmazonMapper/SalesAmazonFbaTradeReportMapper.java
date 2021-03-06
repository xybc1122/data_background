package com.dt.project.mapper.salesAmazonMapper;

import com.dt.project.model.salesAmazon.SalesAmazonFbaTradeReport;
import com.dt.project.provider.SalesAmazonFbaTradeReportProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 订单报告表
 */
public interface SalesAmazonFbaTradeReportMapper {


    /**
     * 存入订单数据 txt
     *
     * @return
     */
    @InsertProvider(type = SalesAmazonFbaTradeReportProvider.class, method = "addInfo")
    int addSalesAmazonAdTrdList(@Param("trdList") List<SalesAmazonFbaTradeReport> trdList);


    /**
     * 通过站点店铺ID 跟订单号 查询 下单时间 站点 ID
     */
    @Select("SELECT`date`,`site_id`\n" +
            "FROM `sales_amazon_fba_trade_report`\n" +
            "WHERE shop_id = #{sId} AND amazon_order_id=#{oId} LIMIT 0,1")
    SalesAmazonFbaTradeReport getReport(@Param("sId") Integer sId, @Param("oId") String oId);


    /**
     * 查询订单报告数据
     */
    @SelectProvider(type = SalesAmazonFbaTradeReportProvider.class, method = "getRePortInfo")
    List<SalesAmazonFbaTradeReport> findByListOrderReport(SalesAmazonFbaTradeReport report);
}
