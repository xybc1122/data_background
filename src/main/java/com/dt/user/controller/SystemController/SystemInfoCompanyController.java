package com.dt.user.controller.SystemController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.model.System.SystemInfoCompany;
import com.dt.user.service.SystemService.SystemInfoCompanyService;
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
