package com.dt.user.service.BasePublicService;

import com.dt.user.model.BasePublicModel.BasicHrEmploymentType;

import java.util.List;

/**
 * @ClassName BasicHrEmploymentTypeService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 14:26
 **/
public interface BasicHrEmploymentTypeService {

    /**
     * 查看雇佣类型
     *
     * @return
     */
    List<BasicHrEmploymentType> serviceFindByListHrEmployment();
}
