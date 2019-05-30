package com.dt.project.service.impl;

import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.purchaseMapper.PurchasePoReceiptNoticeMapper;
import com.dt.project.model.purchasePo.PurchasePoReceiptNotice;
import com.dt.project.model.purchasePo.PurchasePoReceiptNoticeEntry;
import com.dt.project.service.purchaseService.PurchasePoReceiptNoticeEntryService;
import com.dt.project.service.purchaseService.PurchasePoReceiptNoticeService;
import com.dt.project.utils.ListUtils;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PurchasePoReceiptNoticeServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/30 8:51
 **/
@Service
public class PurchasePoReceiptNoticeServiceImpl implements PurchasePoReceiptNoticeService {

    @Autowired
    private PurchasePoReceiptNoticeMapper poReceiptNoticeMapper;
    @Autowired
    private PurchasePoReceiptNoticeEntryService receiptNoticeEntryService;

    @Override
    public ResponseBase serviceSelectByPoReceiptNotice(PurchasePoReceiptNotice record) {
        PageInfoUtils.setPage(record.getPageSize(), record.getCurrentPage());
        List<PurchasePoReceiptNotice> receiptNoticeList = poReceiptNoticeMapper.selectByPoReceiptNotice(record);

        if (!ListUtils.isList(receiptNoticeList)) {
            return PageInfoUtils.returnPage(receiptNoticeList, record.getCurrentPage());
        }
        List<Long> poIds = new ArrayList<>();
        for (PurchasePoReceiptNotice receiptNotice : receiptNoticeList) {
            poIds.add(receiptNotice.getRnId());
        }
        PurchasePoReceiptNoticeEntry pPReceiptNoticeEntry = record.getPurchasePoReceiptNoticeEntry();
        pPReceiptNoticeEntry.setInList(poIds);
        //查询表体
        List<PurchasePoReceiptNoticeEntry> purchasePoReceiptNoticeEntries = receiptNoticeEntryService.serviceSelectByPRNoticeEntry(pPReceiptNoticeEntry);

        if (!ListUtils.isList(purchasePoReceiptNoticeEntries)) {
            return PageInfoUtils.returnPage(receiptNoticeList, record.getCurrentPage());
        }
        for (int i = 0; i < poIds.size(); i++) {
            Long poId = poIds.get(i);
            List<PurchasePoReceiptNoticeEntry> listNe = new ArrayList<>();
            for (PurchasePoReceiptNoticeEntry ne : purchasePoReceiptNoticeEntries) {
                if (poId.equals(ne.getRnId())) {
                    listNe.add(ne);
                }
            }
            receiptNoticeList.get(i).setPoReceiptNoticeEntryList(listNe);
        }
        return PageInfoUtils.returnPage(receiptNoticeList, record.getCurrentPage());
    }
}
