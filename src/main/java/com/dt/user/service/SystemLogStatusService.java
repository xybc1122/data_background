package com.dt.user.service;

import com.dt.user.model.SystemLogStatus;

/**
 * @ClassName SystemLogStatusService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 14:55
 **/
public interface SystemLogStatusService {

    /**
     * 新增状态信息
     */
    int serviceSaveSysStatusInfo(SystemLogStatus logStatus);
}
