package com.dt.user.service.BasePublicService;

import com.dt.user.dto.ExchangeRateDto;

import java.util.List;

public interface BasicPublicExchangeRateService {

    //查询汇率信息
    List<ExchangeRateDto> getRateInfo(ExchangeRateDto rateDto);
}
