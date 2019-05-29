package com.dt.project.service.impl;

import com.dt.project.mapper.purchaseMapper.PurchasePoOrderEntryMapper;
import com.dt.project.model.purchasePo.PurchasePoOrderEntry;
import com.dt.project.service.JavaSqlNameService;
import com.dt.project.service.purchaseService.PurchasePoOrderEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PurchasePoOrderEntryServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/27 10:25
 **/
@Service
public class PurchasePoOrderEntryServiceImpl implements PurchasePoOrderEntryService {
    @Autowired
    private PurchasePoOrderEntryMapper poOrderEntryMapper;
    @Autowired
    private JavaSqlNameService nameService;

    @Override
    public List<PurchasePoOrderEntry> serviceSelectByPoOrderEntry(PurchasePoOrderEntry record) {
        record.setJavaSqlName(nameService.get("pOEntry"));
        return poOrderEntryMapper.selectByPoOrderEntry(record);
    }
}
