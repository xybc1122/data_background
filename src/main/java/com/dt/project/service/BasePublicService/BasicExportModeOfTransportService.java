package com.dt.project.service.BasePublicService;

import com.dt.project.model.BasePublicModel.BasicExportModeOfTransport;

import java.util.List;

/**
 * @ClassName BasicExportModeOfTransportService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/25 9:37
 **/
public interface BasicExportModeOfTransportService {

    /**
     * 查询运输方式
     */
    List<BasicExportModeOfTransport> serviceFindByModeOfInfo();
}
