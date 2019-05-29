package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.basePublicModel.BasicSalesAmazonDescription;
import com.dt.project.service.basePublicService.BasicSalesAmazonDescriptionService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicSalesAmazonDescriptionController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 15:59
 **/
@RestController
@RequestMapping("/api/v1/description")
public class BasicSalesAmazonDescriptionController {
    @Autowired
    private BasicSalesAmazonDescriptionService descriptionService;

    /**
     * 获得亚马逊描述信息
     *
     * @return
     */
    @PostMapping("/findByListDescription")
    public ResponseBase findByListDescription(@RequestBody BasicSalesAmazonDescription description) {
        PageInfoUtils.setPage(description.getPageSize(), description.getCurrentPage());
        return PageInfoUtils.returnPage(descriptionService.serviceGetDescription(description), description.getCurrentPage());
    }


}
