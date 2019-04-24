package com.dt.user.service.impl;


import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.exception.LsException;
import com.dt.user.mapper.GeneralQueryMapper;
import com.dt.user.model.BasePublicModel.*;
import com.dt.user.model.System.SystemShopRole;
import com.dt.user.service.BasePublicService.BasicPublicProductsService;
import com.dt.user.service.GeneralQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName GeneralQueryServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/11 11:18
 **/
@Service
public class GeneralQueryServiceImpl implements GeneralQueryService {

    @Autowired
    private GeneralQueryMapper queryMapper;
    @Autowired
    private BasicPublicProductsService productsService;

    @Override
    public void statusIdExist(Object obj) {
        //先去数据库查一下是否真的为null
        Long statusIdSql = serviceGetStatusId(obj);
        //如果 = null 说明里面确实是空的
        if (statusIdSql != null) {
            throw new LsException("statusId参数为空");
        }
    }


    /**
     * 返回对应的 sql 查询语句
     *
     * @param obj
     * @return
     */
    public Long serviceGetStatusId(Object obj) {
        if (obj instanceof BasicPublicWarehouse) {
            BasicPublicWarehouse war = (BasicPublicWarehouse) obj;
            return queryMapper.getStatusId("warehouse_id", war.getTreeId().longValue(), "basic_public_warehouse");
        } else if (obj instanceof BasicPublicCompany) {
            BasicPublicCompany company = (BasicPublicCompany) obj;
            return queryMapper.getStatusId("company_id", company.getCompanyId().longValue(), "basic_public_company");
        } else if (obj instanceof BasicPublicExchangeRate) {
            BasicPublicExchangeRate rate = (BasicPublicExchangeRate) obj;
            return queryMapper.getStatusId("exchange_rate_id", rate.getExchangeRateId().longValue(), "basic_public_exchange_rate");
        } else if (obj instanceof BasicPublicProduct) {
            BasicPublicProduct product = (BasicPublicProduct) obj;
            return queryMapper.getStatusId("product_id", product.getProductId().longValue(), "basic_public_product");
        } else if (obj instanceof BasicPublicProducts) {
            BasicPublicProducts products = (BasicPublicProducts) obj;
            return queryMapper.getStatusId("products_id", products.getTreeId().longValue(), "basic_public_products");
        }
        return null;
    }
}

