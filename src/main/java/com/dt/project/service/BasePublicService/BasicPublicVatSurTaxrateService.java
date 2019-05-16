package com.dt.project.service.BasePublicService;

import com.dt.project.model.BasePublicModel.BasicPublicVatTaxrate;

import java.util.List;

/**
 * @ClassName BasicPublicVatSurTaxrateService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 9:13
 **/
public interface BasicPublicVatSurTaxrateService {

    /**
     *
     * 查询附加税税率相关信息
     * @return
     */
    List<BasicPublicVatTaxrate> serviceFindByListSurTaxrate(BasicPublicVatTaxrate taxrate);
}
