package com.example.example.controller.model.director;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class DirectorUpdateWeb {

    private int id;
    private String name;
    private int birthYear;
    private int deathYear;
}
