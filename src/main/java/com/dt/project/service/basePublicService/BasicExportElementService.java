package com.dt.project.service.basePublicService;

import com.dt.project.model.basePublicModel.BasicExportElement;

import java.util.List;

/**
 * @ClassName BasicExportElementService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 13:06
 **/
public interface BasicExportElementService {


    /**
     * 查询出口管理-HS Code
     *
     * @return
     */
    List<BasicExportElement> serviceFindByListElement(BasicExportElement element);

}
