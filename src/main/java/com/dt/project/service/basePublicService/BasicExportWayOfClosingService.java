package com.dt.project.service.basePublicService;

import com.dt.project.model.basePublic.BasicExportWayOfClosing;

import java.util.List;

/**
 * @ClassName BasicExportWayOfClosingService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 10:32
 **/
public interface BasicExportWayOfClosingService {



    /**
     * 查询成交方式
     */
    List<BasicExportWayOfClosing> serviceFindByWayOfInfo();
}
