package com.example.example.domain.entity;

public class CharacterMovie {
    int id;
    Actor actor;
    String characterActor;

    public CharacterMovie() {
    }

    public int getId() {
        return id;
    }

    public Actor getActor() {
        return actor;
    }

    public String getCharacterActor() {
        return characterActor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void setcharacterActor(String characterActor) {
        this.characterActor = characterActor;
    }

    @Override
    public String toString() {
        return "CharacterMovie{" +
                "id=" + id +
                ", actor=" + actor +
                ", characterActor='" + characterActor + '\'' +
                '}';
    }
}
