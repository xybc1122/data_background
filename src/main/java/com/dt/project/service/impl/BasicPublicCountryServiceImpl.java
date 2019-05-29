package com.dt.project.service.impl;

import com.dt.project.model.dto.CountryDto;
import com.dt.project.mapper.basePublicMapper.BasicPublicCountryMapper;
import com.dt.project.service.basePublicService.BasicPublicCountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicPublicCountryServiceImpl implements BasicPublicCountryService {
    @Autowired
    private BasicPublicCountryMapper countryMapper;

    @Override
    public List<CountryDto> findByCountry(CountryDto country) {
        return countryMapper.findByCountry(country);
    }
}
