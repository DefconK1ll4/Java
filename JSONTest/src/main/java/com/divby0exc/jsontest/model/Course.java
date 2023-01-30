package com.divby0exc.jsontest.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Course {
    private int id;


    private String name;
    private String description;
    private int attendees;
}
