package com.dt.project.mapper;

import com.dt.project.model.UserRole;
import com.dt.project.provider.UserRoleProvider;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper {
    /**
     * 设置角色信息
     *
     * @return
     */
    @InsertProvider(type = UserRoleProvider.class, method = "addUserRole")
    int addUserRole(@Param("userRoleList") List<UserRole> userRoleList);


    /**
     * 移除角色
     */
    @Delete("DELETE FROM `system_user_role_user`WHERE r_id = #{rid} and u_id= #{uid}")
    int delUserRole(@Param("rid") Long rid, @Param("uid") Long uid);
}