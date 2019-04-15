package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.service.GeneralQueryService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName GeneralQueryController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/15 17:28
 **/
@RestController
@RequestMapping("/api/v1/general")
public class GeneralQueryController {
    @Autowired
    private GeneralQueryService generalService;


    @GetMapping("/getGeneralInfo")
    public ResponseBase findByListPackingType(@RequestParam("menuId") Integer menuId,
                                              @RequestParam("topType") String topType) {
       return generalService.selType(topType,menuId);
    }


}
