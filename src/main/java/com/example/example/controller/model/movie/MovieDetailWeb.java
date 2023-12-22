package com.example.example.controller.model.movie;

import com.example.example.controller.model.characterMovie.CharacterMovieListWeb;
import com.example.example.controller.model.director.DirectorListWeb;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MovieDetailWeb {

    private int id;
    private String title;
    private int year;
    private int runtime;
    private DirectorListWeb directorListWeb;
    private List<CharacterMovieListWeb> characterMovieListWeb;
}
