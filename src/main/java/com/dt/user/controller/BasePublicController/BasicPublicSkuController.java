package com.dt.user.controller.BasePublicController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.SkuDto;
import com.dt.user.service.BasePublicService.BasicPublicSkuService;
import com.dt.user.utils.PageInfoUtils;
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
        return PageInfoUtils.returnPage(skuService.serviceFindByListSku(skuDto), skuDto.getCurrentPage());
    }
    @GetMapping("/getSkuName")
    public ResponseBase getKuName(@RequestParam("sId") Integer sId, @RequestParam("seId") Integer seId,
                                  @RequestParam("kuName") String kuName) {
        return JsonData.setResultSuccess(skuService.selSkuId(sId, seId, kuName));
    }


}
