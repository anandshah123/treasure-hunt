package com.github.treasurehunt.controller;

import com.github.treasurehunt.dao.UserDao;
import com.github.treasurehunt.dto.ConfigDTO;
import com.github.treasurehunt.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/treasure")
public class TreasureController {

    @Autowired
    private UserDao userDao;

    @Secured("ROLE_ADMIN")
    @PostMapping("/config")
    public ConfigDTO setParams(@RequestBody ConfigDTO configDTO) {
        return configDTO;
    }

    @Secured("ROLE_USER")
    @GetMapping("/earn")
    public @ResponseBody String earnMoney(Authentication authentication) {
        return "";
    }

    @PostMapping("/register")
    public @ResponseBody String register(UserInfo userInfo) {
        try {
            userDao.save(userInfo);
            return "Registered Successfully...!!!";
        }catch (Exception e){
            return "Something went wrong. Please try again...!!!";
        }
    }
}
