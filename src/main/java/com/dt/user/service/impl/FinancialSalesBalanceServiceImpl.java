package com.dt.user.service.impl;

import com.dt.user.config.ResponseBase;
import com.dt.user.mapper.FinancialImportMapper.FinancialSalesBalanceMapper;
import com.dt.user.model.BasePublicModel.BasicPublicShop;
import com.dt.user.model.BasePublicModel.BasicPublicSite;
import com.dt.user.model.BasePublicModel.BasicPublicSku;
import com.dt.user.model.BasePublicModel.BasicSalesAmazonPaymentType;
import com.dt.user.model.FinancialSalesBalance;
import com.dt.user.service.BasePublicService.BasicPublicShopService;
import com.dt.user.service.BasePublicService.BasicPublicSiteService;
import com.dt.user.service.BasePublicService.BasicPublicSkuService;
import com.dt.user.service.BasePublicService.BasicSalesAmazonPaymentTypeService;
import com.dt.user.service.FinancialImportService.FinancialSalesBalanceService;
import com.dt.user.utils.PageInfoUtils;;
import com.dt.user.utils.ReqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialSalesBalanceServiceImpl implements FinancialSalesBalanceService {

    @Autowired
    private FinancialSalesBalanceMapper fsbMapper;
//    @Autowired
//    private BasicPublicSiteService siteService;
//    @Autowired
//    private BasicPublicShopService shopService;
//    @Autowired
//    private BasicSalesAmazonPaymentTypeService pTService;
//    @Autowired
//    private BasicPublicSkuService skuService;

    @Override
    public int addInfo(List<FinancialSalesBalance> fsbList, Integer tbId) {
        return fsbMapper.addInfo(fsbList, tbId);
    }

    @Override
    public ResponseBase serviceFindByListFbs(FinancialSalesBalance salesBalance) {
        PageInfoUtils.setPage(salesBalance.getPageSize(), salesBalance.getCurrentPage());
        //获得财务结算报告所有信息
        List<FinancialSalesBalance> fsbList = fsbMapper.findByListFbs(salesBalance);
        //sql 优化 后期在考虑
//        if (fsbList == null || fsbList.size() == 0) {
//            return null;
//        }
//        List<BasicPublicSite> sites = siteService.serviceSelectSite();
//        List<BasicSalesAmazonPaymentType> paymentTypes = pTService.serviceFindByListPayType();
//        List<BasicPublicSku> skuList = skuService.serviceSelAllSku();
//        for (FinancialSalesBalance fsb : fsbList) {
//            //站点
//            for (BasicPublicSite se : sites) {
//                if (fsb.getSiteId().equals(se.getSiteId())) {
//                    fsb.setSiteName(se.getSiteName());
//                    break;
//                }
//            }
//            //sku
//            for (BasicPublicSku sku : skuList) {
//                if (fsb.getSkuId().equals(sku.getSkuId())) {
//                    fsb.setSku(sku.getSku());
//                    break;
//                }
//            }
//            // 付款类型
//            for (BasicSalesAmazonPaymentType pt : paymentTypes) {
//                if (fsb.getPaymentTypeId().equals(pt.getPaymentTypeId())) {
//                    fsb.setPaymentTypeName(pt.getPaymentTypeName());
//                    break;
//                }
//            }
//        }
        return PageInfoUtils.returnPage(fsbList, salesBalance.getCurrentPage());
    }
}
