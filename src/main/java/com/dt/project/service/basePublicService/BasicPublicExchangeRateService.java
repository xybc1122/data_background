package com.dt.project.service.basePublicService;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.dto.ExchangeRateDto;
import com.dt.project.model.basePublic.BasicPublicExchangeRate;

import java.util.List;
import java.util.Map;

public interface BasicPublicExchangeRateService {

    //查询汇率信息
    List<ExchangeRateDto> getRateInfo(ExchangeRateDto rateDto);


    /**
     * 更新汇率信息
     */

    ResponseBase serviceUpRate(BasicPublicExchangeRate rate);

    /**
     * 批量删除数据/更新
     */
    ResponseBase serviceDelRate(Map<String, String> rateMap);

    /**
     * 新增汇率数据
     */

    ResponseBase serviceSaveRate(BasicPublicExchangeRate rate);

}
