package com.dt.user.service.impl;

import com.dt.user.mapper.SystemLogStatusMapper;
import com.dt.user.model.SystemLogStatus;
import com.dt.user.service.SystemLogStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public int serviceSaveSysStatusInfo(SystemLogStatus logStatus) {
        return logStatusMapper.saveSysStatusInfo(logStatus);
    }
}
