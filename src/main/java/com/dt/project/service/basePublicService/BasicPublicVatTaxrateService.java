package com.dt.project.service.basePublicService;

import com.dt.project.model.basePublic.BasicPublicVatTaxrate;

import java.util.List;

/**
 * @ClassName BasicPublicVatTaxrateService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 9:13
 **/
public interface BasicPublicVatTaxrateService {

    /**
     *
     * 查询附加税税率相关信息
     * @return
     */
    List<BasicPublicVatTaxrate> serviceFindByListSurTaxrate(BasicPublicVatTaxrate taxrate);
}
