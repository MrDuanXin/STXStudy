package com.study.init;

import com.study.dao.UserInfoDao;
import com.study.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class JdbcInit {
//    @Autowired
    private UserInfoDao userInfoDao;

//    @PostConstruct
    public void init() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("lisi");
        userInfo.setPassword(passwordEncoder.encode("lisi"));
        userInfo.setRole("normal");
        userInfoDao.save(userInfo);
    }
//    @PostConstruct
    public void init2() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("admin");
        userInfo.setPassword(passwordEncoder.encode("admin"));
        userInfo.setRole("admin");
        userInfoDao.save(userInfo);
    }
}
