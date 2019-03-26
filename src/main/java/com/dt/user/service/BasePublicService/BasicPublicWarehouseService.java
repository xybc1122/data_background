package com.dt.user.service.BasePublicService;
import com.dt.user.model.ParentTree;

import java.util.List;

public interface BasicPublicWarehouseService {

    /**
     * 查询仓库信息
     */
    List<ParentTree> findByWarehouseInfo();

}
