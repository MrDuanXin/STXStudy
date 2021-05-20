package com.study.provider;

import com.study.dao.UserInfoDao;
import com.study.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserInfoDao userInfoDao;
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=null;
        UserInfo userInfo=null;
        if(username!=null){
            userInfo = userInfoDao.findByUsername(username);
            if (userInfo!=null){
                List<GrantedAuthority> list=new ArrayList<GrantedAuthority>();
                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+userInfo.getRole());
                list.add(authority);
                user=new User(userInfo.getUsername(),userInfo.getPassword(),list);
            }
        }
        return user;
    }
}
