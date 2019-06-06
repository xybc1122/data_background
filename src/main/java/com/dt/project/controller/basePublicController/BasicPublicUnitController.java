package com.dt.project.controller.basePublicController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.parent.ParentTree;
import com.dt.project.service.basePublicService.BasicPublicUnitService;
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
