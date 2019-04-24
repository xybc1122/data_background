package com.dt.user.service.BasePublicService;

import com.dt.user.model.Parent.ParentTree;

import java.util.List;

public interface BasicLogisticsmgtTransportAbnormalTypeService {


    /**
     * 异常类型
     *
     * @return
     */

    List<ParentTree> serviceFindByListAbnormalType();
}
