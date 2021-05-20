package com.study.service.impl;

import com.study.dao.UserInfoDao;
import com.study.entity.UserInfo;
import com.study.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoDao userInfoDao;

    public UserInfo findUserInfo(String username) {
        UserInfo userInfo = userInfoDao.findByUsername(username);
        return userInfo;
    }
}
