package com.dt.project.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.exception.LsException;
import com.dt.project.mapper.salesAmazonMapper.SalesShipNoticeMapper;
import com.dt.project.model.basePublicModel.BasicSalesAmazonPaymentType;
import com.dt.project.model.salesAmazon.SalesShipNotice;
import com.dt.project.model.salesAmazon.SalesShipNoticeEntry;
import com.dt.project.service.GeneralPurposeService;
import com.dt.project.service.basePublicService.BasicSalesAmazonPaymentTypeService;
import com.dt.project.service.salesAmazonService.SalesShipNoticeEntryService;
import com.dt.project.service.salesAmazonService.SalesShipNoticeService;
import com.dt.project.toos.Constants;
import com.dt.project.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    private BasicSalesAmazonPaymentTypeService paymentTypeService;
    @Autowired
    private SalesShipNoticeEntryService nEService;
    @Autowired
    private RedisService redisService;

    @Override
    @SuppressWarnings("unchecked")  //(HashMap<String, Object>) result.getData(); 确认是这类型
    public ResponseBase selectSelectByNotice(SalesShipNotice notice) {
        PageInfoUtils.setPage(notice.getPageSize(), notice.getCurrentPage());
        List<SalesShipNotice> pnList = nMapper.selectByNotice(notice);
        if (!ListUtils.isList(pnList)) {
            return PageInfoUtils.returnPage(pnList, notice.getCurrentPage());
        }
        List<Long> shipIdList = new ArrayList<>();
        //查询付款类型
        List<BasicSalesAmazonPaymentType> typeList = paymentTypeService.serviceFindByListPayType();
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

        if (!ListUtils.isList(nEResults)) {
            return PageInfoUtils.returnPage(pnList, notice.getCurrentPage());
        }

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
        return PageInfoUtils.returnPage(pnList, notice.getCurrentPage());
    }

    @Override
    @Transactional
    public ResponseBase saveNotice(Map<String, Object> noMap) {
        Object salesShipNoticeObj = noMap.get("salesShipNotice");
        Object salesShipNoticeEntryObj = noMap.get("salesShipNoticeEntry");
        ObjUtils.isObjNull(salesShipNoticeObj, salesShipNoticeEntryObj);
        String identifier = null;
        try {
            identifier = redisService.lockRedis(Constants.SAVE_SHIP_NOTICE, 5000L, 20000L);
            if (StringUtils.isEmpty(identifier)) {
                return JsonData.setResultError("请等待有人正在操作");
            }
            //拿到出库通知单的最外层表数据
            SalesShipNotice salesShipNotice = (SalesShipNotice) JsonUtils.objConversion(salesShipNoticeObj, SalesShipNotice.class);
            //先查询重复数据
            if (nMapper.isItRedundant(salesShipNotice) != null) {
                return JsonData.setResultError("数据重复");
            }
            salesShipNotice.setCreateDate(new Date().getTime());
            salesShipNotice.setCreateUser(ReqUtils.getUserName());
            JsonUtils.saveResult(nMapper.insertShipNotice(salesShipNotice));

            //拿到出库通知单的表体数据
            JSONArray noticeEntryArr = JsonUtils.getJsonArr(salesShipNoticeEntryObj);

            List<SalesShipNoticeEntry> shipNoticeEntryList = new ArrayList<>();
            Long shipNoticeId = salesShipNotice.getShipNoticeId();
            //用来判断里面的skuId是否有相同的
            List<Long> listSkuId = new ArrayList<>();
            for (Object obj : noticeEntryArr) {
                SalesShipNoticeEntry shipNoticeEntry = (SalesShipNoticeEntry) JsonUtils.objConversion(obj, SalesShipNoticeEntry.class);
                //如果长度大于1 这里就要拿到集合里的SKU
                if (noticeEntryArr.size() > 1) {
                    listSkuId.add(shipNoticeEntry.getSkuId());
                }
                shipNoticeEntry.setShipNoticeId(shipNoticeId);
                shipNoticeEntryList.add(shipNoticeEntry);
            }

            if (ListUtils.isRepeat(listSkuId)) {
                throw new LsException("表体数据SKU重复");
            }
            if (shipNoticeEntryList.size() > 0) {
                nEService.insertShipNoticeEntry(shipNoticeEntryList);
            }
            return JsonData.setResultSuccess("success");
        } finally {
            if (StringUtils.isNotBlank(identifier)) {
                redisService.releaseLock(Constants.SAVE_SHIP_NOTICE, identifier);
            }
        }
    }


    @Override
    @Transactional
    public ResponseBase updateBySalesShipNoticeAndNoticeEntry(Map<String, Object> noMap) {
        Object salesShipNoticeObj = noMap.get("salesShipNotice");
        Object salesShipNoticeEntryObj = noMap.get("salesShipNoticeEntry");
        if (salesShipNoticeObj == null) {
            return JsonData.setResultError("error");
        }
        //拿到出库通知单的最外层表数据
        SalesShipNotice salesShipNotice = (SalesShipNotice) JsonUtils.objConversion(salesShipNoticeObj, SalesShipNotice.class);
        int result = nMapper.updateBySalesShipNotice(salesShipNotice);
        JsonUtils.saveResult(result);
        //拿到出库通知单的表体数据
        JSONArray noticeEntryArr = JsonUtils.getJsonArr(salesShipNoticeEntryObj);
        List<SalesShipNoticeEntry> salesShipNoticeEntries = new ArrayList<>();
        for (Object obj : noticeEntryArr) {
            SalesShipNoticeEntry shipNoticeEntry = (SalesShipNoticeEntry) JsonUtils.objConversion(obj, SalesShipNoticeEntry.class);
            //如果是NULL新增数据
            if (shipNoticeEntry.getEid() == null) {
                shipNoticeEntry.setShipNoticeId(salesShipNotice.getShipNoticeId());
                salesShipNoticeEntries.add(shipNoticeEntry);
            } else {
                nEService.serviceUpdateByNoticeEntry(shipNoticeEntry);
            }
        }
        if (salesShipNoticeEntries.size() > 0) {
            nEService.insertShipNoticeEntry(salesShipNoticeEntries);
        }
        return JsonData.setResultSuccess("success");
    }

//
//    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        boolean isRepeat = ListUtils.isRepeat(list);
//        system.out.println("list中包含重复元素：" + isRepeat);
//    }

}
