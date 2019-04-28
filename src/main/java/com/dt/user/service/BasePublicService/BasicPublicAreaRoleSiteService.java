package com.dt.user.service.BasePublicService;

import com.dt.user.model.BasePublicModel.BasicPublicAreaRoleSite;

/**
 * @ClassName BasicPublicAreaRoleSiteService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/28 13:01
 **/
public interface BasicPublicAreaRoleSiteService {

    /**
     * 添加 区域 角色配置表id 跟站点id
     *
     * @param record
     * @return
     */

    int serviceInsertARSInfo(BasicPublicAreaRoleSite record);
}
