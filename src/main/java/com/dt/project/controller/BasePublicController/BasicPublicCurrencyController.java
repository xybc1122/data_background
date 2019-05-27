package com.dt.project.controller.basePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.dto.CurrencyDto;
import com.dt.project.service.basePublicService.BasicPublicCurrencyService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/currency")
public class BasicPublicCurrencyController {
    @Autowired
    private BasicPublicCurrencyService basicPublicCurrencyService;

    /**
     * 获得货币信息
     *
     * @return
     */
    @PostMapping("/findByListCurrency")
    public ResponseBase findByListCurrency(@RequestBody CurrencyDto currencyDto) {
        PageInfoUtils.setPage(currencyDto.getPageSize(), currencyDto.getCurrentPage());
        return PageInfoUtils.returnPage(basicPublicCurrencyService.findByListCurrency(), currencyDto.getCurrentPage());
    }
}
