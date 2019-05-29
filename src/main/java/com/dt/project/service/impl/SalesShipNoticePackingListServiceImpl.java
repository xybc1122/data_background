package com.dt.project.service.impl;

import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.salesAmazonMapper.SalesShipNoticePackingListMapper;
import com.dt.project.model.salesAmazon.SalesShipNoticePackingList;
import com.dt.project.model.salesAmazon.SalesShipNoticePackingListEntry;
import com.dt.project.service.SalesShipNoticePackingListEntryService;
import com.dt.project.service.salesAmazonService.SalesShipNoticePackingListService;
import com.dt.project.utils.ListUtils;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SalesShipNoticePackingListServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/29 9:25
 **/
@Service
public class SalesShipNoticePackingListServiceImpl implements SalesShipNoticePackingListService {
    @Autowired
    private SalesShipNoticePackingListMapper pListMapper;

    @Autowired
    private SalesShipNoticePackingListEntryService packingListEntryService;

    @Override
    public ResponseBase serviceSelectNoticePackingList(SalesShipNoticePackingList record) {
        PageInfoUtils.setPage(record.getPageSize(), record.getCurrentPage());
        List<SalesShipNoticePackingList> sNPackingLists = pListMapper.selectNoticePackingList(record);

        if (!ListUtils.isList(sNPackingLists)) {
            return PageInfoUtils.returnPage(sNPackingLists, record.getCurrentPage());
        }

        List<Long> pIdList = new ArrayList<>();
        for (SalesShipNoticePackingList packingList : sNPackingLists) {
            pIdList.add(packingList.getPackinglistId());
        }


        SalesShipNoticePackingListEntry shipNoticePackingListEntry = record.getShipNoticePackingListEntry();
        shipNoticePackingListEntry.setInShipNoticeList(pIdList);

        List<SalesShipNoticePackingListEntry> salesShipNoticePackingListEntries = packingListEntryService.serviceSelectPackingListEntry(shipNoticePackingListEntry);

        if (!ListUtils.isList(salesShipNoticePackingListEntries)) {
            return PageInfoUtils.returnPage(sNPackingLists, record.getCurrentPage());
        }

        for (int i = 0; i < pIdList.size(); i++) {
            List<SalesShipNoticePackingListEntry> listNe = new ArrayList<>();
            Long pid = pIdList.get(i);
            for (SalesShipNoticePackingListEntry nPLE : salesShipNoticePackingListEntries) {
                if (pid.equals(nPLE.getPackingListId())) {
                    listNe.add(nPLE);
                }
            }
            sNPackingLists.get(i).setListEntries(listNe);
        }

        return PageInfoUtils.returnPage(sNPackingLists, record.getCurrentPage());
    }
}
