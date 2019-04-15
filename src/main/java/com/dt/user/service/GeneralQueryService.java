package com.dt.user.service;


import com.dt.user.config.ResponseBase;

import java.util.Map;

/**
 * @ClassName GeneralQueryService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/11 11:17
 **/
public interface GeneralQueryService {


    /**
     * 封装判断 statusId服务  通过用查询 状态ID
     */
    void statusIdExist(Object obj);

    /**
     * 通用查询接口
     */
    ResponseBase selType(String topType, Integer menuId);

}
