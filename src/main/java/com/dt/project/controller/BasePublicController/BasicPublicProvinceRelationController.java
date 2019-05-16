package com.dt.project.controller.BasePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.BasePublicModel.BasicPublicProvinceRelation;
import com.dt.project.service.BasePublicService.BasicPublicProvinceRelationService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName BasicPublicProvinceRelationController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 10:59
 **/
@RestController
@RequestMapping("/api/v1/rel")
public class BasicPublicProvinceRelationController {

    @Autowired
    private BasicPublicProvinceRelationService relationService;


    /**
     * 获得省州关联表信息
     *
     * @return
     */
    @PostMapping("/findByListRelation")
    public ResponseBase findByListShop(@RequestBody BasicPublicProvinceRelation relation) {
        PageInfoUtils.setPage(relation.getPageSize(), relation.getCurrentPage());
        return PageInfoUtils.returnPage(relationService.serviceFindByRelationList(relation), relation.getCurrentPage());
    }
}
