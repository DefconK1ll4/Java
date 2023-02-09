package com.divby0exc.wswebappwithpostman.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Entity
@Data
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int age;
    private String race;
    public String toString() {
        return name + "\n" + "Year " + age + "\n" + "Race: " + race;
    }
}
