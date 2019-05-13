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

import java.util.HashMap;
import java.util.List;

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
            //查询付款类型
            List<BasicSalesAmazonPaymentType> typeList = pTService.serviceFindByListPayType();
            //查询发货通知单表
            for (SalesShipNotice pn : pnList) {
                for (BasicSalesAmazonPaymentType ty : typeList) {
                    if (pn.getPlatformTypeId().equals(ty.getPaymentTypeId())) {
                        pn.setPaymentTypeName(ty.getPaymentTypeName());
                        break;
                    }
                }
                //设置发货通知表体
                SalesShipNoticeEntry noticeEntry = notice.getShipNoticeEntry();
                noticeEntry.setShipNoticeId(pn.getShipNoticeId());
                //查询 发货通知表体结果
                ResponseBase nEResult = nEService.serviceSelectByNoticeEntry(noticeEntry);
                pn.setNoticeEntryData(nEResult);
                //如果 查询 result 不是null的情况下 继续查询下面关联的表
                if (nEResult != null) {
                    //转换成Map
                    HashMap<String, Object> nerMap = (HashMap<String, Object>) nEResult.getData();
                    List<SalesShipNoticeEntry> nELists = (List<SalesShipNoticeEntry>) nerMap.get("dataList");
                    //循环设置
                    if (nELists != null && nELists.size() > 0) {
                        for (SalesShipNoticeEntry nE : nELists) {
                            SalesShipNoticePackingListEntry packingListEntry = noticeEntry.getPackingListEntry();
                            packingListEntry.setEid(nE.getEid());
                            //查询下面的数据 放到nE数据中
                            nE.setpEData(pLEService.serviceSelectPackingListEntry(packingListEntry));
                        }
                    }
                }
            }
        }
        return PageInfoUtils.returnPage(pnList, notice.getCurrentPage());
    }
}
