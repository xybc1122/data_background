package com.dt.project.service.basePublicService;

import com.dt.project.model.parent.ParentTree;

import java.util.List;

public interface BasicLogisticsmgtTransportAbnormalTypeService {


    /**
     * 异常类型
     *
     * @return
     */

    List<ParentTree> serviceFindByListAbnormalType();
}
