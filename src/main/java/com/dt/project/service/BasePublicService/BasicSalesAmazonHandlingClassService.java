package com.dt.project.service.BasePublicService;

import com.dt.project.model.BasePublicModel.BasicSalesAmazonHandlingClass;

import java.util.List;

/**
 * @ClassName BasicSalesAmazonHandlingClassService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 16:34
 **/
public interface BasicSalesAmazonHandlingClassService {
    /**
     * 查询订单处理类
     *
     * @return
     */
    List<BasicSalesAmazonHandlingClass> serviceFindByListClass(BasicSalesAmazonHandlingClass handlingClass);
}
