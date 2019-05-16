package com.dt.project.controller.BasePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.BasePublicModel.BasicSalesAmazonCsvTxtXslHeader;
import com.dt.project.service.BasePublicService.BasicSalesAmazonCsvTxtXslHeaderService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BasicSalesAmazonCsvTxtXslHeaderController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/14 10:36
 **/
@RestController
@RequestMapping("/api/v1/ctx")
public class BasicSalesAmazonCsvTxtXslHeaderController {

    @Autowired
    private BasicSalesAmazonCsvTxtXslHeaderService headerService;

    /**
     * 获得所有站点的信息
     *
     * @return
     */
    @PostMapping("/getTemplate")
    public ResponseBase getTemplate(@RequestBody BasicSalesAmazonCsvTxtXslHeader csvTxtXslHeader) {
        PageInfoUtils.setPage(csvTxtXslHeader.getPageSize(), csvTxtXslHeader.getCurrentPage());
        List<BasicSalesAmazonCsvTxtXslHeader> csvTxtXslHeaderList = headerService.getImportTemplate(csvTxtXslHeader);
        return PageInfoUtils.returnPage(csvTxtXslHeaderList, csvTxtXslHeader.getCurrentPage());
    }

}
