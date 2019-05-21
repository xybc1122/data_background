package com.dt.project.controller.BasePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.BasePublicModel.BasicLogisticsmgtTransportCompany;
import com.dt.project.service.BasePublicService.BasicLogisticsmgtTransportCompanyService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BasicLogisticsmgtTransportCompanyController
 * Description TODO 货运公司接口
 * @Author 陈恩惠
 * @Date 2019/3/18 14:54
 **/
@RestController
@RequestMapping("/api/v1/freight")
public class BasicLogisticsmgtTransportCompanyController {

    @Autowired
    private BasicLogisticsmgtTransportCompanyService companyService;

    /**
     * 获得货运公司信息
     *
     * @return
     */
    @PostMapping("/findByListFreight")
    public ResponseBase findByListFreight(@RequestBody BasicLogisticsmgtTransportCompany freight) {
        PageInfoUtils.setPage(freight.getPageSize(), freight.getCurrentPage());
        return PageInfoUtils.returnPage(companyService.serviceFindByListFreight(freight), freight.getCurrentPage());
    }


}
