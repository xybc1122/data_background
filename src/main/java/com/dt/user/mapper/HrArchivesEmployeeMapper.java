package com.dt.user.mapper;

import com.dt.user.dto.HrEmployeeDto;
import com.dt.user.model.HrArchives.HrArchivesEmployee;
import com.dt.user.provider.HrArchivesEmployeeProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;

public interface HrArchivesEmployeeMapper {
    /**
     * 获得员工信息 没有关联用户的
     */
    @Select("SELECT`s_id`,`employee_name`\n" +
            "FROM `hr_archives_employee`\n" +
            "WHERE `is_in_service` = true AND u_id IS NULL")
    List<HrArchivesEmployee> getHrEmployeeList();


    /**
     * 获取动态查询员工表信息
     */
    @SelectProvider(type = HrArchivesEmployeeProvider.class, method = "findEmployee")
    @Results({
            //数据库字段映射 //数据库字段映射 column数据库字段 property Java 字段
            @Result(column = "status_id", property = "systemLogStatus",
                    one = @One(
                            select = "com.dt.user.mapper.SystemLogStatusMapper.findSysStatusInfo",
                            fetchType = FetchType.EAGER
                    )
            )
    })
    List<HrArchivesEmployee> getEmployeeList(HrEmployeeDto employeeDto);


    /**
     * 绑定用户id跟员工id信息
     */
    @Update("UPDATE `hr_archives_employee`SET `u_id` = #{uid} WHERE `s_id` = #{sid}")
    int bindHrInfo(@Param("uid") Long uid, @Param("sid") Long sid);


    /**
     * 更新员工表信息
     */
    @UpdateProvider(type = HrArchivesEmployeeProvider.class, method = "upHrArchives")
    int upHrInfo(Map<String, Object> mapStaff);

}
