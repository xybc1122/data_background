package com.dt.user.service.BasePublicService;

import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportFreightLevel;
import com.dt.user.model.ParentTree;

import java.util.List;

/**
 * @ClassName BasicLogisticsmgtTransportFreightLevelService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 16:43
 **/
public interface BasicLogisticsmgtTransportFreightLevelService {
    /**
     * 查询运价等级
     */
    List<ParentTree> serviceFindByFreightLevelInfo();

}
