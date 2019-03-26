package com.dt.user.controller.UserServiceController;

import com.dt.user.config.JsonData;
import com.dt.user.config.ResponseBase;
import com.dt.user.dto.HrEmployeeDto;
import com.dt.user.model.BasePublicModel.*;
import com.dt.user.model.HrArchives.HrArchivesDepartment;
import com.dt.user.model.HrArchives.HrArchivesEmployee;
import com.dt.user.model.ParentSysTemLog;
import com.dt.user.model.ParentTree;
import com.dt.user.service.BasePublicService.BasicHrEducationService;
import com.dt.user.service.BasePublicService.BasicHrEmployeeTypeService;
import com.dt.user.service.BasePublicService.BasicHrEmploymentTypeService;
import com.dt.user.service.BasePublicService.BasicHrLeaveTypeService;
import com.dt.user.service.HrArchivesDepartmentService;
import com.dt.user.service.HrArchivesEmployeeService;
import com.dt.user.utils.PageInfoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/staff")
public class HrArchivesController {
    @Autowired
    private HrArchivesEmployeeService hrService;
    @Autowired
    private HrArchivesDepartmentService departmentService;
    @Autowired
    private BasicHrEducationService educationService;
    @Autowired
    private BasicHrEmployeeTypeService employeeTypeService;
    @Autowired
    private BasicHrEmploymentTypeService employmentTypeService;
    @Autowired
    private BasicHrLeaveTypeService leaveTypeService;


    /**
     * 获得部门表树形数据
     */
    @GetMapping("/findByListDepartment")
    public ResponseBase findByListDepartment() {
        List<ParentTree> hrArchivesDepartmentList = departmentService.serviceGetDepartmentInfo();
        return JsonData.setResultSuccess(hrArchivesDepartmentList);
    }


    /**
     * 获得员工表动态查询信息
     */
    @PostMapping("/findByListEmployee")
    public ResponseBase findByListEmployee(@RequestBody HrEmployeeDto hrEmployeeDto) {
        PageInfoUtils.setPage(hrEmployeeDto.getPageSize(), hrEmployeeDto.getCurrentPage());
        return PageInfoUtils.returnPage(hrService.serviceGetEmployeeList(hrEmployeeDto), hrEmployeeDto.getCurrentPage());
    }

    /**
     * 获取员工信息 还没被注册的
     *
     * @return
     */
    @GetMapping("/getStaff")
    public ResponseBase getStaff() {
        List<HrArchivesEmployee> staffList = hrService.serviceGetHrEmployeeList();
        return JsonData.setResultSuccess(staffList);
    }


    /**
     * 获取学历类型
     *
     * @return
     */
    @GetMapping("/getEducation")
    public ResponseBase getEducation(@RequestParam("pageSize") Integer pageSize,
                                     @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        List<BasicHrEducation> hrEducations = educationService.serviceFindByListHrEdu();
        return PageInfoUtils.returnPage(hrEducations, currentPage);
    }

    /**
     * 获取员工类型
     *
     * @return
     */
    @GetMapping("/getEmployee")
    public ResponseBase getEmployee(@RequestParam("pageSize") Integer pageSize,
                                    @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        List<BasicHrEmployeeType> hrEmployeeTypeList = employeeTypeService.serviceFndByListHrEmp();
        return PageInfoUtils.returnPage(hrEmployeeTypeList, currentPage);
    }

    /**
     * 获取雇佣类型
     *
     * @return
     */
    @GetMapping("/getEmployment")
    public ResponseBase getEmployment(@RequestParam("pageSize") Integer pageSize,
                                      @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        List<BasicHrEmploymentType> hrEmploymentTypes = employmentTypeService.serviceFindByListHrEmployment();
        return PageInfoUtils.returnPage(hrEmploymentTypes, currentPage);
    }

    /**
     * 获取离职类型
     *
     * @return
     */
    @GetMapping("/getHrLeave")
    public ResponseBase getHrLeave(@RequestParam("pageSize") Integer pageSize,
                                   @RequestParam("currentPage") Integer currentPage) {
        PageInfoUtils.setPage(pageSize, currentPage);
        List<BasicHrLeaveType> hrLeaveTypes = leaveTypeService.serviceFindByListHrLeave();
        return PageInfoUtils.returnPage(hrLeaveTypes, currentPage);
    }

}
