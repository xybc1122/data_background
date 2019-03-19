package com.dt.user.service.BasePublicService;

import com.dt.user.model.BasePublicModel.BasicHrLeaveType;

import java.util.List;

/**
 * @ClassName BasicHrLeaveTypeService
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 14:26
 **/
public interface BasicHrLeaveTypeService {
    /**
     * 查看离职类型
     *
     * @return
     */
    List<BasicHrLeaveType> serviceFindByListHrLeave();
}
