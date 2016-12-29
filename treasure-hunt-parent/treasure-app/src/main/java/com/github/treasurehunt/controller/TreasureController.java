package com.github.treasurehunt.controller;

import com.github.treasurehunt.dto.ConfigDTO;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody String earnMoney(Authentication authentication) {
        return "";
    }
}
