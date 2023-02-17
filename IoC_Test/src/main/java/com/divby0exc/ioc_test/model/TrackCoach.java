package com.divby0exc.ioc_test.model;

import com.divby0exc.ioc_test.service.FortuneService;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Track coach amk";
    }
}
