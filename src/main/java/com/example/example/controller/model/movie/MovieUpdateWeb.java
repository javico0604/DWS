package com.example.example.controller.model.movie;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class MovieUpdateWeb {
    private int id;
    private String title;
    private int year;
    private int runTime;
    private int directorId;
    private Map<Integer, String> characters;
}
