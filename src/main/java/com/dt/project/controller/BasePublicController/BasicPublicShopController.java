package com.dt.project.controller.basePublicController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.dto.ShopDto;
import com.dt.project.model.basePublicModel.BasicPublicShop;
import com.dt.project.service.basePublicService.BasicPublicShopService;
import com.dt.project.utils.PageInfoUtils;
import com.dt.project.utils.ReqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shop")
public class BasicPublicShopController {


    @Autowired
    private BasicPublicShopService shopService;

    /**
     * 获得店铺信息
     *
     * @return
     */
    @PostMapping("/findByListShop")
    public ResponseBase findByListShop(@RequestBody ShopDto shopDto) {
        PageInfoUtils.setPage(shopDto.getPageSize(), shopDto.getCurrentPage());
        return PageInfoUtils.returnPage(shopService.findByListShop(), shopDto.getCurrentPage());
    }

    /**
     * 获得配置店铺名字
     *
     * @return
     */
    @GetMapping("/getListShopName")
    public ResponseBase findByListShop() {
        List<BasicPublicShop> nameList = shopService.getByListShopName(ReqUtils.getRoleId());
        return JsonData.setResultSuccess(nameList);
    }

}
