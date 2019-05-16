package com.dt.project.service.impl;

import com.dt.project.mapper.BasePublicMapper.BasicPublicVatTaxrateMapper;
import com.dt.project.model.BasePublicModel.BasicPublicVatTaxrate;
import com.dt.project.service.BasePublicService.BasicPublicVatSurTaxrateService;
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
    private BasicPublicVatTaxrateMapper surTaxrateMapper;

    @Override
    public List<BasicPublicVatTaxrate> serviceFindByListSurTaxrate(BasicPublicVatTaxrate taxrate) {
        return surTaxrateMapper.findByListSurTaxrate(taxrate);
    }
}
