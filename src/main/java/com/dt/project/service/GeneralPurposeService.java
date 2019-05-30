package com.dt.project.service;

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

    /**
     * 通用设置删除父级接口
     *
     * @param printList
     * @param table
     * @param thisId
     * @return
     */
    Map<String, List<Integer>> delParent(List<Integer> printList, String table, String thisId, String childTable);
}
