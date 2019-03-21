package com.dt.user.service.BasePublicService;

import com.dt.user.model.BasePublicModel.BasicPublicPlatformType;

import java.util.List;

/**
 * @ClassName BasicPublicPlatformTypeService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 16:26
 **/
public interface BasicPublicPlatformTypeService {

    /**
     * 查平台类型
     *
     * @return
     */
    List<BasicPublicPlatformType> serviceFindByListPlatform();
}
