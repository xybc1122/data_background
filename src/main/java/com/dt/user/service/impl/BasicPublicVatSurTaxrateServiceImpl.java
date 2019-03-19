package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicPublicVatSurTaxrateMapper;
import com.dt.user.model.BasePublicModel.BasicPublicVatSurTaxrate;
import com.dt.user.service.BasePublicService.BasicPublicVatSurTaxrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicPublicSurTaxrateServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 9:14
 **/
@Service
public class BasicPublicVatSurTaxrateServiceImpl implements BasicPublicVatSurTaxrateService {
    @Autowired
    private BasicPublicVatSurTaxrateMapper surTaxrateMapper;

    @Override
    public List<BasicPublicVatSurTaxrate> serviceFindByListSurTaxrate(BasicPublicVatSurTaxrate taxrate) {
        return surTaxrateMapper.findByListSurTaxrate(taxrate);
    }
}
