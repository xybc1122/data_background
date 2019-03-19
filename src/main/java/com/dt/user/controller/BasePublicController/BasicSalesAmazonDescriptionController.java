package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.dto.SkuDto;
import com.dt.user.model.BasePublicModel.BasicSalesAmazonDescription;
import com.dt.user.service.BasePublicService.BasicSalesAmazonDescriptionService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        List<BasicSalesAmazonDescription> descriptionList = descriptionService.serviceGetDescription(description);
        return PageInfoUtils.returnPage(descriptionList, description.getCurrentPage());
    }


}
