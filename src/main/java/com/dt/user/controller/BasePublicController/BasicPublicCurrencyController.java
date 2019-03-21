package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.dto.CurrencyDto;
import com.dt.user.service.BasePublicService.BasicPublicCurrencyService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        List<CurrencyDto> basicPublicCurrencies = basicPublicCurrencyService.findByListCurrency();
        return PageInfoUtils.returnPage(basicPublicCurrencies, currencyDto.getCurrentPage());
    }
}
