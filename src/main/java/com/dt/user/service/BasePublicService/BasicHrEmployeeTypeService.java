package com.dt.user.service.BasePublicService;

import com.dt.user.model.BasePublicModel.BasicHrEmployeeType;

import java.util.List;

/**
 * @ClassName BasicHrEmployeeTypeService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 14:25
 **/
public interface BasicHrEmployeeTypeService {

    /**
     * 查看员工类型
     * @return
     */
    List<BasicHrEmployeeType> serviceFndByListHrEmp();

}
