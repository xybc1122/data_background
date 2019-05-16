package com.dt.project.service.BasePublicService;

import com.dt.project.model.BasePublicModel.BasicPublicAreaRoleSite;

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


    /**
     * 通过 区域 角色表id  删除下面的站点
     *
     * @param arId
     * @param seId
     * @return
     */
    int serviceDeleteARS(Integer arId, Integer seId);

}
