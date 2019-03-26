package com.dt.user.service.BasePublicService;

import com.dt.user.model.ParentTree;

import java.util.List;

/**
 * @ClassName BasicLogisticsmgtTransportValuationMethodService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 16:56
 **/
public interface BasicLogisticsmgtTransportValuationMethodService {

    /**
     * 查询计价类型
     */
    List<ParentTree> serviceFindByValuationMethodInfo();
}
