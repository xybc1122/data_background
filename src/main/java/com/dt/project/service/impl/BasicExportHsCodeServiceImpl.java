package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicExportHsCodeMapper;
import com.dt.project.model.basePublicModel.BasicExportHsCode;
import com.dt.project.service.basePublicService.BasicExportHsCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicExportHsCodeServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 11:16
 **/
@Service
public class BasicExportHsCodeServiceImpl implements BasicExportHsCodeService {
    @Autowired
    private BasicExportHsCodeMapper hsCodeMapper;

    @Override
    public List<BasicExportHsCode> serviceFindByListHsCode(BasicExportHsCode hsCode) {
        return hsCodeMapper.findByListHsCode(hsCode);
    }
}
