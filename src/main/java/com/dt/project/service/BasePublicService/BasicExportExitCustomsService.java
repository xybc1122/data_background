package com.dt.project.service.BasePublicService;

import com.dt.project.model.BasePublicModel.BasicExportExitCustoms;

import java.util.List;

/**
 * @ClassName BasicExportExitCustomsService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 10:53
 **/
public interface BasicExportExitCustomsService {



    /**
     * 查询出口管理-出境口岸
     */
    List<BasicExportExitCustoms> serviceFindByExitCustomsList(BasicExportExitCustoms customs);
}
