package com.dt.user.service.BasePublicService;

import com.dt.user.config.ResponseBase;
import com.dt.user.dto.ProductDto;
import com.dt.user.model.BasePublicModel.BasicPublicProduct;
import com.dt.user.provider.BasicPublicProductProvider;
import org.apache.ibatis.annotations.UpdateProvider;

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
