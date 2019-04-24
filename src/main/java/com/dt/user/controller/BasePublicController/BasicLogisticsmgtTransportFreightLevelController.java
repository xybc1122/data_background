package com.dt.user.controller.BasePublicController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.model.Parent.ParentTree;
import com.dt.user.service.BasePublicService.BasicLogisticsmgtTransportFreightLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BasicLogisticsmgtTransportFreightLevelController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 16:44
 **/
@RestController
@RequestMapping("/api/v1/level")
public class BasicLogisticsmgtTransportFreightLevelController {
    @Autowired
    private BasicLogisticsmgtTransportFreightLevelService levelService;

    @GetMapping("/findByListLevel")
    public ResponseBase findByListLevel() {
        List<ParentTree> freightLevels = levelService.serviceFindByFreightLevelInfo();
        return JsonData.setResultSuccess(freightLevels);
    }

}
