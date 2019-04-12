package com.dt.user.service.impl;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.exception.LsException;
import com.dt.user.mapper.SystemLogStatusMapper;
import com.dt.user.model.BasePublicModel.BasicPublicCompany;
import com.dt.user.model.BasePublicModel.BasicPublicExchangeRate;
import com.dt.user.model.BasePublicModel.BasicPublicWarehouse;
import com.dt.user.model.SystemLogStatus;
import com.dt.user.service.GeneralQueryService;
import com.dt.user.service.SystemLogStatusService;
import com.dt.user.store.SystemLogStatusStore;
import com.dt.user.utils.ReqUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

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
    @Autowired
    private GeneralQueryService queryService;


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


    @Override
    public ResponseBase msgCodeUp(int result, SystemLogStatus logStatus, Long statusId) {
        if (result != 0) {
            //更新状态的修改信息
            serviceUpSysStatusInfo(logStatus, statusId);
            return JsonData.setResultSuccess("更新成功");
        }
        return JsonData.setResultError("更新失败");
    }

    @Override
    public ResponseBase msgCodeDel(int result, Map<String, String> dataMap) {
        if (result != 0) {
            //更新状态的修改信息
            delLogStatus(dataMap.get("statusIds"));
            return JsonData.setResultSuccess("删除成功");
        }
        throw new LsException("删除失败");
    }

    @Override
    public Object setObjStatusId(Object obj) {
        //先去数据库查询
        queryService.statusIdExist(obj);
        SystemLogStatus logStatus = serviceSaveSysStatusInfo();

        if (obj instanceof BasicPublicWarehouse) {
            //仓库
            BasicPublicWarehouse war = (BasicPublicWarehouse) obj;
            war.setStatusId(logStatus.getStatusId());
            return war;
        } else if (obj instanceof BasicPublicCompany) {
            //公司
            BasicPublicCompany company = (BasicPublicCompany) obj;
            company.setStatusId(logStatus.getStatusId());
            return company;
        } else if (obj instanceof BasicPublicExchangeRate) {
            BasicPublicExchangeRate rate = (BasicPublicExchangeRate) obj;
            rate.setStatusId(logStatus.getStatusId());
            return rate;
        }
        //汇率
        return null;
    }
}
