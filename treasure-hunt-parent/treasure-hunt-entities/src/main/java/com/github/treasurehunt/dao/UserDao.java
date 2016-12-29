package com.github.treasurehunt.dao;

import com.github.treasurehunt.entity.UserInfo;
import org.springframework.data.repository.Repository;

import javax.transaction.Transactional;

@Transactional
public interface UserDao extends Repository<UserInfo, Long> {

 public UserInfo findByUsername(String username);

}