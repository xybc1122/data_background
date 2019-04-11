package com.dt.user.service.impl;

import com.dt.user.mapper.SystemLogStatusMapper;
import com.dt.user.model.SystemLogStatus;
import com.dt.user.service.SystemLogStatusService;
import com.dt.user.store.SystemLogStatusStore;
import com.dt.user.utils.ReqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName SystemLogStatusServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 14:55
 **/
@Service
public class SystemLogStatusServiceImpl implements SystemLogStatusService {
    @Autowired
    private SystemLogStatusMapper logStatusMapper;


    @Override
    public SystemLogStatus serviceFindSysStatusInfo(Long statusId) {
        return logStatusMapper.findSysStatusInfo(statusId);
    }

    @Override
    public SystemLogStatus serviceSaveSysStatusInfo() {
        //新增 通用状态
        SystemLogStatus logStatus = new SystemLogStatus();
        //设置创建时间
        logStatus.setCreateDate(new Date().getTime());
        logStatus.setCreateUser(ReqUtils.getUserName());
        logStatusMapper.saveSysStatusInfo(logStatus);
        return logStatus;
    }

    @Override
    public int serviceUpSysStatusInfo(SystemLogStatus logStatus, Long statusId) {
        return logStatusMapper.upSysStatusInfo(SystemLogStatusStore.setModify(logStatus, ReqUtils.getUserName(), statusId));
    }

    @Override
    public int delLogStatus(String statusIds) {
        return logStatusMapper.delLogStatus(statusIds);
    }
}
