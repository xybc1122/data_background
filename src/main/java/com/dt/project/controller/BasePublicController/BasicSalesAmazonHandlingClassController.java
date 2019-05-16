package com.dt.project.controller.BasePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.BasePublicModel.BasicSalesAmazonHandlingClass;
import com.dt.project.service.BasePublicService.BasicSalesAmazonHandlingClassService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BasicSalesAmazonHandlingClassController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 16:39
 **/
@RestController
@RequestMapping("/api/v1/handling")
public class BasicSalesAmazonHandlingClassController {
    @Autowired
    private BasicSalesAmazonHandlingClassService classService;


    /**
     * 获得订单处理类信息
     *
     * @return
     */
    @PostMapping("/findByListHandling")
    public ResponseBase findByListHandling(@RequestBody BasicSalesAmazonHandlingClass hClass) {
        PageInfoUtils.setPage(hClass.getPageSize(), hClass.getCurrentPage());
        List<BasicSalesAmazonHandlingClass> handlingClassList = classService.serviceFindByListClass(hClass);
        return PageInfoUtils.returnPage(handlingClassList, hClass.getCurrentPage());
    }
}
