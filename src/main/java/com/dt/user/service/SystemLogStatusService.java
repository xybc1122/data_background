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
     * 查询 状态服务
     * @param statusId
     * @return
     */
    SystemLogStatus serviceFindSysStatusInfo(Long statusId);
    /**
     * 新增状态信息
     */
    SystemLogStatus serviceSaveSysStatusInfo();


    /**
     * 更新状态信息
     */
    int serviceUpSysStatusInfo(SystemLogStatus logStatus, Long statusId);

    /**
     * 删除数据 //更新
     * @param statusIds
     * @return
     */
    int delLogStatus(String statusIds);
}
