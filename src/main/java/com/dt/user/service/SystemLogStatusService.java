package com.dt.user.service;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.SystemLogStatus;

import java.util.Map;

/**
 * @ClassName SystemLogStatusService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 14:55
 **/
public interface SystemLogStatusService {
    /**
     * 查询 状态服务
     *
     * @param statusId
     * @return
     */
    SystemLogStatus serviceFindSysStatusInfo(Long statusId);

    /**
     * 新增状态信息
     */
    SystemLogStatus serviceSaveSysStatusInfo(SystemLogStatus status);


    /**
     * 更新状态信息
     */
    int serviceUpSysStatusInfo(SystemLogStatus logStatus, Long statusId);

    /**
     * 删除数据 //更新
     */
    int delLogStatus(String statusIds);

    /**
     * 封装更新状态返回
     */
    ResponseBase msgCodeUp(int result, SystemLogStatus logStatus, Long statusId);

    /**
     * 封装删除状态返回
     */
    ResponseBase msgCodeDel(int result, Map<String, String> dataMap);

    /**
     * obj 设置statusId
     *
     * @param obj
     * @return
     */
    Object setObjStatusId(Object obj, String status);
}
