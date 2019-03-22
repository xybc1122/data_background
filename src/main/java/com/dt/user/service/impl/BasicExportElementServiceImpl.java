package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicExportElementMapper;
import com.dt.user.model.BasePublicModel.BasicExportElement;
import com.dt.user.service.BasePublicService.BasicExportElementService;
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
