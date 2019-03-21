package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.dto.ExchangeRateDto;
import com.dt.user.service.BasePublicService.BasicPublicExchangeRateService;
import com.dt.user.utils.PageInfoUtils;
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
        PageInfoUtils.setPage(rateDto.getPageSize(), rateDto.getCurrentPage());
        List<ExchangeRateDto> basicPublicSiteList = rateService.getRateInfo(rateDto);
        return PageInfoUtils.returnPage(basicPublicSiteList, rateDto.getCurrentPage());
    }
}
