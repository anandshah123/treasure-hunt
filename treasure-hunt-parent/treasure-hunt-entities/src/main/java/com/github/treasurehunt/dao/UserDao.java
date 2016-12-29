package com.github.treasurehunt.dao;

import com.github.treasurehunt.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserDao extends JpaRepository<UserInfo, String> {

}