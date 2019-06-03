package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicExportElementMapper;
import com.dt.project.model.basePublic.BasicExportElement;
import com.dt.project.service.basePublicService.BasicExportElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicExportElementServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 13:07
 **/
@Service
public class BasicExportElementServiceImpl implements BasicExportElementService {
    @Autowired
    private BasicExportElementMapper elementMapper;

    @Override
    public List<BasicExportElement> serviceFindByListElement(BasicExportElement element) {
        return elementMapper.findByListElement(element);
    }
}
