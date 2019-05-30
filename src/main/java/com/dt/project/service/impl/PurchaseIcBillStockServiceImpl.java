package com.dt.project.service.impl;

import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.purchaseMapper.PurchaseIcBillStockMapper;
import com.dt.project.model.purchasePo.PurchaseIcBillStock;
import com.dt.project.model.purchasePo.PurchaseIcBillStockEntry;
import com.dt.project.model.purchasePo.PurchasePoReceiptNotice;
import com.dt.project.model.purchasePo.PurchasePoReceiptNoticeEntry;
import com.dt.project.service.purchaseService.PurchaseIcBillStockEntryService;
import com.dt.project.service.purchaseService.PurchaseIcBillStockService;
import com.dt.project.utils.ListUtils;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PurchaseIcBillStockServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/30 14:08
 **/
@Service
public class PurchaseIcBillStockServiceImpl implements PurchaseIcBillStockService {
    @Autowired
    private PurchaseIcBillStockMapper icBillStockMapper;

    @Autowired
    private PurchaseIcBillStockEntryService icBillStockEntryService;

    @Override
    public ResponseBase serviceSelectByIcBillStock(PurchaseIcBillStock record) {

        PageInfoUtils.setPage(record.getPageSize(), record.getCurrentPage());
        List<PurchaseIcBillStock> purchaseIcBillStocks = icBillStockMapper.selectByIcBillStock(record);

        if (!ListUtils.isList(purchaseIcBillStocks)) {
            return PageInfoUtils.returnPage(purchaseIcBillStocks, record.getCurrentPage());
        }

        List<Long> poIds = new ArrayList<>();
        for (PurchaseIcBillStock icBillStock : purchaseIcBillStocks) {
            poIds.add(icBillStock.getSbId());
        }
        PurchaseIcBillStockEntry icBillStockEntry = record.getPurchaseIcBillStockEntry();
        icBillStockEntry.setInList(poIds);


        //查询表体
        List<PurchaseIcBillStockEntry> purchaseIcBillStockEntries =
                icBillStockEntryService.serviceSelectByIcBillStockEntry(icBillStockEntry);


        if (!ListUtils.isList(purchaseIcBillStockEntries)) {
            return PageInfoUtils.returnPage(purchaseIcBillStocks, record.getCurrentPage());
        }
        for (int i = 0; i < poIds.size(); i++) {
            Long poId = poIds.get(i);
            List<PurchaseIcBillStockEntry> listNe = new ArrayList<>();
            for (PurchaseIcBillStockEntry ne : purchaseIcBillStockEntries) {
                if (poId.equals(ne.getSbId())) {
                    listNe.add(ne);
                }
            }
            purchaseIcBillStocks.get(i).setPurchaseIcBillStockEntryList(listNe);
        }
        return PageInfoUtils.returnPage(purchaseIcBillStocks, record.getCurrentPage());
    }
}
