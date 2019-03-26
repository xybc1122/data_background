package com.dt.user.service.impl;

import com.dt.user.mapper.HrArchivesDepartmentMapper;
import com.dt.user.model.ParentTree;
import com.dt.user.service.HrArchivesDepartmentService;
import com.dt.user.store.TreeStructureStore;
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

}
