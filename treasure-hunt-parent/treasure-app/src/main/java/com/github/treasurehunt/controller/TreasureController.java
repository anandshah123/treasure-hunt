package com.github.treasurehunt.controller;

import com.github.treasurehunt.dto.ConfigDTO;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/treasure")
public class TreasureController {

    @PostMapping("/config")
    public ConfigDTO setParams(@RequestBody ConfigDTO configDTO) {
        return configDTO;
    }

    @GetMapping("/earn")
    public @ResponseBody String earnMoney(SecurityProperties.User user) {
        return "";
    }
}
