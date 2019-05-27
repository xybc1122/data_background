package com.dt.project.service.basePublicService;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.basePublicModel.BasicPublicWarehouse;
import com.dt.project.model.parent.ParentTree;

import java.util.List;
import java.util.Map;

public interface BasicPublicWarehouseService {

    /**
     * 查询仓库信息
     */
    List<ParentTree> findByWarehouseInfo();


    /**
     * 更新仓库信息
     */
    ResponseBase serviceUpWarehouses(BasicPublicWarehouse war);

    /**
     * 批量删除
     *
     * @param warMp
     * @return
     */
    ResponseBase serviceDelWarehouses(Map<String, String> warMp);

    /**
     * 新增仓库数据
     *
     * @param war
     * @return
     */
    ResponseBase serviceSaveWarehouses(BasicPublicWarehouse war);
}
