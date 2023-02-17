package com.divby0exc.ioc_test;

import com.divby0exc.ioc_test.model.BaseBallCoach;
import com.divby0exc.ioc_test.model.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach = context.getBean("myCoach", Coach.class);
    }
}
