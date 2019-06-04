package com.dt.project.mapper;

import com.dt.project.model.hrArchives.HrArchivesDepartment;
import com.dt.project.model.parent.ParentTree;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName HrArchivesDepartmentMapper
 * Description TODO
 * @Author 陈恩惠
 * @Date 2019/3/26 9:50
 **/
public interface HrArchivesDepartmentMapper {


    /**
     * 查询部门
     *
     * @return
     */
    @Select("SELECT\n" +
            "`dept_id`,`dept_name`,`dept_name_eng`,`parent_id`,\n" +
            "`path`,`parent_node_is`\n" +
            "FROM `hr_archives_department`")
    @Results({
            @Result(column = "dept_id", property = "treeId"),
            @Result(column = "dept_name", property = "treeName"),
    })
    List<ParentTree> getDepartmentInfo();


    /**
     * 通过 uid 去查找员工部门
     *
     * @return
     */
    @Select("SELECT hd.`dept_id`,`dept_name`\n" +
            "FROM `hr_archives_department` AS hd\n" +
            "LEFT JOIN `hr_archives_employee` AS he ON he.`dept_id`=hd.`dept_id` WHERE he.`u_id`=#{uid}")
    @Results({
            @Result(column = "dept_id", property = "treeId"),
            @Result(column = "dept_name", property = "treeName"),
    })
    HrArchivesDepartment employeeName(@Param("uid") Long uid);
}
