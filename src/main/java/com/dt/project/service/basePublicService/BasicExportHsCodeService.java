package com.dt.project.service.basePublicService;

import com.dt.project.model.basePublicModel.BasicExportHsCode;

import java.util.List;

/**
 * @ClassName BasicExportHsCodeService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 11:15
 **/
public interface BasicExportHsCodeService {
    /**
     * 查询出口管理-HS Code
     * @return
     */
    List<BasicExportHsCode> serviceFindByListHsCode(BasicExportHsCode hsCode);
}
