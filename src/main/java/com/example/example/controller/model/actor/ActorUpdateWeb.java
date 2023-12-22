package com.example.example.controller.model.actor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class ActorUpdateWeb {

    private int id;
    private String name;
    private int birthYear;
    private int deathYear;
}
