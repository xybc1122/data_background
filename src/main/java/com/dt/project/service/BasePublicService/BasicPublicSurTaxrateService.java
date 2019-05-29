package com.dt.project.service.basePublicService;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.basePublicModel.BasicPublicSurTaxrate;

/**
 * @ClassName BasicPublicSurTaxrateService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/17 11:21
 **/
public interface BasicPublicSurTaxrateService {

    /**
     * 查询附加税
     * *
     *
     * @param record
     * @return
     */

    ResponseBase serviceSelectBySurTax(BasicPublicSurTaxrate record);
}
