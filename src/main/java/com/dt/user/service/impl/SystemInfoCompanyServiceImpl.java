package com.dt.user.service.impl;

import com.dt.user.config.ResponseBase;
import com.dt.user.mapper.SystemMapper.SystemInfoCompanyMapper;
import com.dt.user.model.System.SystemInfoCompany;
import com.dt.user.service.SystemLogStatusService;
import com.dt.user.service.SystemService.SystemInfoCompanyService;
import com.dt.user.utils.JsonUtils;
import com.dt.user.utils.PageInfoUtils;
import com.dt.user.utils.ReqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @ClassName SystemInfoCompanyServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/10 12:58
 **/
@Service
public class SystemInfoCompanyServiceImpl implements SystemInfoCompanyService {
    @Autowired
    private SystemInfoCompanyMapper cMapper;
    @Autowired
    private SystemLogStatusService logStatusService;


    @Override
    @Transactional
    public ResponseBase serviceInsertCompany(SystemInfoCompany c) {
        //新增公司页面配置数据数据
        int result = cMapper.insertCompany((SystemInfoCompany) logStatusService.setObjStatusId(c));
        return JsonUtils.saveMsg(result);
    }

    @Override
    public ResponseBase serviceSelectByCompany(SystemInfoCompany record) {
        PageInfoUtils.setPage(record.getPageSize(), record.getCurrentPage());
        return PageInfoUtils.returnPage(cMapper.selectByCompany(record), record.getCurrentPage());
    }
}
