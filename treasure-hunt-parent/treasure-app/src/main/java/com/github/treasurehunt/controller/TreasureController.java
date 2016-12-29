package com.github.treasurehunt.controller;

import com.github.treasurehunt.dto.ConfigDTO;
import com.github.treasurehunt.dto.Reward;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/treasure")
public class TreasureController {

    private static ConfigDTO configDTO = new ConfigDTO();
    private static final AtomicInteger totalHits = new AtomicInteger();
    private static final Random random = new Random();

    @Secured("ROLE_ADMIN")
    @PostMapping("/config")
    public ConfigDTO setParams(@RequestBody ConfigDTO configDTO) {
        TreasureController.configDTO = configDTO;
        return configDTO;
    }

    @Secured("ROLE_USER")
    @GetMapping("/earn")
    public Reward earnMoney(Authentication authentication) throws InterruptedException {
        Reward reward;
        if (totalHits.incrementAndGet() < configDTO.getFirstNLucky()) {
            reward = new Reward(configDTO.getFirstNLuckyPoints());
        } else {
            reward = new Reward(configDTO.getMinPoints() + random.nextInt(configDTO.getMaxPoints() - configDTO.getMinPoints()));
        }
        if (configDTO.getResponseDelay() > 0) {
            Thread.sleep(configDTO.getResponseDelay());
        }
        return reward;
    }
}
