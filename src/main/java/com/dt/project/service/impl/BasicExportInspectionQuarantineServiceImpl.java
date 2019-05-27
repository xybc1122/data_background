package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicExportInspectionQuarantineMapper;
import com.dt.project.model.basePublicModel.BasicExportInspectionQuarantine;
import com.dt.project.service.basePublicService.BasicExportInspectionQuarantineService;
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
