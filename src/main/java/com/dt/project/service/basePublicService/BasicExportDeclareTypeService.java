package com.dt.project.service.basePublicService;

import com.dt.project.model.basePublicModel.BasicExportDeclareType;

import java.util.List;

/**
 * @ClassName BasicExportDeclareTypeService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 13:18
 **/
public interface BasicExportDeclareTypeService {
    /**
     * 查询报关类型
     *
     * @return
     */
    List<BasicExportDeclareType> serviceFindByListDeclare();
}
