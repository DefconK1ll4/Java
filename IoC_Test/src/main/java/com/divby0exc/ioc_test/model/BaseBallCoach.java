package com.divby0exc.ioc_test.model;

import com.divby0exc.ioc_test.service.FortuneService;

public class BaseBallCoach implements Coach{
    private FortuneService fortuneService;

    public BaseBallCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "BaseballCoach amk";
    }
}
