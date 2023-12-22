package com.example.example.domain.entity;

import java.util.List;
public class Movie {
    private int id;
    private String title;
    private int year;
    private int runtime;
    private Director director;
    private List<CharacterMovie> characterMovie;
    public Movie(){

    }

    public Movie(int id, String title, int year, int runTime) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.runtime = runTime;
    }

    public Movie(String title, int year, int runTime) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.runtime = runTime;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runTime) {
        this.runtime = runTime;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", runTime=" + runtime +
                ", year=" + year +
                ", director=" + director +
                ", character=" + characterMovie +
                //", actors=" + actors +
                '}';
    }

    public List<CharacterMovie> getCharacterMovie() {
        return characterMovie;
    }

    public void setCharacterMovie(List<CharacterMovie> characterMovie) {
        this.characterMovie = characterMovie;
    }
}
