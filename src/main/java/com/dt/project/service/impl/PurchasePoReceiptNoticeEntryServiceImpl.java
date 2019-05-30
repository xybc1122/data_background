package com.dt.project.service.impl;

import com.dt.project.mapper.purchaseMapper.PurchasePoReceiptNoticeEntryMapper;
import com.dt.project.model.purchasePo.PurchasePoReceiptNoticeEntry;
import com.dt.project.service.JavaSqlNameService;
import com.dt.project.service.purchaseService.PurchasePoReceiptNoticeEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PurchasePoReceiptNoticeEntryServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/30 9:09
 **/
@Service
public class PurchasePoReceiptNoticeEntryServiceImpl implements PurchasePoReceiptNoticeEntryService {
    @Autowired
    private PurchasePoReceiptNoticeEntryMapper receiptNoticeEntryMapper;
    @Autowired
    private JavaSqlNameService nameService;

    @Override
    public List<PurchasePoReceiptNoticeEntry> serviceSelectByPRNoticeEntry(PurchasePoReceiptNoticeEntry record) {
        record.setJavaSqlName(nameService.get("pNoticeEntry"));
        return receiptNoticeEntryMapper.selectByPRNoticeEntry(record);
    }
}
