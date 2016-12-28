package com.github.treasurehunt.controller;

import com.github.treasurehunt.dto.ConfigDTO;
import com.google.common.net.HttpHeaders;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/treasure")
public class TreasureController {

    @Secured("ROLE_ADMIN")
    @PostMapping("/config")
    public ConfigDTO setParams(@RequestBody ConfigDTO configDTO) {
        return configDTO;
    }

    @Secured("ROLE_USER")
    @GetMapping("/earn")
    public @ResponseBody String earnMoney(SecurityProperties.User user) {
        return "";
    }
}
