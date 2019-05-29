package com.dt.project.service.impl;

import com.dt.project.mapper.salesAmazonMapper.SalesShipNoticeEntryMapper;
import com.dt.project.model.salesAmazon.SalesShipNoticeEntry;
import com.dt.project.service.JavaSqlNameService;
import com.dt.project.service.salesAmazonService.SalesShipNoticeEntryService;
import com.dt.project.utils.JsonUtils;
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
    public List<SalesShipNoticeEntry> serviceSelectByNoticeEntry(SalesShipNoticeEntry noticeEntry) {
        //这里放入缓存
        noticeEntry.setNameList(nameService.get("nEntry"));
        return nEMapper.selectByNoticeEntry(noticeEntry);
    }

    @Override
    public int insertShipNoticeEntry(List<SalesShipNoticeEntry> noticeEntryList) {
        int result = nEMapper.insertShipNoticeEntry(noticeEntryList);
        //校验是否成功
        JsonUtils.saveResult(result);
        return result;
    }

    @Override
    public List<Integer> serviceSelIsNull(List snIds) {
        return nEMapper.selIsNull(snIds);
    }
}
