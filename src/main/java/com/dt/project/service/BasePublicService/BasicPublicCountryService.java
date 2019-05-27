package com.dt.project.service.basePublicService;

import com.dt.project.dto.CountryDto;

import java.util.List;

public interface BasicPublicCountryService {


    /**
     * 查询获得国家信息
     */
    List<CountryDto> findByCountry(CountryDto country);
}
