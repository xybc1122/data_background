package com.dt.user.service.BasePublicService;

import com.dt.user.config.ResponseBase;
import com.dt.user.dto.AreaRoleDto;

/**
 * @ClassName BasicPublicAreaRoleService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/28 10:49
 **/
public interface BasicPublicAreaRoleService {


    /**
     * 存入配置 角色 区域数据
     *
     * @param record
     * @return
     */

    ResponseBase serviceInsertARole(AreaRoleDto record);

    /**
     * 删除接口
     *
     * @param record
     * @return
     */
    int serviceDeleteByARole(AreaRoleDto record);
}
