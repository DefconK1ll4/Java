package com.divby0exc.ioc_test;

import com.divby0exc.ioc_test.model.Coach;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class IoCTestApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach baseballCoach = context.getBean("baseBallCoach", Coach.class);
        Coach trackCoach = context.getBean("trackCoach", Coach.class);

        System.out.println(baseballCoach.getDailyWorkout());
        System.out.println(trackCoach.getDailyWorkout());

        context.close();

        SpringApplication.run(IoCTestApplication.class, args);
    }

}
