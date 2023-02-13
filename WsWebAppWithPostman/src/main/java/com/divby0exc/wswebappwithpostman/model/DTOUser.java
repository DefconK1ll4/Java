package com.divby0exc.wswebappwithpostman.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class DTOUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String username;
}
