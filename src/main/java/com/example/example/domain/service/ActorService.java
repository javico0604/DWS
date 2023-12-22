package com.example.example.domain.service;

import com.example.example.domain.entity.Actor;
import com.example.example.domain.entity.Director;

public interface ActorService {
    int create(Actor actor);

    void update(int id, Actor actor);

    void delete(int id);

    public Actor find(int id);
}
