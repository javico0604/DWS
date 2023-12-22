package com.example.example.controller.model.characterMovie;

import com.example.example.controller.model.actor.ActorListWeb;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class CharacterMovieListWeb{
    private ActorListWeb actorListWeb;
    private String characterActor;
}
