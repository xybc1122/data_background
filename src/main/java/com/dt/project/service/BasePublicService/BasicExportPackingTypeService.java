package com.dt.project.service.BasePublicService;

import com.dt.project.model.BasePublicModel.BasicExportPackingType;

import java.util.List;

/**
 * @ClassName BasicExportPackingTypeService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 8:46
 **/
public interface BasicExportPackingTypeService {



    /**
     * 查询包装种类
     */
    List<BasicExportPackingType> serviceFindByPackingTypeInfo();


}
