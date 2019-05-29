package com.dt.project.service.basePublicService;

import com.dt.project.model.basePublicModel.BasicPublicProvinceRelation;

import java.util.List;

/**
 * @ClassName BasicPublicProvinceRelationService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/21 10:51
 **/
public interface BasicPublicProvinceRelationService {

    /**
     * 查询省州关联数据
     */
    List<BasicPublicProvinceRelation> serviceFindByRelationList(BasicPublicProvinceRelation relation);
}
