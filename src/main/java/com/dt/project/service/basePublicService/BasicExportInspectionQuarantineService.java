package com.dt.project.service.basePublicService;

import com.dt.project.model.basePublic.BasicExportInspectionQuarantine;

import java.util.List;

/**
 * @ClassName BasicExportInspectionQuarantineService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 10:04
 **/
public interface BasicExportInspectionQuarantineService {


    /**
     * 查询检验检疫类别
     */
    List<BasicExportInspectionQuarantine> serviceFindByQuarantineInfo();
}
