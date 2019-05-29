package com.dt.project.service.systemService;


import com.dt.project.config.ResponseBase;

/**
 * @ClassName SystemFinalProcessingService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/23 9:36
 **/
public interface SystemFinalProcessingService {


    /**
     * 查询关账时间
     *
     * @return
     */
    ResponseBase selectByDateCheckout(Integer menuId);
}
