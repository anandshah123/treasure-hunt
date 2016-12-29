package com.github.treasurehunt.dto;

import lombok.Data;

@Data
public class ConfigDTO {
    private long responseDelay;
    private int minPoints = 0;
    private int maxPoints = 10;
    private int rateLimit = 1000;
    private int firstNLucky;
    private int firstNLuckyPoints;
}
