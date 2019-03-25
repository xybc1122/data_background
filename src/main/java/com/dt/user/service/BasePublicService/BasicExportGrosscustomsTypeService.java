package com.dt.user.service.BasePublicService;

import com.dt.user.model.BasePublicModel.BasicExportGrosscustomsType;

import java.util.List;

/**
 * @ClassName BasicExportGrosscustomsTypeService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/22 13:24
 **/
public interface BasicExportGrosscustomsTypeService {
    /**
     * 查询清关类型
     * @return
     */
    List<BasicExportGrosscustomsType> serviceFindByListGrosscustoms();
}
