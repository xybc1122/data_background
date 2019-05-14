package com.dt.user.service;

import com.dt.user.config.ResponseBase;
import com.dt.user.model.JavaSqlName;
import com.dt.user.model.Parent.ParentUploadInfo;

import java.util.List;


/**
 * @ClassName JavaSqlNameService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/4/19 14:42
 **/
public interface JavaSqlNameService {

    /**
     * 新增 JavaSqlName
     *
     * @param javaSqlName
     * @return
     */
    ResponseBase serviceSet(JavaSqlName javaSqlName);

    /**
     * 查询
     *
     * @param model
     * @return
     */
    List<JavaSqlName> get(String model);
}
