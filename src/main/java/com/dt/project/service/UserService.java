package com.dt.project.service;


import com.dt.project.config.ResponseBase;
import com.dt.project.dto.UserDto;
import com.dt.project.model.UserInfo;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 通过uId查找 userName
     */
    String serviceGetName(Long uId);

    /**
     * 查询用户 状态
     */
    UserInfo getUserStatus(Long uid);

    //用户认证
    ResponseBase doGetAuthenticationInfo(HttpServletResponse response, UserDto userDto);


    //查询账号管理信息
    List<UserInfo> findByUsers(UserDto pageDto);

    /**
     * 通过 id查询 用户
     */
    UserInfo getSingleUser(Long id);

    /**
     * 更新用户信息
     */
    ResponseBase updateUserInfo(Map<String, Object> userMap);

    /**
     * 单个删除或批量删除用户信息
     */
    int delUserInfo(String uidIds);

    /**
     * 单个恢复或批量恢复用户信息
     */
    int reUserInfo(@Param("uidIds") String uidIds);

    /**
     * 查询被删除的用户信息
     */
    List<UserInfo> findByDelUserInfo();

    /**
     * 注册用户验证用户是否存在
     */
    UserInfo getUserName(String userName);


    /**
     * 查找所有用户信息
     */
    List<UserInfo> getByUsers();

    /**
     * 首次登陆 用户密码更新
     *
     * @return
     */
    int upUserPwd(@Param("uid") Long uid, @Param("pwd") String pwd);

    /**
     * 新增用户
     *
     * @return
     */
    ResponseBase saveUserInfo(Map<String, Object> userMap);

}
