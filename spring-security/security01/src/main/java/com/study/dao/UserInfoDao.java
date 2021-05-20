package com.study.dao;

import com.study.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDao extends JpaRepository<UserInfo, Long> {
    UserInfo findByUsername(String name);
}
