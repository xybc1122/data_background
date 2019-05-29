package com.dt.project.service;

import java.util.List;

public interface GeneralPurposeService {


    /**
     * 批量删除出货通知单 /只做了字段更新
     *
     * @param ids
     * @return
     */
    int serviceDeleteByGeneral(List ids, String table, String thisId);
}
