package com.dt.project.service.impl;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.dto.ProductDto;
import com.dt.project.mapper.BasePublicMapper.BasicPublicProductMapper;
import com.dt.project.model.BasePublicModel.BasicPublicProduct;
import com.dt.project.service.BasePublicService.BasicPublicProductService;
import com.dt.project.service.SystemLogStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class BasicPublicProductServiceImpl implements BasicPublicProductService {
    @Autowired
    private BasicPublicProductMapper productMapper;
    @Autowired
    private SystemLogStatusService logStatusService;

    @Override
    public List<ProductDto> findProductInfo(ProductDto productDto) {
        return productMapper.findProductInfo(productDto);
    }

    @Override
    @Transactional
    public ResponseBase serviceUpProduct(BasicPublicProduct product) {
        //如果有statusId 直接更新
        int result = productMapper.upProduct(product);
        //通用更新消息
        return logStatusService.msgCodeUp(result, product.getSystemLogStatus(), product.getStatusId());
    }

    @Override
    @Transactional
    public ResponseBase serviceDelProduct(Map<String, String> proMap) {
        int result = productMapper.delProduct(proMap.get("thisIds"));
        return logStatusService.msgCodeDel(result, proMap);
    }

    @Override
    public ResponseBase serviceSaveProduct(BasicPublicProduct product) {
        //新增仓库数据
        int result = productMapper.saveProduct((BasicPublicProduct) logStatusService.setObjStatusId(product));
        if (result != 0) {
            return JsonData.setResultSuccess("新增成功");
        }
        return JsonData.setResultError("新增失败");
    }
}
