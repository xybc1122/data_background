package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicLogisticsmgtTransportValuationRangeMapper;
import com.dt.user.model.BasePublicModel.BasicLogisticsmgtTransportValuationRange;
import com.dt.user.service.BasePublicService.BasicLogisticsmgtTransportValuationRangeService;
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
