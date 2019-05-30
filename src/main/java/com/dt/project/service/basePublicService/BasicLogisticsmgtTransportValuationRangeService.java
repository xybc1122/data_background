package com.dt.project.service.basePublicService;

import com.dt.project.model.basePublicModel.BasicLogisticsmgtTransportValuationRange;

import java.util.List;

/**
 * @ClassName BasicLogisticsmgtTransportValuationRangeService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 9:36
 **/
public interface BasicLogisticsmgtTransportValuationRangeService {


    /**
     * 查询 计价范围
     *
     * @return
     */
    List<BasicLogisticsmgtTransportValuationRange> serviceFindByListValuationRange();
}
