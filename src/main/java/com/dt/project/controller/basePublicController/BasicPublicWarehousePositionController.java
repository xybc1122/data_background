package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.service.basePublicService.BasicPublicWarehousePositionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicPublicWarehousePositionController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/6/4 9:21
 **/
@RestController
@RequestMapping("/api/v1/warp")
public class BasicPublicWarehousePositionController {
    @Autowired
    private BasicPublicWarehousePositionService bPWPService;

    @GetMapping("/findByListWarP")
    public ResponseBase findByListNation(@Param("positionId") String positionId) {

        return bPWPService.serviceSelByWarehousePosition(positionId);
    }


}
