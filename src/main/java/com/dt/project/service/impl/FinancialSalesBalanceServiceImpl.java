package com.dt.project.service.impl;

import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.FinancialImportMapper.FinancialSalesBalanceMapper;
import com.dt.project.model.FinancialSalesBalance;
import com.dt.project.service.FinancialImportService.FinancialSalesBalanceService;
import com.dt.project.utils.PageInfoUtils;;
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
