package com.dt.user.controller.BasePublicController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.ExchangeRateDto;
import com.dt.user.service.BasePublicService.BasicPublicExchangeRateService;
import com.dt.user.utils.PageInfoUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/rate")
@RestController
public class BasicPublicExchangeRateController {
    @Autowired
    private BasicPublicExchangeRateService rateService;

    @PostMapping("/findByListRate")
    public ResponseBase findByListRate(@RequestBody ExchangeRateDto rateDto) {
        if (rateDto.getCurrentPage() != null && rateDto.getPageSize() != null) {
            PageHelper.startPage(rateDto.getCurrentPage(), rateDto.getPageSize());
            List<ExchangeRateDto> basicPublicSiteList = rateService.getRateInfo(rateDto);
            PageInfo<ExchangeRateDto> pageInfo = new PageInfo<>(basicPublicSiteList);
            Integer currentPage = rateDto.getCurrentPage();
            return JsonData.setResultSuccess(PageInfoUtils.getPage(pageInfo, currentPage));
        }
        return JsonData.setResultError("分页无参数");
    }
}
