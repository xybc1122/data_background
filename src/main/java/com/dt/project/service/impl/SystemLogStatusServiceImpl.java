package com.dt.project.service.impl;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.exception.LsException;
import com.dt.project.mapper.systemMapper.SystemLogStatusMapper;
import com.dt.project.model.basePublicModel.*;
import com.dt.project.model.purchasePo.PurchasePoOrder;
import com.dt.project.model.system.SystemInfoCompany;
import com.dt.project.model.SystemLogStatus;
import com.dt.project.service.SystemLogStatusService;
import com.dt.project.store.SystemLogStatusStore;
import com.dt.project.utils.ReqUtils;
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

    @Override
    public SystemLogStatus serviceFindSysStatusInfo(Long statusId) {
        return logStatusMapper.findSysStatusInfo(statusId);
    }

    @Override
    public SystemLogStatus serviceSaveSysStatusInfo(SystemLogStatus status) {
        if (status == null) {
            status = new SystemLogStatus();
        }
        //设置创建时间
        status.setCreateDate(new Date().getTime());
        status.setCreateUser(ReqUtils.getUserName());
        logStatusMapper.saveSysStatusInfo(status);
        return status;
    }

    @Override
    public ResponseBase serviceUpSysStatusInfo(SystemLogStatus logStatus, Long statusId) {
        int sysResult = logStatusMapper.upSysStatusInfo(SystemLogStatusStore.setModify(logStatus, ReqUtils.getUserName(), statusId));
        if (sysResult <= 0) {
            throw new LsException("状态更新失败");
        }
        return JsonData.setResultSuccess("更新成功");
    }

    @Override
    public int delLogStatus(String statusIds) {
        return logStatusMapper.delLogStatus(statusIds);
    }


    @Override
    public ResponseBase msgCodeUp(int result, SystemLogStatus logStatus, Long statusId) {
        if (result != 0) {
            //删除缓存
            // redisService.delKey(Constants.STATUS_ID + statusId);
            //更新状态的修改信息
            return serviceUpSysStatusInfo(logStatus, statusId);
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
        SystemLogStatus logStatus;
        if (obj instanceof BasicPublicWarehouse) {
            //仓库
            BasicPublicWarehouse war = (BasicPublicWarehouse) obj;
            //新增状态
            logStatus = serviceSaveSysStatusInfo(war.getSystemLogStatus());
            war.setStatusId(logStatus.getStatusId());
            return war;
        } else if (obj instanceof BasicPublicCompany) {
            //公司
            BasicPublicCompany company = (BasicPublicCompany) obj;
            logStatus = serviceSaveSysStatusInfo(company.getSystemLogStatus());
            company.setStatusId(logStatus.getStatusId());
            return company;

        } else if (obj instanceof BasicPublicExchangeRate) {
            //汇率
            BasicPublicExchangeRate rate = (BasicPublicExchangeRate) obj;
            logStatus = serviceSaveSysStatusInfo(rate.getSystemLogStatus());
            rate.setStatusId(logStatus.getStatusId());
            return rate;
        } else if (obj instanceof BasicPublicProduct) {
            //产品信息
            BasicPublicProduct product = (BasicPublicProduct) obj;
            logStatus = serviceSaveSysStatusInfo(product.getSystemLogStatus());
            product.setStatusId(logStatus.getStatusId());
            return product;
        } else if (obj instanceof BasicPublicProducts) {
            //产品类目
            BasicPublicProducts products = (BasicPublicProducts) obj;
            logStatus = serviceSaveSysStatusInfo(products.getSystemLogStatus());
            products.setStatusId(logStatus.getStatusId());
            return products;
        } else if (obj instanceof SystemInfoCompany) {
            //公司页面信息配置表
            SystemInfoCompany company = (SystemInfoCompany) obj;
            logStatus = serviceSaveSysStatusInfo(company.getSystemLogStatus());
            company.setStatusId(logStatus.getStatusId());
            return company;
        } else if (obj instanceof PurchasePoOrder) {
            //公司页面信息配置表
            PurchasePoOrder poOrder = (PurchasePoOrder) obj;
            logStatus = serviceSaveSysStatusInfo(poOrder.getSystemLogStatus());
            poOrder.setStatusId(logStatus.getStatusId());
            return poOrder;
        }

        return null;
    }
}
