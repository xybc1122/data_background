package com.dt.project.mapper;

import com.dt.project.model.dto.UserDto;
import com.dt.project.model.UserInfo;
import com.dt.project.provider.UserProvider;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;
import java.util.Map;


public interface UserMapper {
    /**
     * 通过uId查找 userName
     */
    @Select("select user_name  from system_user_info where uid=#{uId}")
    String getName(@Param("uId") Long uId);

    /**
     * 查询用户 状态
     *
     * @param uid
     * @return
     */
    @Select("select account_Status ,del_or_not,is_first_login  from system_user_info where uid=#{uid}")
    UserInfo getUserStatus(@Param("uid") Long uid);

    /**
     * 查找用户信息
     *
     * @param userName
     * @return
     */
    @Select("SELECT uid, user_name,pwd,STATUS,user_expiration_date,pwd_validity_period,\n" +
            "account_Status,`name`,u.del_or_not,is_first_login,GROUP_CONCAT(DISTINCT ur.r_id ) AS rId  FROM system_user_info AS u\n" +
            "INNER JOIN `system_user_role_user` AS ur ON ur.u_id = u.uid where user_name=#{userName}")
    UserInfo findByUser(@Param("userName") String userName);

    /**
     * 查找所有用户信息
     */
    @Select("select uid ,user_name  from system_user_info")
    List<UserInfo> getByUsers();

    /**
     * 查找 账号管理信息
     */
    @SelectProvider(type = UserProvider.class, method = "findUsers")
    List<UserInfo> findByUsers(UserDto pageDto);

    /**
     * 更新登陆时间
     */
    @Update("UPDATE `system_user_info`\n" +
            "SET `landing_time` = #{landingTime}\n" +
            "WHERE `uid` = #{uId};")
    int upUserLandingTime(@Param("uId") Long uId, @Param("landingTime") Long landingTime);


    /**
     * 通过 id查询 用户 跟角色  一对多
     */
    @Select("SELECT uid,user_name,`status`,`name` FROM system_user_info WHERE uid=#{uid}")
    @Results({
            @Result(id = true, column = "uid", property = "uid"),
            @Result(column = "uid", property = "roles",
                    many = @Many(
                            select = "com.dt.project.mapper.RoleMapper.getAllRolesByUid",
                            fetchType = FetchType.LAZY
                    )
            )
    })
    UserInfo getSingleUser(@Param("uid") Long uid);

    /**
     * 更新用户信息
     */
    @UpdateProvider(type = UserProvider.class, method = "upUserInfo")
    int upUser(Map<String, Object> userMap);

    /**
     * 单个删除或批量删除用户信息
     */
    @UpdateProvider(type = UserProvider.class, method = "delUserInfo")
    int delUserInfo(@Param("uidIds") String uidIds);

    /**
     * 单个恢复或批量恢复用户信息
     */
    @UpdateProvider(type = UserProvider.class, method = "reUserInfo")
    int reUserInfo(@Param("uidIds") String uidIds);

    /**
     * 查询被删除的用户信息
     */
    @Select("select uid, user_name,modify_date,name from system_user_info where del_or_not=1")
    List<UserInfo> findByDelUserInfo();

    /**
     * 注册用户验证用户是否存在
     */
    @Select("SELECT uid FROM system_user_info WHERE user_name=#{userName}")
    UserInfo getUserName(@Param("userName") String userName);

    /**
     * 新增一个用户
     */
    @Insert("insert into system_user_info(user_name,pwd,user_expiration_date,pwd_validity_period,name,is_first_login,remark,create_date,create_user) "
            + "values(#{userName},#{pwd},#{userExpirationDate},#{pwdValidityPeriod},#{name},#{isFirstLogin},#{remark},#{createDate},#{createUser})")
    @Options(useGeneratedKeys = true, keyProperty = "uid", keyColumn = "uid")
    int saveUserInfo(UserInfo userInfo);

    /**
     * 首次登陆 密码更新
     *
     * @return
     */
    @Update("UPDATE `system_user_info`\n" +
            "SET\n" +
            "`pwd` = #{pwd},\n" +
            "`is_first_login` = false\n" +
            "WHERE `uid` = #{uId};")
    int upUserPwd(@Param("uId") Long uId, @Param("pwd") String pwd);
}
