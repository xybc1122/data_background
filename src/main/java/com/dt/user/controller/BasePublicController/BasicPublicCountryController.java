package com.dt.user.controller.BasePublicController;

import com.dt.user.config.ResponseBase;
import com.dt.user.dto.CountryDto;
import com.dt.user.service.BasePublicService.BasicPublicCountryService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/v1/country")
@RestController
public class BasicPublicCountryController {

    @Autowired
    private BasicPublicCountryService countryService;

    @PostMapping("/findCountryInfo")
    public ResponseBase findCountryInfo(@RequestBody CountryDto countryDto) {
        PageInfoUtils.setPage(countryDto.getPageSize(), countryDto.getCurrentPage());
        List<CountryDto> countryDtoList = countryService.findByCountry(countryDto);
        return PageInfoUtils.returnPage(countryDtoList, countryDto.getCurrentPage());
    }

}
