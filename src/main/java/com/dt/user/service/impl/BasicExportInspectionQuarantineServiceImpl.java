package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicExportInspectionQuarantineMapper;
import com.dt.user.model.BasePublicModel.BasicExportInspectionQuarantine;
import com.dt.user.service.BasePublicService.BasicExportInspectionQuarantineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicExportInspectionQuarantineServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 10:04
 **/
@Service
public class BasicExportInspectionQuarantineServiceImpl implements BasicExportInspectionQuarantineService {
    @Autowired
    private BasicExportInspectionQuarantineMapper quarantineMapper;

    @Override
    public List<BasicExportInspectionQuarantine> serviceFindByQuarantineInfo() {
        return quarantineMapper.findByQuarantineInfo();
    }
}
