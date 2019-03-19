package com.dt.user.controller.BasePublicController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.ShopDto;
import com.dt.user.dto.SkuDto;
import com.dt.user.service.BasePublicService.BasicPublicSkuService;
import com.dt.user.utils.PageInfoUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
     * 获得店铺信息
     *
     * @return
     */
    @PostMapping("/findByListSku")
    public ResponseBase findByListSku(@RequestBody SkuDto skuDto) {
        PageInfoUtils.setPage(skuDto.getPageSize(), skuDto.getCurrentPage());
        List<SkuDto> skuDtoList = skuService.serviceFindByListSku(skuDto);
        return PageInfoUtils.returnPage(skuDtoList, skuDto.getCurrentPage());
    }
}
