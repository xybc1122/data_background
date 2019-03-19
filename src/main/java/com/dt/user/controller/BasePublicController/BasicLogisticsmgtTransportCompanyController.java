package com.dt.user.controller.BasePublicController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.AreaDto;
import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportCompany;
import com.dt.user.service.BasePublicService.BasicLogisticsmgtTransportCompanyService;
import com.dt.user.utils.PageInfoUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        List<BasicLogisticsmgtTransportCompany> freightList = companyService.serviceFindByListFreight(freight);
        return PageInfoUtils.returnPage(freightList, freight.getCurrentPage());
    }


}
