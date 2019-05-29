package com.dt.project.service.impl;

import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.purchaseMapper.PurchasePoOrderMapper;
import com.dt.project.model.purchasePo.PurchasePoOrder;
import com.dt.project.model.purchasePo.PurchasePoOrderEntry;
import com.dt.project.oa.service.ActivitiService;
import com.dt.project.oa.service.OrderProcessService;
import com.dt.project.service.purchaseService.PurchasePoOrderEntryService;
import com.dt.project.service.purchaseService.PurchasePoOrderService;
import com.dt.project.utils.ListUtils;
import com.dt.project.utils.PageInfoUtils;
import com.dt.project.utils.ReqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private ActivitiService activitiService;
    private static final String PURCHASE_ORDER = "purchaseOrder";

    @Override
    public ResponseBase serviceSelectByPoOrder(PurchasePoOrder record) {
        PageInfoUtils.setPage(record.getPageSize(), record.getCurrentPage());
        //查询 采购订单表体
        List<PurchasePoOrder> purchasePoOrders = poOrderMapper.selectByPoOrder(record);

        if (!ListUtils.isList(purchasePoOrders)) {
            return PageInfoUtils.returnPage(purchasePoOrders, record.getCurrentPage());
        }

        List<Long> poIds = new ArrayList<>();
        for (PurchasePoOrder poOrder : purchasePoOrders) {
            poIds.add(poOrder.getPoId());
        }
        PurchasePoOrderEntry poOrderEntry = record.getPoOrderEntry();
        poOrderEntry.setInList(poIds);
        //查询表体
        List<PurchasePoOrderEntry> purchasePoOrderEntrieList = poOrderEntryService.serviceSelectByPoOrderEntry(poOrderEntry);

        if (!ListUtils.isList(purchasePoOrderEntrieList)) {
            return PageInfoUtils.returnPage(purchasePoOrders, record.getCurrentPage());
        }

        for (int i = 0; i < poIds.size(); i++) {
            Long poId = poIds.get(i);
            List<PurchasePoOrderEntry> listNe = new ArrayList<>();
            for (PurchasePoOrderEntry ne : purchasePoOrderEntrieList) {
                if (poId.equals(ne.getPoId())) {
                    listNe.add(ne);
                }
            }
            purchasePoOrders.get(i).setPoOrderEntryList(listNe);
        }

        return PageInfoUtils.returnPage(purchasePoOrders, record.getCurrentPage());
    }

    @Override
    public int serviceSavePoOrder(Map<String, Object> objectMap) {
        activitiService.startProcess(PURCHASE_ORDER, ReqUtils.getUserName(), objectMap);
        return 0;
    }

}
