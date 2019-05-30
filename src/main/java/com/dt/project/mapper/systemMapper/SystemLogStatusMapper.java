package com.dt.project.mapper.systemMapper;

import com.dt.project.model.SystemLogStatus;
import com.dt.project.provider.SystemLogStatusProvider;
import org.apache.ibatis.annotations.*;

public interface SystemLogStatusMapper {
    /**
     * 通用查询状态
     *
     * @param statusId
     * @return
     */
    @Select("SELECT\n" +
            "`status_id`,`remark`,`status`,\n" +
            "`create_date`,`create_user`,`modify_date`,\n" +
            "`modify_user`,`audit_date`,`audit_user`\n" +
            "FROM `system_log_status` where status_id = #{statusId}")
    SystemLogStatus findSysStatusInfo(@Param("statusId") Long statusId);

    /**
     * 新增状态信息
     */
    @Insert("INSERT INTO `system_log_status`\n" +
            "(`remark`,`create_date`,`create_user`,`modify_date`,`modify_user`,`audit_date`,`audit_user`)" +
            "VALUES (#{remark},#{createDate},#{createUser},#{modifyDate},#{modifyUser},#{auditDate},#{auditUser})")
    @Options(useGeneratedKeys = true, keyProperty = "statusId", keyColumn = "status_id")
    int saveSysStatusInfo(SystemLogStatus logStatus);

    /**
     * 更新状态信息
     */
    @UpdateProvider(type = SystemLogStatusProvider.class, method = "upLogStatusPro")
    int upSysStatusInfo(SystemLogStatus logStatus);

    /**
     * 批量删除数据/更新
     */
    @UpdateProvider(type = SystemLogStatusProvider.class, method = "delLogStatusPro")
    int delLogStatus(@Param("statusIds") String statusIds);
}
