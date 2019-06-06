package com.dt.project.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.purchaseMapper.PurchaseIcBillStockMapper;
import com.dt.project.model.purchasePo.PurchaseIcBillStock;
import com.dt.project.model.purchasePo.PurchaseIcBillStockEntry;
import com.dt.project.redis.RedisService;
import com.dt.project.service.SystemLogStatusService;
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

    @Autowired
    private SystemLogStatusService logStatusService;

    @Autowired
    private SystemFinalProcessingServiceImpl sfpService;

    @Override
    public ResponseBase serviceSelectByIcBillStock(PurchaseIcBillStock record) {
        PageInfoUtils.setPage(record.getPageSize(), record.getCurrentPage());
        record.setJsonArray(redisService.getRedisJson("pIBS",PurchaseIcBillStock.class));
        List<PurchaseIcBillStock> purchaseIcBillStocks = icBillStockMapper.selectByIcBillStock(record);
        if (!ListUtils.isList(purchaseIcBillStocks)) {
            return PageInfoUtils.returnPage(purchaseIcBillStocks);
        }
        List<Long> poIds = new ArrayList<>();
        for (PurchaseIcBillStock icBillStock : purchaseIcBillStocks) {
            poIds.add(icBillStock.getSbId());
        }
        PurchaseIcBillStockEntry piBse;
        if (record.getEntry() == null) {
            piBse = new PurchaseIcBillStockEntry();
        } else {
            piBse = (PurchaseIcBillStockEntry)
                    JsonUtils.objConversion(record.getEntry(), PurchaseIcBillStockEntry.class);
        }
        piBse.setInList(poIds);
        //piBse
        List<PurchaseIcBillStockEntry> purchaseIcBillStockEntries =
                icBillStockEntryService.serviceSelectByIcBillStockEntry(piBse);

        if (!ListUtils.isList(purchaseIcBillStockEntries)) {
            return PageInfoUtils.returnPage(purchaseIcBillStocks);
        }
        for (int i = 0; i < poIds.size(); i++) {
            Long poId = poIds.get(i);
            List<PurchaseIcBillStockEntry> listNe = new ArrayList<>();
            for (PurchaseIcBillStockEntry ne : purchaseIcBillStockEntries) {
                if (poId.equals(ne.getSbId())) {
                    listNe.add(ne);
                }
            }
            purchaseIcBillStocks.get(i).setEntryList(listNe);
        }
        return PageInfoUtils.returnPage(purchaseIcBillStocks);
    }


    @Override
    @Transactional
    public ResponseBase serviceInsertIcBillStock(Map<String, Object> objectMap) {
        Object purchaseIcBillStockObj = objectMap.get("parentKey");
        Object purchaseIcBillStockEntryObj = objectMap.get("entry");
        Integer mid = (Integer) objectMap.get("mid");
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
            if (DateUtils.checkingTime(icBillStock.getDate(), sfpService.selDate(mid)) == null) {
                return JsonData.setResultError("已关账,存入失败");
            }
            //将时间戳转换成时间格式
            String[] strSplit = DateUtils.stampToDate(icBillStock.getDate()).split("-");
            icBillStock.setYears(Integer.parseInt(strSplit[0]));
            icBillStock.setPeriod(Integer.parseInt(strSplit[1]));
            int result = icBillStockMapper.insertIcBillStock((PurchaseIcBillStock) logStatusService.setObjStatusId(icBillStock));
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

    @Override
    @Transactional
    public ResponseBase serviceUpdateByIcBillStock(Map<String, Object> objectMap) {
        Object purchaseIcBillStockObj = objectMap.get("parentKey");
        Object purchaseIcBillStockEntryObj = objectMap.get("entry");
        if (purchaseIcBillStockEntryObj == null) {
            return JsonData.setResultError("error");
        }
        //拿到最外层入库通知单数据
        PurchaseIcBillStock icBillStock = (PurchaseIcBillStock)
                JsonUtils.objConversion(purchaseIcBillStockObj, PurchaseIcBillStock.class);
        int result = icBillStockMapper.updateByIcBillStock(icBillStock);
        JsonUtils.saveResult(result);
        //拿到采购订单表体数据
        JSONArray objects = JsonUtils.getJsonArr(purchaseIcBillStockEntryObj);
        List<PurchaseIcBillStockEntry> pIBSEntryList = new ArrayList<>();
        for (Object obj : objects) {
            PurchaseIcBillStockEntry icBillStockEntry = (PurchaseIcBillStockEntry) JsonUtils.objConversion(obj, PurchaseIcBillStockEntry.class);
            //如果是NULL新增数据
            if (icBillStockEntry.getSbeId() == null) {
                icBillStockEntry.setSbId(icBillStock.getSbId());
                pIBSEntryList.add(icBillStockEntry);
            } else {
                //更新子表数据
                icBillStockEntryService.serviceUpdateByIcBillStockEntry(icBillStockEntry);
            }
        }
        if (pIBSEntryList.size() > 0) {
            //新增数据库
            icBillStockEntryService.serviceInsertIcBillStockEntry(pIBSEntryList);
        }
        //通用更新消息
        return logStatusService.msgCodeUp(result, icBillStock.getSystemLogStatus());
    }
}
