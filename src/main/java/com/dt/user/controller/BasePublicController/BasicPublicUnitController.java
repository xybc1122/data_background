package com.dt.user.controller.BasePublicController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.model.Parent.ParentTree;
import com.dt.user.service.BasePublicService.BasicPublicUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName BasicPublicUnitController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 9:43
 **/
@RestController
@RequestMapping("/api/v1/unit")
public class BasicPublicUnitController {

    @Autowired
    private BasicPublicUnitService unitService;

    @GetMapping("/findByListUnit")
    public ResponseBase findByListUnit() {
        List<ParentTree> publicUnits = unitService.serviceFindByListUnit();
        return JsonData.setResultSuccess(publicUnits);
    }
}
