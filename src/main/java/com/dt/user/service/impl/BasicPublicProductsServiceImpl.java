package com.dt.user.service.impl;

import com.dt.user.config.ResponseBase;
import com.dt.user.mapper.BasePublicMapper.BasicPublicProductsMapper;
import com.dt.user.model.BasePublicModel.BasicPublicProducts;
import com.dt.user.model.ParentTree;
import com.dt.user.service.BasePublicService.BasicPublicProductsService;
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
        int result;
        //如果前端传来的是null
        if (products.getStatusId() == null) {
            //更新信息
            result = productsMapper.upProducts((BasicPublicProducts) logStatusService.setObjStatusId(products, Constants.UP));
        } else {
            //如果有statusId 直接更新
            result = productsMapper.upProducts(products);
        }
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
        int result = productsMapper.saveProducts((BasicPublicProducts) logStatusService.setObjStatusId(products, Constants.SAVE));
        return JsonUtils.saveMsg(result);
    }
}
