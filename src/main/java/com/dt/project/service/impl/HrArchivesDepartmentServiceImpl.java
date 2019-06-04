package com.dt.project.service.impl;

import com.dt.project.config.JsonData;
import com.dt.project.config.ResponseBase;
import com.dt.project.mapper.HrArchivesDepartmentMapper;
import com.dt.project.model.parent.ParentTree;
import com.dt.project.service.HrArchivesDepartmentService;
import com.dt.project.store.TreeStructureStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName HrArchivesDepartmentServiceImpl
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 9:55
 **/
@Service
public class HrArchivesDepartmentServiceImpl implements HrArchivesDepartmentService {

    @Autowired
    private HrArchivesDepartmentMapper departmentMapper;

    @Override
    public List<ParentTree> serviceGetDepartmentInfo() {
        return TreeStructureStore.getTree(departmentMapper.getDepartmentInfo());
    }

    @Override
    public ResponseBase serviceEmployeeName(Long uid) {
        return JsonData.setResultSuccess(departmentMapper.employeeName(uid));
    }

}
