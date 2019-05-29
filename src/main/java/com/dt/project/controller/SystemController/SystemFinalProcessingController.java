package com.dt.project.controller.systemController;

import com.dt.project.config.ResponseBase;
import com.dt.project.service.systemService.SystemFinalProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SystemFinalProcessingController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/23 9:39
 **/
@RestController
@RequestMapping("/api/v1/ing")
public class SystemFinalProcessingController {
    @Autowired
    private SystemFinalProcessingService pService;

    /**
     * 查询结账时间
     *
     * @param menuId
     * @return
     */
    @GetMapping("/getCheckoutDate")
    public ResponseBase getIconInfo(@RequestParam("menuId") String menuId) {
        return pService.selectByDateCheckout(Integer.parseInt(menuId));
    }
}
