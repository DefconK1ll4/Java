package com.divby0exc.wswebappwithpostman.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String username;
}
