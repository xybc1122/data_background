package com.dt.project.service.basePublicService;

import com.dt.project.model.dto.TaxrateDto;

import java.util.List;

/**
 * @ClassName BasicPublicDutiesTaxrateService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/13 11:17
 **/
public interface BasicPublicDutiesTaxrateService {
    /**
     * 查询关税 税率
     * @param taxrateDto
     * @return
     */
    List<TaxrateDto> findByListTaxrate(TaxrateDto taxrateDto);

}
