package com.dt.project.service;

import com.dt.project.config.ResponseBase;
import com.dt.project.model.JavaSqlName;

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
