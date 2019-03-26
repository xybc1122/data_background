package com.dt.user.service.BasePublicService;

import com.dt.user.model.BasePublicModel.BasicPublicCompanyOffshore;

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
