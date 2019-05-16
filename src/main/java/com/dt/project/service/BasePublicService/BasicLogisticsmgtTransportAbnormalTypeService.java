package com.dt.project.service.BasePublicService;

import com.dt.project.model.Parent.ParentTree;

import java.util.List;

public interface BasicLogisticsmgtTransportAbnormalTypeService {


    /**
     * 异常类型
     *
     * @return
     */

    List<ParentTree> serviceFindByListAbnormalType();
}
