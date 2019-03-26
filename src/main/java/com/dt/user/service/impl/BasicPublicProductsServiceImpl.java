package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicPublicProductsMapper;

import com.dt.user.model.ParentTree;
import com.dt.user.service.BasePublicService.BasicPublicProductsService;
import com.dt.user.store.TreeStructureStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicPublicProductsServiceImpl implements BasicPublicProductsService {
    @Autowired
    private BasicPublicProductsMapper productsMapper;


    @Override
    public List<ParentTree> serviceFindByProductsInfo() {
        return TreeStructureStore.getTree(productsMapper.findByProductsInfo());
    }
}
