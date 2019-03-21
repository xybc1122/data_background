package com.dt.user.service.BasePublicService;

import com.dt.user.model.BasePublicModel.BasicPublicVatSurTaxrate;

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
    List<BasicPublicVatSurTaxrate> serviceFindByListSurTaxrate(BasicPublicVatSurTaxrate taxrate);
}
