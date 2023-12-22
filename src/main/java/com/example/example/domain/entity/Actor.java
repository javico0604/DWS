package com.example.example.domain.entity;

public class Actor {

    private int id;
    private String name;
    private int BirthYear;
    private Integer DeathYear;

    public Actor(){

    }
    public Actor(int id, String name, int birthYear, Integer deathYear) {
        this.id = id;
        this.name = name;
        BirthYear = birthYear;
        DeathYear = deathYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return BirthYear;
    }

    public void setBirthYear(int birthYear) {
        BirthYear = birthYear;
    }

    public Integer getDeathYear() {
        return DeathYear;
    }

    public void setDeathYear(int deathYear) {
        DeathYear = deathYear;
    }

    @Override
    public String toString() {
        return "ActorRepositoryImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", BirthYear=" + BirthYear +
                ", DeathYear=" + DeathYear +
                '}';
    }
}
