package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.dto.ShopDto;
import com.dt.user.model.BasePublicModel.BasicPublicProvinceRelation;
import com.dt.user.service.BasePublicService.BasicPublicProvinceRelationService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
