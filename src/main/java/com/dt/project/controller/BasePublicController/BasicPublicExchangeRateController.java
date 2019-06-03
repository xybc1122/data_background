package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.dto.ExchangeRateDto;
import com.dt.project.model.basePublic.BasicPublicExchangeRate;
import com.dt.project.service.basePublicService.BasicPublicExchangeRateService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/api/v1/rate")
@RestController
public class BasicPublicExchangeRateController {
    @Autowired
    private BasicPublicExchangeRateService rateService;

    @PostMapping("/findByListRate")
    public ResponseBase findByListRate(@RequestBody ExchangeRateDto rateDto) {
        PageInfoUtils.setPage(rateDto.getPageSize(), rateDto.getCurrentPage());
        return PageInfoUtils.returnPage(rateService.getRateInfo(rateDto));
    }


    @PostMapping("/upRate")
    public ResponseBase upRateInfo(@RequestBody BasicPublicExchangeRate rate) {
        return rateService.serviceUpRate(rate);
    }

    @PostMapping("/delRate")
    public ResponseBase delRateInfo(@RequestBody Map<String, String> rateMap) {
        return rateService.serviceDelRate(rateMap);
    }

    @PostMapping("/saveRate")
    public ResponseBase saveRateInfo(@RequestBody BasicPublicExchangeRate rate) {
        return rateService.serviceSaveRate(rate);
    }
}
