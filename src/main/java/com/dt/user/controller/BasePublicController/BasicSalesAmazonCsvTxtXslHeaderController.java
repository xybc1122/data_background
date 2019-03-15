package com.dt.user.controller.BasePublicController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.model.BasePublicModel.BasicSalesAmazonCsvTxtXslHeader;
import com.dt.user.service.BasePublicService.BasicSalesAmazonCsvTxtXslHeaderService;
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
        if (csvTxtXslHeader.getCurrentPage() != null && csvTxtXslHeader.getPageSize() != null) {
            PageHelper.startPage(csvTxtXslHeader.getCurrentPage(), csvTxtXslHeader.getPageSize());
            List<BasicSalesAmazonCsvTxtXslHeader> csvTxtXslHeaderList = headerService.getImportTemplate(csvTxtXslHeader);
            PageInfo<BasicSalesAmazonCsvTxtXslHeader> pageInfo = new PageInfo<>(csvTxtXslHeaderList);
            Integer currentPage = csvTxtXslHeader.getCurrentPage();
            return JsonData.setResultSuccess(PageInfoUtils.getPage(pageInfo, currentPage));
        }
        return JsonData.setResultError("分页无参数");
    }

}
