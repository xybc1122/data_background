package com.dt.user.service.impl;

import com.dt.user.config.ResponseBase;
import com.dt.user.mapper.SalesAmazonMapper.SalesShipNoticePackingListEntryMapper;
import com.dt.user.model.SalesAmazon.SalesShipNoticePackingListEntry;
import com.dt.user.service.SalesShipNoticePackingListEntryService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SalesShipNoticePackingListEntryServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/13 15:32
 **/
@Service
public class SalesShipNoticePackingListEntryServiceImpl implements SalesShipNoticePackingListEntryService {
    @Autowired
    private SalesShipNoticePackingListEntryMapper pLEMapper;

    @Override
    public ResponseBase serviceSelectPackingListEntry(SalesShipNoticePackingListEntry pLEntry) {
        PageInfoUtils.setPage(pLEntry.getPageSize(), pLEntry.getCurrentPage());
        List<SalesShipNoticePackingListEntry> pLEs = pLEMapper.selectPackingListEntry(pLEntry);
        if (pLEs == null || pLEs.size() == 0) {
            return null;
        }
        return PageInfoUtils.returnPage(pLEs, pLEntry.getCurrentPage());
    }
}
