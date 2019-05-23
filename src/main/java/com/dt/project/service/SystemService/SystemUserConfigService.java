package com.dt.project.service.SystemService;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.System.SystemUserConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName SystemUserConfigService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/20 10:11
 **/
public interface SystemUserConfigService {


    /**
     * 新增一个用户配置信息
     */
    Integer serviceSaveUserConfig(SystemUserConfig userConfig);

    /**
     * 新增用户配置信息
     *
     * @param confMap
     * @return
     */
    ResponseBase saveUserConfig(Map<String, Object> confMap);

    /**
     * 拿取用户配置信息
     *
     * @param mid
     * @return
     */
    ResponseBase getConfig(Integer mid);

    /**
     * 删除用户配置
     *
     * @param confMap
     * @return
     */
    ResponseBase delConfig(Map<String, Object> confMap);

    /**
     * 修改用户配置
     *
     * @param confMap
     * @return
     */
    ResponseBase upConfig(Map<String, Object> confMap);
}
