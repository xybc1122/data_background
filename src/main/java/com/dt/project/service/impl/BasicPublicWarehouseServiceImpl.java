package com.dt.project.service.impl;

import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.basePublicMapper.BasicPublicWarehouseMapper;
import com.dt.project.model.basePublic.BasicPublicWarehouse;
import com.dt.project.model.parent.ParentTree;
import com.dt.project.service.basePublicService.BasicPublicWarehouseService;
import com.dt.project.service.SystemLogStatusService;
import com.dt.project.store.TreeStructureStore;
import com.dt.project.utils.JsonUtils;
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

    @Override
    public List<ParentTree> findByWarehouseInfo() {
        return TreeStructureStore.getTree(warehouseMapper.findByWarehouseInfo());
    }

    @Override
    @Transactional
    public ResponseBase serviceUpWarehouses(BasicPublicWarehouse war) {
        int result = warehouseMapper.upWarehouses(war);
        //通用更新消息
        return logStatusService.msgCodeUp(result, war.getSystemLogStatus());
    }

    @Override
    @Transactional
    public ResponseBase serviceDelWarehouses(Map<String, String> warMp) {
        int result = warehouseMapper.delWarehouses(warMp.get("thisIds"));
        return logStatusService.msgCodeDel(result, warMp);
    }

    @Override
    public ResponseBase serviceSaveWarehouses(BasicPublicWarehouse war) {
        //新增仓库数据
        int result = warehouseMapper.saveWarehouses((BasicPublicWarehouse) logStatusService.setObjStatusId(war));
        return JsonUtils.saveMsg(result);
    }

}
