package com.dt.user.service.impl;


import com.dt.user.dto.UserDto;
import com.dt.user.mapper.UserMapper;
import com.dt.user.model.UserInfo;
import com.dt.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public String serviceGetName(Long uId) {
        return userMapper.getName(uId);
    }

    @Override
    public UserInfo getUserStatus(Long uid) {
        return userMapper.getUserStatus(uid);
    }

    @Override
    @Transactional
    public UserInfo findByUser(String userName) {
        UserInfo userInfo = userMapper.findByUser(userName);
        upUserLandingTime(userInfo.getUid(), new Date().getTime());
        return userInfo;
    }

    @Override
    public List<UserInfo> findByUsers(UserDto pageDto) {
        return userMapper.findByUsers(pageDto);
    }

    @Override
    public int upUserLandingTime(Long uId, Long landingTime) {
        return userMapper.upUserLandingTime(uId, landingTime);
    }

    @Override
    public UserInfo getSingleUser(Long id) {
        return userMapper.getSingleUser(id);
    }

    @Override
    public int upUser(Map<String, Object> userMap) {
        return userMapper.upUser(userMap);
    }

    @Override
    public int delUserInfo(String uidIds) {
        return userMapper.delUserInfo(uidIds);
    }

    @Override
    public int reUserInfo(String uidIds) {
        return userMapper.reUserInfo(uidIds);
    }

    @Override
    public List<UserInfo> findByDelUserInfo() {
        return userMapper.findByDelUserInfo();
    }

    @Override
    public UserInfo getUserName(String userName) {
        return userMapper.getUserName(userName);
    }

    @Override
    public int saveUserInfo(UserInfo userInfo) {
        return userMapper.saveUserInfo(userInfo);
    }

    @Override
    public List<UserInfo> getByUsers() {

        return userMapper.getByUsers();
    }

    @Override
    public int upUserPwd(Long uid, String pwd) {
        return userMapper.upUserPwd(uid, pwd);
    }

}
