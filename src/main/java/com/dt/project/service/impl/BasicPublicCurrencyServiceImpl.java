package com.dt.project.service.impl;

import com.dt.project.dto.CurrencyDto;
import com.dt.project.mapper.BasePublicMapper.BasicPublicCurrencyMapper;
import com.dt.project.service.BasePublicService.BasicPublicCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicPublicCurrencyServiceImpl implements BasicPublicCurrencyService {
    @Autowired
    private BasicPublicCurrencyMapper basicPublicCurrencyMapper;

    @Override
    public List<CurrencyDto> findByListCurrency() {
        return basicPublicCurrencyMapper.findByListCurrency();
    }
}
