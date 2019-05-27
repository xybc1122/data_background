package com.dt.project.service.basePublicService;

import com.dt.project.dto.CurrencyDto;

import java.util.List;

public interface BasicPublicCurrencyService {

    /**
     * 查询币别所有相关信息
     *
     * @return
     */
    List<CurrencyDto> findByListCurrency();
}
