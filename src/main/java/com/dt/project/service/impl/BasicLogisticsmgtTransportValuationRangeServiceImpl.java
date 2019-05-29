package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicLogisticsmgtTransportValuationRangeMapper;
import com.dt.project.model.basePublicModel.BasicLogisticsmgtTransportValuationRange;
import com.dt.project.service.basePublicService.BasicLogisticsmgtTransportValuationRangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @ClassName BasicLogisticsmgtTransportValuationRangeServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 9:41
 **/
@Service
public class BasicLogisticsmgtTransportValuationRangeServiceImpl implements BasicLogisticsmgtTransportValuationRangeService {
    @Autowired
    private BasicLogisticsmgtTransportValuationRangeMapper rangeMapper;

    @Override
    public List<BasicLogisticsmgtTransportValuationRange> serviceFindByListValuationRange() {
        return rangeMapper.findByListValuationRange();
    }
}
