package com.dt.project.service.BasePublicService;

import com.dt.project.config.ResponseBase;
import com.dt.project.dto.ProductDto;
import com.dt.project.model.BasePublicModel.BasicPublicProduct;

import java.util.List;
import java.util.Map;

public interface BasicPublicProductService {


    /**
     * 查询产品物料信息
     */
    List<ProductDto> findProductInfo(ProductDto productDto);


    /**
     * 更新产品信息 信息
     */
    ResponseBase serviceUpProduct(BasicPublicProduct product);

    /**
     * 批量删除数据/更新
     */
    ResponseBase serviceDelProduct(Map<String, String> mapDel);

    /**
     * 新增
     *
     * @param product
     * @return
     */
    ResponseBase serviceSaveProduct(BasicPublicProduct product);
}
