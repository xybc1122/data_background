package com.dt.project.service.basePublicService;

import com.dt.project.model.basePublicModel.BasicSalesPublicBrushType;

import java.util.List;

/**
 * @ClassName BasicSalesPublicBrushTypeService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 15:59
 **/
public interface BasicSalesPublicBrushTypeService {

    /**
     * 查询刷单类型
     */
    List<BasicSalesPublicBrushType> serviceFindByBrushTypeInfo();
}
