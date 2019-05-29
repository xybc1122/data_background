package com.dt.project.service.basePublicService;

import com.dt.project.model.basePublicModel.BasicSalesAmazonCsvTxtXslHeader;

import java.util.List;

public interface BasicSalesAmazonCsvTxtXslHeaderService {

    /**
     * 通过seId获取 header信息
     *
     * @param seId
     * @return
     */
    List<String> headerList(Integer seId, Integer tbId, Integer areaId, Integer shopId);


    /**
     * 获得对象
     *
     * @param seId
     * @param tbId
     * @param areaId
     * @return
     */
    List<BasicSalesAmazonCsvTxtXslHeader> sqlHead(Integer seId, Integer tbId, Integer areaId, Integer shopId);

    /**
     * 查询获得导入模板
     */
    List<BasicSalesAmazonCsvTxtXslHeader> getImportTemplate(BasicSalesAmazonCsvTxtXslHeader csvTxtXslHeader);
}
