package com.example.example.domain.repository;

import com.example.example.domain.entity.Actor;
import com.example.example.domain.entity.Director;

import java.util.List;
import java.util.Optional;

public interface ActorRepository {
    int insert(Actor actor);

    void update(Actor actor);

    Optional<Actor> find(int id);

    void delete(int id);

    List<Actor> findByMovieId(int movieId);

}
