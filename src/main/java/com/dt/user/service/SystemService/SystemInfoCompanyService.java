package com.dt.user.service.SystemService;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.System.SystemInfoCompany;

/**
 * @ClassName SystemInfoCompanyService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/5/10 12:57
 **/
public interface SystemInfoCompanyService {


    /**
     * 新增公司 上传配置信息
     *
     * @param record
     * @return
     */
    ResponseBase serviceInsertCompany(SystemInfoCompany record);

    /**
     * 查询配置公司信息
     *
     * @param record
     * @return
     */

    ResponseBase serviceSelectByCompany(SystemInfoCompany record);
}
