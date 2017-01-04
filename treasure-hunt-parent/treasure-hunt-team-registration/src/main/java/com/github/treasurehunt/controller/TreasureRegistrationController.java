package com.github.treasurehunt.controller;

import com.github.treasurehunt.dao.UserDao;
import com.github.treasurehunt.entity.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/treasure")
@Slf4j
public class TreasureRegistrationController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/register")
    public String register(UserInfo userInfo) {
        try {
            if (!userDao.exists(userInfo.getUsername())) {
                userDao.save(userInfo);
                return "Registered Successfully...!!!";
            } else {
                return "Already Registered. Please contact admin to update details...!!!";
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("Can't Register. Internal server error");
        }
    }
}
