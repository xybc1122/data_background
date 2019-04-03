package com.dt.user.mapper;

import com.dt.user.model.ParentTree;
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
            "`path`,`is_parent`,`del_flag`\n" +
            "FROM `hr_archives_department`")
    @Results({
            @Result(column = "dept_id", property = "treeId"),
            @Result(column = "dept_name", property = "treeName"),
    })
    List<ParentTree> getDepartmentInfo();
}
