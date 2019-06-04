package com.dt.project.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.purchaseMapper.PurchasePoReceiptNoticeMapper;
import com.dt.project.model.purchasePo.PurchasePoOrderEntry;
import com.dt.project.model.purchasePo.PurchasePoReceiptNotice;
import com.dt.project.model.purchasePo.PurchasePoReceiptNoticeEntry;
import com.dt.project.service.SystemLogStatusService;
import com.dt.project.service.purchaseService.PurchasePoReceiptNoticeEntryService;
import com.dt.project.service.purchaseService.PurchasePoReceiptNoticeService;
import com.dt.project.toos.Constants;
import com.dt.project.utils.JsonUtils;
import com.dt.project.utils.ListUtils;
import com.dt.project.utils.ObjUtils;
import com.dt.project.utils.PageInfoUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    @Autowired
    private RedisService redisService;
    @Autowired
    private SystemLogStatusService logStatusService;

    @Override
    public ResponseBase serviceSelectByPoReceiptNotice(PurchasePoReceiptNotice record) {
        PageInfoUtils.setPage(record.getPageSize(), record.getCurrentPage());
        List<PurchasePoReceiptNotice> receiptNoticeList = poReceiptNoticeMapper.selectByPoReceiptNotice(record);

        if (!ListUtils.isList(receiptNoticeList)) {
            return PageInfoUtils.returnPage(receiptNoticeList);
        }
        List<Long> poIds = new ArrayList<>();
        for (PurchasePoReceiptNotice receiptNotice : receiptNoticeList) {
            poIds.add(receiptNotice.getRnId());
        }
        PurchasePoReceiptNoticeEntry ppRne;
        if (record.getEntry() == null) {
            ppRne = new PurchasePoReceiptNoticeEntry();
        } else {
            ppRne = (PurchasePoReceiptNoticeEntry)
                    JsonUtils.objConversion(record.getEntry(), PurchasePoReceiptNoticeEntry.class);
        }
        ppRne.setInList(poIds);
        //查询表体
        List<PurchasePoReceiptNoticeEntry> purchasePoReceiptNoticeEntries =
                receiptNoticeEntryService.serviceSelectByPRNoticeEntry(ppRne);

        if (!ListUtils.isList(purchasePoReceiptNoticeEntries)) {
            return PageInfoUtils.returnPage(receiptNoticeList);
        }
        for (int i = 0; i < poIds.size(); i++) {
            Long poId = poIds.get(i);
            List<PurchasePoReceiptNoticeEntry> listNe = new ArrayList<>();
            for (PurchasePoReceiptNoticeEntry ne : purchasePoReceiptNoticeEntries) {
                if (poId.equals(ne.getRnId())) {
                    listNe.add(ne);
                }
            }
            receiptNoticeList.get(i).setEntryList(listNe);
        }
        return PageInfoUtils.returnPage(receiptNoticeList);
    }


    @Override
    @Transactional
    public ResponseBase serviceInsertPoReceiptNotice(Map<String, Object> objectMap) {
        Object purchasePoReceiptNoticeObj = objectMap.get("parentKey");
        Object purchasePoReceiptNoticeEntryObj = objectMap.get("entry");
        ObjUtils.isObjNull(purchasePoReceiptNoticeObj, purchasePoReceiptNoticeEntryObj);
        String identifier = null;
        try {
            identifier = redisService.lockRedis(Constants.SAVE_PURCHASE_RECEIPT_NOTICE, 5000L, 20000L);
            if (StringUtils.isEmpty(identifier)) {
                return JsonData.setResultError("请等待有人正在操作");
            }
            //拿到最外层收货通知单数据
            PurchasePoReceiptNotice purchasePoOrder = (PurchasePoReceiptNotice)
                    JsonUtils.objConversion(purchasePoReceiptNoticeObj, PurchasePoReceiptNotice.class);

            int result = poReceiptNoticeMapper.insertPoReceiptNotice((PurchasePoReceiptNotice) logStatusService.setObjStatusId(purchasePoOrder));
            JsonUtils.saveResult(result);

            Long rnId = purchasePoOrder.getRnId();
            //拿到采购订单表体数据
            JSONArray objects = JsonUtils.getJsonArr(purchasePoReceiptNoticeEntryObj);
            List<PurchasePoReceiptNoticeEntry> poReceiptNoticeEntryList = new ArrayList<>();
            for (Object obj : objects) {
                PurchasePoReceiptNoticeEntry poReceiptNoticeEntry = (PurchasePoReceiptNoticeEntry) JsonUtils.objConversion(obj, PurchasePoReceiptNoticeEntry.class);
                poReceiptNoticeEntry.setRnId(rnId);
                poReceiptNoticeEntryList.add(poReceiptNoticeEntry);
            }
            if (poReceiptNoticeEntryList.size() > 0) {
                //新增数据库
                receiptNoticeEntryService.serviceInsertReceiptNoticeEntry(poReceiptNoticeEntryList);
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
    public ResponseBase serviceUpdateByPoReceiptNotice(Map<String, Object> objectMap) {
        Object purchasePoReceiptNoticeObj = objectMap.get("parentKey");
        Object purchasePoReceiptNoticeEntryObj = objectMap.get("entry");
        if (purchasePoReceiptNoticeObj == null) {
            return JsonData.setResultError("error");
        }
        //拿到最外层收货通知单数据
        PurchasePoReceiptNotice purchasePoOrder = (PurchasePoReceiptNotice)
                JsonUtils.objConversion(purchasePoReceiptNoticeObj, PurchasePoReceiptNotice.class);
        int result = poReceiptNoticeMapper.updateByPoReceiptNotice(purchasePoOrder);
        JsonUtils.saveResult(result);
        //拿到采购订单表体数据
        JSONArray objects = JsonUtils.getJsonArr(purchasePoReceiptNoticeEntryObj);
        List<PurchasePoReceiptNoticeEntry> receiptNoticeEntryList = new ArrayList<>();

        for (Object obj : objects) {
            PurchasePoReceiptNoticeEntry poReceiptNoticeEntry = (PurchasePoReceiptNoticeEntry) JsonUtils.objConversion(obj, PurchasePoReceiptNoticeEntry.class);
            //如果是NULL新增数据
            if (poReceiptNoticeEntry.getRneId() == null) {
                poReceiptNoticeEntry.setRnId(purchasePoOrder.getRnId());
                receiptNoticeEntryList.add(poReceiptNoticeEntry);
            } else {
                //更新子表数据
                receiptNoticeEntryService.serviceUpdateByReceiptNoticeEntry(poReceiptNoticeEntry);
            }
        }
        if (receiptNoticeEntryList.size() > 0) {
            //新增数据库
            receiptNoticeEntryService.serviceInsertReceiptNoticeEntry(receiptNoticeEntryList);
        }
        //通用更新消息
        return logStatusService.msgCodeUp(result, purchasePoOrder.getSystemLogStatus());
    }


}
