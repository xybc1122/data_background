package com.dt.project.service.impl;

import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.systemMapper.SystemInfoCompanyMapper;
import com.dt.project.model.system.SystemInfoCompany;
import com.dt.project.service.SystemLogStatusService;
import com.dt.project.service.systemService.SystemInfoCompanyService;
import com.dt.project.utils.JsonUtils;
import com.dt.project.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
