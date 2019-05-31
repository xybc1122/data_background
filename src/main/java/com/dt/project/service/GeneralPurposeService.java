package com.dt.project.service;

import com.dt.project.config.ResponseBase;

import java.util.List;
import java.util.Map;

public interface GeneralPurposeService {


    /**
     * 通用批量删除 /只做了字段更新
     *
     * @param ids
     * @return
     */
    int serviceDeleteByGeneral(List ids, String table, String thisId);


    /**
     * 通用  父ID查询子ID下面是否还有节点
     *
     * @return
     */
    List<Integer> serviceSelIsNull(List ids, String table, String thisId);


    ResponseBase universalDelete(Map<String, Object> strMap);
}
