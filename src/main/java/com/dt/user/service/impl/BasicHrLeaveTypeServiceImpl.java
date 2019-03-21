package com.dt.user.service.impl;

import com.dt.user.mapper.BasePublicMapper.BasicHrLeaveTypeMapper;
import com.dt.user.model.BasePublicModel.BasicHrLeaveType;
import com.dt.user.service.BasePublicService.BasicHrLeaveTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName BasicHrLeaveTypeServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/19 14:28
 **/
@Service
public class BasicHrLeaveTypeServiceImpl implements BasicHrLeaveTypeService {
    @Autowired
    private BasicHrLeaveTypeMapper hrLeaveTypeMapper;

    @Override
    public List<BasicHrLeaveType> serviceFindByListHrLeave() {
        return hrLeaveTypeMapper.findByListHrLeave();
    }
}
