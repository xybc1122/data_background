package com.dt.project.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.purchaseMapper.PurchaseIcBillStockMapper;
import com.dt.project.model.purchasePo.PurchaseIcBillStock;
import com.dt.project.model.purchasePo.PurchaseIcBillStockEntry;
import com.dt.project.model.purchasePo.PurchasePoReceiptNotice;
import com.dt.project.model.purchasePo.PurchasePoReceiptNoticeEntry;
import com.dt.project.service.purchaseService.PurchaseIcBillStockEntryService;
import com.dt.project.service.purchaseService.PurchaseIcBillStockService;
import com.dt.project.toos.Constants;
import com.dt.project.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private RedisService redisService;


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


    @Override
    @Transactional
    public ResponseBase serviceInsertIcBillStock(Map<String, Object> objectMap) {
        Object purchaseIcBillStockObj = objectMap.get("purchaseIcBillStock");
        Object purchaseIcBillStockEntryObj = objectMap.get("purchaseIcBillStockEntry");
        ObjUtils.isObjNull(purchaseIcBillStockObj, purchaseIcBillStockEntryObj);
        String identifier = null;
        try {
            identifier = redisService.lockRedis(Constants.SAVE_PURCHASE_ICB_STOCK, 5000L, 20000L);
            if (StringUtils.isNotBlank(identifier)) {
                redisService.releaseLock(Constants.SAVE_PURCHASE_ICB_STOCK, identifier);
            }
            //拿到最外层入库通知单数据

            PurchaseIcBillStock icBillStock = (PurchaseIcBillStock)
                    JsonUtils.objConversion(purchaseIcBillStockObj, PurchaseIcBillStock.class);
            //校验时间
            //DateUtils.checkingTime(icBillStock.getDate(), "");

            int result = icBillStockMapper.insertIcBillStock(icBillStock);
            JsonUtils.saveResult(result);

            Long sbId = icBillStock.getSbId();
            //拿到入库单表体数据
            JSONArray objects = JsonUtils.getJsonArr(purchaseIcBillStockEntryObj);
            List<PurchaseIcBillStockEntry> icBillStockEntryList = new ArrayList<>();

            for (Object obj : objects) {
                PurchaseIcBillStockEntry icBillStockEntry = (PurchaseIcBillStockEntry) JsonUtils.objConversion(obj, PurchaseIcBillStockEntry.class);
                icBillStockEntry.setSbId(sbId);
                icBillStockEntryList.add(icBillStockEntry);
            }
            if (icBillStockEntryList.size() > 0) {
                //新增数据库
                icBillStockEntryService.serviceInsertIcBillStockEntry(icBillStockEntryList);
            }
            return JsonData.setResultSuccess("success");

        } finally {
            if (StringUtils.isNotBlank(identifier)) {
                redisService.releaseLock(Constants.SAVE_PURCHASE_RECEIPT_NOTICE, identifier);
            }
        }
    }
}
