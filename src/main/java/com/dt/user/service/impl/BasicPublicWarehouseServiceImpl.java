package com.dt.user.service.impl;

import com.dt.user.config.ResponseBase;
import com.dt.user.mapper.BasePublicMapper.BasicPublicWarehouseMapper;
import com.dt.user.model.BasePublicModel.BasicPublicWarehouse;
import com.dt.user.model.Parent.ParentTree;
import com.dt.user.service.BasePublicService.BasicPublicWarehouseService;
import com.dt.user.service.SystemLogStatusService;
import com.dt.user.store.TreeStructureStore;
import com.dt.user.toos.Constants;
import com.dt.user.utils.JsonUtils;
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
        return logStatusService.msgCodeUp(result, war.getSystemLogStatus(), war.getStatusId());
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
