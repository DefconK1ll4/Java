package com.divby0exc.wswebappwithpostman.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class DTOChannel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String toString() {
        return "Channel with ID: " + id + " has been created.";
    }
}
