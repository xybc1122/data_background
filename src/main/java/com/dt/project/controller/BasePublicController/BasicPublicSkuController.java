package com.dt.project.controller.basePublicController;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.model.dto.SkuDto;
import com.dt.project.service.basePublicService.BasicPublicSkuService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName BasicPublicSkuController
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 13:15
 **/
@RestController
@RequestMapping("/api/v1/sku")
public class BasicPublicSkuController {
    @Autowired
    private BasicPublicSkuService skuService;

    /**
     * 获得SKU表信息
     *
     * @return
     */
    @PostMapping("/findByListSku")
    public ResponseBase findByListSku(@RequestBody SkuDto skuDto) {
        PageInfoUtils.setPage(skuDto.getPageSize(), skuDto.getCurrentPage());
        return PageInfoUtils.returnPage(skuService.serviceFindByListSku(skuDto));
    }

    @GetMapping("/getSkuName")
    public ResponseBase getKuName(@RequestParam("sId") Integer sId, @RequestParam("seId") Integer seId, @RequestParam("kuName") String kuName) {
        return JsonData.setResultSuccess(skuService.serviceGetListKu(sId, seId, kuName));
    }


}
