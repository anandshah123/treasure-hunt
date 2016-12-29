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

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImpl implements UserDetailsService {

    private Map<String, UserInfo> cache = new ConcurrentHashMap<>();

    @Autowired
    private UserDao userDao;

    @PostConstruct
    public void init() {
        for (UserInfo userInfo : userDao.findAll()) {
            cache.put(userInfo.getUsername(), userInfo);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = cache.get(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getUser_role());
        return new User(userInfo.getUsername(), userInfo.getPassword(), Collections.singletonList(authority));
    }
}