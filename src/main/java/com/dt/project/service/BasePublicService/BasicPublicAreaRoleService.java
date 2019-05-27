package com.dt.project.service.basePublicService;

import com.dt.project.config.ResponseBase;
import com.dt.project.dto.AreaRoleDto;


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
     * 通过aid 跟角色id 删除区域关联表信息
     *
     * @return
     */
    int serviceDeleteByARole(Integer aid, Integer rid);


    /**
     * 通过角色id 跟 区域id 查找  arid  用于删除 下面关联的站点
     *
     * @param aid
     * @param rid
     * @return
     */
    Integer serviceSelectArId(Integer aid, Integer rid);

}
