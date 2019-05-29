package com.dt.project.service.impl;

import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.basePublicMapper.BasicPublicProductsMapper;
import com.dt.project.model.basePublicModel.BasicPublicProducts;
import com.dt.project.model.parent.ParentTree;
import com.dt.project.service.basePublicService.BasicPublicProductsService;
import com.dt.project.service.SystemLogStatusService;
import com.dt.project.store.TreeStructureStore;
import com.dt.project.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BasicPublicProductsServiceImpl implements BasicPublicProductsService {
    @Autowired
    private BasicPublicProductsMapper productsMapper;
    @Autowired
    private SystemLogStatusService logStatusService;

    @Override
    public List<ParentTree> serviceFindByProductsInfo() {
        return TreeStructureStore.getTree(productsMapper.findByProductsInfo());
    }

    @Override
    @Transactional
    public ResponseBase serviceUpProducts(BasicPublicProducts products) {
            //如果有statusId 直接更新
        int result = productsMapper.upProducts(products);
        //通用更新消息
        return logStatusService.msgCodeUp(result, products.getSystemLogStatus(), products.getStatusId());
    }

    @Override
    @Transactional
    public ResponseBase serviceDelProducts(Map<String, String> delMap) {
        int result = productsMapper.delProducts(delMap.get("thisIds"));
        return logStatusService.msgCodeDel(result, delMap);
    }

    @Override
    public ResponseBase serviceSaveProducts(BasicPublicProducts products) {
        //新增仓库数据
        int result = productsMapper.saveProducts((BasicPublicProducts) logStatusService.setObjStatusId(products));
        return JsonUtils.saveMsg(result);
    }
}
