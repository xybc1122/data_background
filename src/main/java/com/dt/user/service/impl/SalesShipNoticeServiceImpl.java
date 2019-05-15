package com.dt.user.service.impl;

import com.dt.user.config.ResponseBase;
import com.dt.user.mapper.SalesAmazonMapper.SalesShipNoticeMapper;
import com.dt.user.model.BasePublicModel.BasicSalesAmazonPaymentType;
import com.dt.user.model.SalesAmazon.SalesShipNotice;
import com.dt.user.model.SalesAmazon.SalesShipNoticeEntry;
import com.dt.user.model.SalesAmazon.SalesShipNoticePackingListEntry;
import com.dt.user.service.BasePublicService.BasicSalesAmazonPaymentTypeService;
import com.dt.user.service.SalesAmazonService.SalesShipNoticeEntryService;
import com.dt.user.service.SalesAmazonService.SalesShipNoticeService;
import com.dt.user.service.SalesShipNoticePackingListEntryService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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
    @Autowired
    private SalesShipNoticePackingListEntryService pLEService;

    @Override
    @SuppressWarnings("unchecked")  //(HashMap<String, Object>) result.getData(); 确认是这类型
    public ResponseBase selectSelectByNotice(SalesShipNotice notice) {
        PageInfoUtils.setPage(notice.getPageSize(), notice.getCurrentPage());
        List<SalesShipNotice> pnList = nMapper.selectByNotice(notice);
        if (pnList != null && pnList.size() > 0) {
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

        }
        return PageInfoUtils.returnPage(pnList, notice.getCurrentPage());
    }
}
