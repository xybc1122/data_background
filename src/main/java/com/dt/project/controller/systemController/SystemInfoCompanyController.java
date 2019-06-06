package com.dt.project.controller.systemController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.system.SystemInfoCompany;
import com.dt.project.service.systemService.SystemInfoCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SystemInfoCompanyController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/10 14:10
 **/
@RestController
@RequestMapping("/api/v1/")
public class SystemInfoCompanyController {
    @Autowired
    private SystemInfoCompanyService cService;


    /**
     * 新增配置公司 信息 LOGO
     *
     * @return
     */
    @PostMapping("/selectInfoCompany")
    public ResponseBase saveInfoCompany(@RequestBody SystemInfoCompany company) {
        return JsonData.setResultSuccess(cService.serviceSelectByCompany(company));
    }


}
