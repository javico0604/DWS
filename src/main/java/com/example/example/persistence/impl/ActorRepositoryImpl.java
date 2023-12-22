package com.example.example.persistence.impl;

import com.example.example.db.DBUtil;
import com.example.example.domain.entity.Actor;
import com.example.example.domain.repository.ActorRepository;
import com.example.example.mapper.ActorMapper;
import com.example.example.persistence.dao.ActorDAO;
import com.example.example.persistence.model.ActorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@Repository
public class ActorRepositoryImpl implements ActorRepository {

    @Autowired
    ActorDAO actorDAO;

    @Override
    public int insert(Actor actor) {
        return actor.getId();
    }

    @Override
    public Optional<Actor> find(int id) {
        ActorEntity actorEntity = actorDAO.findById(id).orElse(null);
        if(actorEntity == null) {
            return Optional.empty();
        }
        return Optional.of(ActorMapper.mapper.toActor(actorEntity));
    }

    @Override
    public void update(Actor actor) {

    }

    @Override
    public void delete(int id) {

    }
    @Override
    public List<Actor> findByMovieId(int movieId) {
        return actorDAO.findByMovieId(movieId);
    }
}
