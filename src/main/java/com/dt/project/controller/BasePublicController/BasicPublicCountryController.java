package com.dt.project.controller.BasePublicController;

import com.dt.project.config.ResponseBase;
import com.dt.project.dto.CountryDto;
import com.dt.project.service.BasePublicService.BasicPublicCountryService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/country")
@RestController
public class BasicPublicCountryController {

    @Autowired
    private BasicPublicCountryService countryService;

    @PostMapping("/findCountryInfo")
    public ResponseBase findCountryInfo(@RequestBody CountryDto countryDto) {
        PageInfoUtils.setPage(countryDto.getPageSize(), countryDto.getCurrentPage());
        return PageInfoUtils.returnPage(countryService.findByCountry(countryDto), countryDto.getCurrentPage());
    }

}
