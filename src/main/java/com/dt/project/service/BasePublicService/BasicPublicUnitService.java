package com.dt.project.service.basePublicService;

import com.dt.project.model.parent.ParentTree;

import java.util.List;

/**
 * @ClassName BasicPublicUnitService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 9:11
 **/
public interface BasicPublicUnitService {


    /**
     * 查询计量单位
     *
     * @return
     */
    List<ParentTree> serviceFindByListUnit();
}
