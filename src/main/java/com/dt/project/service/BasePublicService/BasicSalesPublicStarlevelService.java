package com.dt.project.service.BasePublicService;

import com.dt.project.model.BasePublicModel.BasicSalesPublicStarlevel;

import java.util.List;

/**
 * @ClassName BasicSalesPublicStarlevelService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/20 13:37
 **/
public interface BasicSalesPublicStarlevelService {

    /**
     * 查询星级
     *
     * @return
     */
    List<BasicSalesPublicStarlevel> serviceFindByListStarlevel();
}