package com.dt.project.service.impl;

import com.dt.project.mapper.purchaseMapper.PurchaseIcBillStockEntryMapper;
import com.dt.project.model.purchasePo.PurchaseIcBillStockEntry;
import com.dt.project.service.JavaSqlNameService;
import com.dt.project.service.purchaseService.PurchaseIcBillStockEntryService;
import com.dt.project.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PurchaseIcBillStockEntryServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/30 14:20
 **/
@Service
public class PurchaseIcBillStockEntryServiceImpl implements PurchaseIcBillStockEntryService {
    @Autowired
    private PurchaseIcBillStockEntryMapper icBillStockEntryMapper;
    @Autowired
    private JavaSqlNameService nameService;

    @Override
    public List<PurchaseIcBillStockEntry> serviceSelectByIcBillStockEntry(PurchaseIcBillStockEntry record) {
        record.setJavaSqlName(nameService.get("icBillEntry"));
        return icBillStockEntryMapper.selectByIcBillStockEntry(record);
    }

    @Override
    public int serviceInsertIcBillStockEntry(List<PurchaseIcBillStockEntry> record) {
        int i = icBillStockEntryMapper.insertIcBillStockEntry(record);
        JsonUtils.saveResult(i);
        return i;
    }

    @Override
    public int serviceUpdateByIcBillStockEntry(PurchaseIcBillStockEntry record) {
        int i = icBillStockEntryMapper.updateByIcBillStockEntry(record);
        JsonUtils.saveResult(i);
        return i;
    }
}
