package com.dt.project.service.basePublicService;

import com.dt.project.model.basePublicModel.BasicPublicCompanyOffshore;

import java.util.List;

/**
 * @ClassName BasicPublicCompanyOffshoreService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 14:15
 **/
public interface BasicPublicCompanyOffshoreService {

    /**
     * 查看离岸公司
     *
     * @return
     */
    List<BasicPublicCompanyOffshore> serviceFindByListOffshore();
}
