package com.dt.project.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.purchaseMapper.PurchasePoOrderMapper;
import com.dt.project.model.purchasePo.PurchasePoOrder;
import com.dt.project.model.purchasePo.PurchasePoOrderEntry;
import com.dt.project.redis.RedisService;
import com.dt.project.service.SystemLogStatusService;
import com.dt.project.service.purchaseService.PurchasePoOrderEntryService;
import com.dt.project.service.purchaseService.PurchasePoOrderService;
import com.dt.project.toos.Constants;
import com.dt.project.utils.JsonUtils;
import com.dt.project.utils.ListUtils;
import com.dt.project.utils.ObjUtils;
import com.dt.project.utils.PageInfoUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName PurchasePoOrderServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/27 10:06
 **/
@Service
public class PurchasePoOrderServiceImpl implements PurchasePoOrderService {
    @Autowired
    private PurchasePoOrderMapper poOrderMapper;
    @Autowired
    private PurchasePoOrderEntryService poOrderEntryService;
    @Autowired
    private RedisService redisService;
    @Autowired
    private SystemLogStatusService logStatusService;

    @Override
    public ResponseBase serviceSelectByPoOrder(PurchasePoOrder record) {
        PageInfoUtils.setPage(record.getPageSize(), record.getCurrentPage());
        //查询 采购订单表体
        record.setJsonArray(redisService.getRedisJson("pPO",PurchasePoOrder.class));
        List<PurchasePoOrder> purchasePoOrders = poOrderMapper.selectByPoOrder(record);

        if (!ListUtils.isList(purchasePoOrders)) {
            return PageInfoUtils.returnPage(purchasePoOrders);
        }

        List<Long> poIds = new ArrayList<>();
        for (PurchasePoOrder poOrder : purchasePoOrders) {
            poIds.add(poOrder.getPoId());
        }

        PurchasePoOrderEntry poOrderEntry;
        if (record.getEntry() == null) {
            poOrderEntry = new PurchasePoOrderEntry();
        } else {
            poOrderEntry = (PurchasePoOrderEntry) JsonUtils.objConversion(record.getEntry(), PurchasePoOrderEntry.class);
        }
        poOrderEntry.setInList(poIds);
        //查询表体
        List<PurchasePoOrderEntry> ppoEntry = poOrderEntryService.serviceSelectByPoOrderEntry(poOrderEntry);

        if (!ListUtils.isList(ppoEntry)) {
            return PageInfoUtils.returnPage(purchasePoOrders);
        }

        for (int i = 0; i < poIds.size(); i++) {
            Long poId = poIds.get(i);
            List<PurchasePoOrderEntry> listNe = new ArrayList<>();
            for (PurchasePoOrderEntry ne : ppoEntry) {
                if (poId.equals(ne.getPoId())) {
                    listNe.add(ne);
                }
            }
            purchasePoOrders.get(i).setEntryList(listNe);
        }

        return PageInfoUtils.returnPage(purchasePoOrders);
    }

    @Override
    @Transactional
    public ResponseBase serviceInsertPoOrder(Map<String, Object> objectMap) {
        Object parentKey = objectMap.get("parentKey");
        Object entry = objectMap.get("entry");
        ObjUtils.isObjNull(parentKey, entry);
        String identifier = null;
        try {
            identifier = redisService.lockRedis(Constants.SAVE_PURCHASE_PO_ORDER, 5000L, 20000L);
            if (StringUtils.isEmpty(identifier)) {
                return JsonData.setResultError("请等待有人正在操作");
            }
            //拿到采购订单的最外层表数据
            PurchasePoOrder purchasePoOrder = (PurchasePoOrder) JsonUtils.objConversion(parentKey, PurchasePoOrder.class);
            int result = poOrderMapper.insertPoOrder((PurchasePoOrder) logStatusService.setObjStatusId(purchasePoOrder));
            JsonUtils.saveResult(result);

            Long poId = purchasePoOrder.getPoId();
            //拿到采购订单表体数据
            JSONArray objects = JsonUtils.getJsonArr(entry);
            List<PurchasePoOrderEntry> poOrderEntryList = new ArrayList<>();
            for (Object obj : objects) {
                PurchasePoOrderEntry poOrderEntry = (PurchasePoOrderEntry) JsonUtils.objConversion(obj, PurchasePoOrderEntry.class);
                poOrderEntry.setPoId(poId);
                poOrderEntryList.add(poOrderEntry);
            }
            if (poOrderEntryList.size() > 0) {
                //插入数据库
                poOrderEntryService.serviceInsertPoOrderEntry(poOrderEntryList);
            }
            return JsonData.setResultSuccess("success");
        } finally {
            if (StringUtils.isNotBlank(identifier)) {
                redisService.releaseLock(Constants.SAVE_PURCHASE_PO_ORDER, identifier);
            }
        }
    }


    @Override
    @Transactional
    public ResponseBase serviceUpdateByPoOrder(Map<String, Object> objectMap) {
        Object parentKey = objectMap.get("parentKey");
        Object entry = objectMap.get("entry");
        if (entry == null) {
            return JsonData.setResultError("error");
        }
        //拿到最外层采购订单数据
        PurchasePoOrder purchasePoOrder = (PurchasePoOrder)
                JsonUtils.objConversion(parentKey, PurchasePoOrder.class);
        int result = poOrderMapper.updateByPoOrder(purchasePoOrder);
        JsonUtils.saveResult(result);
        //拿到采购订单表体数据
        JSONArray objects = JsonUtils.getJsonArr(entry);
        List<PurchasePoOrderEntry> poOrderEntryList = new ArrayList<>();
        for (Object obj : objects) {
            PurchasePoOrderEntry poOrderEntry = (PurchasePoOrderEntry) JsonUtils.objConversion(obj, PurchasePoOrderEntry.class);
            //如果是NULL新增数据
            if (poOrderEntry.getPoeId() == null) {
                poOrderEntry.setPoId(purchasePoOrder.getPoId());
                poOrderEntryList.add(poOrderEntry);
            } else {
                //更新子表数据
                poOrderEntryService.serviceUpdateByPoOrderEntry(poOrderEntry);
            }
        }
        if (poOrderEntryList.size() > 0) {
            //新增数据库
            poOrderEntryService.serviceInsertPoOrderEntry(poOrderEntryList);
        }
        //通用更新消息
        return logStatusService.msgCodeUp(result, purchasePoOrder.getSystemLogStatus());
    }
}
