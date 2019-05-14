package com.dt.user.service.impl;

import com.dt.user.config.ResponseBase;
import com.dt.user.mapper.SalesAmazonMapper.SalesShipNoticeEntryMapper;
import com.dt.user.model.SalesAmazon.SalesShipNoticeEntry;
import com.dt.user.service.JavaSqlNameService;
import com.dt.user.service.SalesAmazonService.SalesShipNoticeEntryService;
import com.dt.user.utils.PageInfoUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SalesShipNoticeEntryServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/13 14:53
 **/
@Service
public class SalesShipNoticeEntryServiceImpl implements SalesShipNoticeEntryService {
    @Autowired
    private SalesShipNoticeEntryMapper nEMapper;
    @Autowired
    private JavaSqlNameService nameService;

    @Override
    public ResponseBase serviceSelectByNoticeEntry(SalesShipNoticeEntry noticeEntry) {
        //这里放入缓存
        noticeEntry.setNameList(nameService.get("nEntry"));
        List<SalesShipNoticeEntry> entryList = nEMapper.selectByNoticeEntry(noticeEntry);
        if (entryList == null || entryList.size() == 0) {
            return null;
        }
        return PageInfoUtils.returnPage(entryList, noticeEntry.getCurrentPage());
    }
}
