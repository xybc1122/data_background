package com.dt.project.service.impl;

import com.alibaba.fastjson.JSON;
import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.salesAmazonMapper.SalesShipNoticeMapper;
import com.dt.project.model.basePublicModel.BasicSalesAmazonPaymentType;
import com.dt.project.model.salesAmazon.SalesShipNotice;
import com.dt.project.model.salesAmazon.SalesShipNoticeEntry;
import com.dt.project.model.salesAmazon.SalesShipNoticePackingListEntry;
import com.dt.project.service.basePublicService.BasicSalesAmazonPaymentTypeService;
import com.dt.project.service.salesAmazonService.SalesShipNoticeEntryService;
import com.dt.project.service.salesAmazonService.SalesShipNoticeService;
import com.dt.project.utils.ListUtils;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName SalesShipNoticeServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/10 17:04
 **/
@Service
public class SalesShipNoticeServiceImpl implements SalesShipNoticeService {
    @Autowired
    private SalesShipNoticeMapper nMapper;
    @Autowired
    private BasicSalesAmazonPaymentTypeService pTService;
    @Autowired
    private SalesShipNoticeEntryService nEService;

    @Override
    @SuppressWarnings("unchecked")  //(HashMap<String, Object>) result.getData(); 确认是这类型
    public ResponseBase selectSelectByNotice(SalesShipNotice notice) {
        PageInfoUtils.setPage(notice.getPageSize(), notice.getCurrentPage());
        List<SalesShipNotice> pnList = nMapper.selectByNotice(notice);
        if (!ListUtils.isList(pnList)) {
            return PageInfoUtils.returnPage(pnList, notice.getCurrentPage());
        }
        List<Long> shipIdList = new ArrayList<>();
        //查询付款类型
        List<BasicSalesAmazonPaymentType> typeList = pTService.serviceFindByListPayType();
        //查询发货通知单表
        for (SalesShipNotice pn : pnList) {
            for (BasicSalesAmazonPaymentType ty : typeList) {
                //设置付款类型
                if (pn.getPlatformTypeId().equals(ty.getPaymentTypeId())) {
                    pn.setPaymentTypeName(ty.getPaymentTypeName());
                    break;
                }
            }
            shipIdList.add(pn.getShipNoticeId());
        }
        //设置发货通知表体
        SalesShipNoticeEntry noticeEntry = notice.getShipNoticeEntry();
        noticeEntry.setInShipNoticeList(shipIdList);
        //查询 发货通知表体结果
        List<SalesShipNoticeEntry> nEResults = nEService.serviceSelectByNoticeEntry(noticeEntry);

        if (!ListUtils.isList(nEResults)) {
            return PageInfoUtils.returnPage(pnList, notice.getCurrentPage());
        }

        for (int i = 0; i < shipIdList.size(); i++) {
            List<SalesShipNoticeEntry> listNe = new ArrayList<>();
            Long shipId = shipIdList.get(i);
            for (SalesShipNoticeEntry ne : nEResults) {
                if (shipId.equals(ne.getShipNoticeId())) {
                    listNe.add(ne);
                }
            }
            pnList.get(i).setNoticeEntryList(listNe);
        }
        return PageInfoUtils.returnPage(pnList, notice.getCurrentPage());
    }

    @Override
    public ResponseBase saveNotice(Map<String, Object> noMap) {
        Object salesShipNoticeObj = noMap.get("salesShipNotice");
        Object salesShipNoticeEntryObj = noMap.get("salesShipNoticeEntry");
        Object salesShipNoticePackingListEntryObj = noMap.get("salesShipNoticePackingListEntry");
//        if (salesShipNoticeObj == null || salesShipNoticeEntryObj == null || salesShipNoticePackingListEntryObj == null) {
//            return JsonData.setResultError("error");
//        }
        SalesShipNotice salesShipNotice = JSON.parseObject(JSON.toJSONString(salesShipNoticeObj), SalesShipNotice.class);//将JSON转化成对象
        System.out.println(salesShipNotice);
        System.out.println(JSON.toJSONString(salesShipNoticeEntryObj));
        return null;
    }
}
