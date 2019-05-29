package com.dt.project.service.impl;

import com.dt.project.mapper.basePublicMapper.BasicSalesAmazonCsvTxtXslHeaderMapper;
import com.dt.project.model.basePublicModel.BasicSalesAmazonCsvTxtXslHeader;
import com.dt.project.service.basePublicService.BasicSalesAmazonCsvTxtXslHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicSalesAmazonCsvTxtXslHeaderServiceImpl implements BasicSalesAmazonCsvTxtXslHeaderService {
    @Autowired
    private BasicSalesAmazonCsvTxtXslHeaderMapper headerMapper;

    @Override
    public List<String> headerList(Integer seId, Integer tbId, Integer areaId, Integer shopId) {
        return headerMapper.headerList(seId, tbId, areaId, shopId);
    }

    @Override
    public List<BasicSalesAmazonCsvTxtXslHeader> sqlHead(Integer seId, Integer tbId, Integer areaId, Integer shopId) {
        return headerMapper.sqlHead(seId, tbId, areaId, shopId);
    }

    @Override
    public List<BasicSalesAmazonCsvTxtXslHeader> getImportTemplate(BasicSalesAmazonCsvTxtXslHeader csvTxtXslHeader) {
        return headerMapper.getImportTemplate(csvTxtXslHeader);
    }
}
