package com.dt.project.service.impl;

import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.BasePublicMapper.BasicPublicSurTaxrateMapper;
import com.dt.project.model.BasePublicModel.BasicPublicSurTaxrate;
import com.dt.project.service.BasePublicService.BasicPublicSurTaxrateService;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName BasicPublicSurTaxrateServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/17 11:21
 **/
@Service
public class BasicPublicSurTaxrateServiceImpl implements BasicPublicSurTaxrateService {
    @Autowired
    private BasicPublicSurTaxrateMapper surMapper;

    @Override
    public ResponseBase serviceSelectBySurTax(BasicPublicSurTaxrate record) {
        PageInfoUtils.setPage(record.getPageSize(), record.getCurrentPage());
        return PageInfoUtils.returnPage(surMapper.selectBySurTax(record), record.getCurrentPage());
    }
}
