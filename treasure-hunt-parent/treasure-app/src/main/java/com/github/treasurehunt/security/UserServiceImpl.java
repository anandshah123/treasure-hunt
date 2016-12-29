package com.github.treasurehunt.security;

import com.github.treasurehunt.dao.UserDao;
import com.github.treasurehunt.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userDao.findByUsername(username);
        System.out.println(userInfo.getUser_role());
        GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getUser_role());
        UserDetails userDetails = (UserDetails) new User(userInfo.getUsername(),userInfo.getPassword(), Arrays.asList(authority));
        return userDetails;
    }
}