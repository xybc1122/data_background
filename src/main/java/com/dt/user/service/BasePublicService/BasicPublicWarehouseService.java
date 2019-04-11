package com.dt.user.service.BasePublicService;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.BasePublicModel.BasicPublicWarehouse;
import com.dt.user.model.ParentTree;
import com.dt.user.provider.WarehouseInfoProvider;
import org.apache.ibatis.annotations.UpdateProvider;

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
