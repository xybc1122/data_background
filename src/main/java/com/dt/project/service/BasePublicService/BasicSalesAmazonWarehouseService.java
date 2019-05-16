package com.dt.project.service.BasePublicService;

import com.dt.project.model.BasePublicModel.BasicSalesAmazonWarehouse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BasicSalesAmazonWarehouseService {

    /**
     * 通过fc 查找站点ID 仓库id
     *
     * @return
     */
    BasicSalesAmazonWarehouse getWarehouse(@Param("fc") String fc);

    /**
     * 查询亚马逊-亚马逊仓库'
     */
    List<BasicSalesAmazonWarehouse> serviceFindByListAmazonWarehouse(BasicSalesAmazonWarehouse warehouse);

}
