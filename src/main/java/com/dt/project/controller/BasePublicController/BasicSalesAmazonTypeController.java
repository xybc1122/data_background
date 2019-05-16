package com.dt.project.controller.BasePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.BasePublicModel.BasicSalesAmazonType;
import com.dt.project.service.BasePublicService.BasicSalesAmazonTypeService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @ClassName BasicSalesAmazonTypeController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/20 10:57
 **/
@RequestMapping("/api/v1/type")
@RestController
public class BasicSalesAmazonTypeController {

    @Autowired
    private BasicSalesAmazonTypeService typeService;


    @PostMapping("/findByListAmazon")
    public ResponseBase findByListAmazon(@RequestBody BasicSalesAmazonType amazonType) {
        PageInfoUtils.setPage(amazonType.getPageSize(), amazonType.getCurrentPage());
        List<BasicSalesAmazonType> amazonTypeList = typeService.serviceFindByListAmazonType(amazonType);
        return PageInfoUtils.returnPage(amazonTypeList, amazonType.getCurrentPage());
    }
}
