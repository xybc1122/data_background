package com.dt.user.service.BasePublicService;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.BasePublicModel.BasicPublicShopSite;

/**
 * @ClassName BasicPublicShopSiteService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/24 15:48
 **/
public interface BasicPublicShopSiteService {


    /**
     * 新增 配置角色 站点
     *
     * @param shopSite
     * @return
     */
    ResponseBase serviceInsertShopSite(BasicPublicShopSite shopSite);
}
