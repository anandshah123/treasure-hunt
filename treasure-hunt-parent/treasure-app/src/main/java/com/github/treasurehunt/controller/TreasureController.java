package com.github.treasurehunt.controller;

import com.github.treasurehunt.dao.UserDao;
import com.github.treasurehunt.dto.ConfigDTO;
import com.github.treasurehunt.dto.Reward;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.influxdb.dto.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.influxdb.InfluxDBTemplate;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/treasure")
@Slf4j
public class TreasureController {


    @Autowired
    private UserDao userDao;
    private static ConfigDTO configDTO = new ConfigDTO();
    private static final AtomicInteger totalHits = new AtomicInteger();
    private static final Random random = new Random();
    RateLimiter limiter = RateLimiter.create(configDTO.getRateLimit());

    @Autowired
    private InfluxDBTemplate<Point> influxDBTemplate;

    @Secured("ROLE_ADMIN")
    @PostMapping("/config")
    public ConfigDTO setParams(@RequestBody ConfigDTO configDTO) {
        TreasureController.configDTO = configDTO;
        limiter = RateLimiter.create(configDTO.getRateLimit());
        return configDTO;
    }

    @Secured("ROLE_USER")
    @GetMapping("/earn")
    public Reward earnMoney(Principal user) throws InterruptedException {
        Reward reward;

        limiter.acquire();

        if (totalHits.incrementAndGet() < configDTO.getFirstNLucky()) {
            reward = new Reward(configDTO.getFirstNLuckyPoints());
        } else {
            reward = new Reward(configDTO.getMinPoints() + random.nextInt(configDTO.getMaxPoints() - configDTO.getMinPoints()));
        }
        if (configDTO.getResponseDelay() > 0) {
            Thread.sleep(configDTO.getResponseDelay());
        }

        try {
            final Point p = Point.measurement("money")
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .field("value", reward.getMoney())
                    .field("username", user.getName())
                    .build();
            influxDBTemplate.write(p);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException("Can't provide money now. Internal server error");
        }
        return reward;
    }
}
