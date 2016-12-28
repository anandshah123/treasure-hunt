package com.github.treasurehunt.dto;

import lombok.Data;

@Data
public class ConfigDTO {
    private long responseDelay;
    private int minPoints;
    private int maxPoints;
    private int rateLimit;
    private int firstNLucky;
    private int firstNLuckyPoints;
}
