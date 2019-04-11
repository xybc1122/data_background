package com.dt.user.service.impl;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.exception.LsException;
import com.dt.user.mapper.BasePublicMapper.BasicPublicWarehouseMapper;
import com.dt.user.model.BasePublicModel.BasicPublicWarehouse;
import com.dt.user.model.ParentTree;
import com.dt.user.model.SystemLogStatus;
import com.dt.user.service.BasePublicService.BasicPublicWarehouseService;
import com.dt.user.service.GeneralQueryService;
import com.dt.user.service.SystemLogStatusService;
import com.dt.user.store.TreeStructureStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BasicPublicWarehouseServiceImpl implements BasicPublicWarehouseService {
    @Autowired
    private BasicPublicWarehouseMapper warehouseMapper;
    @Autowired
    private SystemLogStatusService logStatusService;
    @Autowired
    private GeneralQueryService queryService;

    @Override
    public List<ParentTree> findByWarehouseInfo() {
        return TreeStructureStore.getTree(warehouseMapper.findByWarehouseInfo());
    }

    @Override
    @Transactional
    public ResponseBase serviceUpWarehouses(BasicPublicWarehouse war) {
        int result;
        //如果前端传来的是null
        if (war.getStatusId() == null) {
            //先去数据库查一下是否真的为null
            Long statusIdSql = queryService.serviceGetStatusId(war);
            //如果 = null 说明里面确实是空的
            if (statusIdSql != null) {
                return JsonData.setResultError("statusId参数为空");
            }
            //新增 状态
            SystemLogStatus logStatus = logStatusService.serviceSaveSysStatusInfo();
            war.setStatusId(logStatus.getStatusId());
            //更新信息
            result = warehouseMapper.upWarehouses(war);

        } else {
            //如果有statusId 直接更新
            result = warehouseMapper.upWarehouses(war);
        }
        if (result != 0) {
            //更新状态的修改信息
            logStatusService.serviceUpSysStatusInfo(war.getSystemLogStatus(), war.getStatusId());
            return JsonData.setResultSuccess("更新成功");
        }
        throw new LsException("更新失败");
    }

    @Override
    @Transactional
    public ResponseBase serviceDelWarehouses(Map<String, String> warMp) {
        int result = warehouseMapper.delWarehouses(warMp.get("warIds"));
        if (result != 0) {
            //更新状态的修改信息
            System.out.println(warMp.get("statusIds"));
            logStatusService.delLogStatus(warMp.get("statusIds"));
            return JsonData.setResultSuccess("删除成功");
        }
        throw new LsException("删除失败");
    }

    @Override
    public ResponseBase serviceSaveWarehouses(BasicPublicWarehouse war) {
        //新增 状态
        SystemLogStatus logStatus = logStatusService.serviceSaveSysStatusInfo();
        war.setStatusId(logStatus.getStatusId());
        //新增仓库数据
        int result = warehouseMapper.saveWarehouses(war);
        if (result != 0) {
            return JsonData.setResultSuccess("新增成功");
        }
        return JsonData.setResultError("新增失败");
    }

}
