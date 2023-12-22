package com.example.example.domain.repository;

import com.example.example.domain.entity.Director;
import com.example.example.persistence.model.DirectorEntity;

import java.util.Optional;

public interface DirectorRepository {

    int insert(Director director);

    void update(Director director);

    Optional<Director> find(int id);

    void delete(int id);

    Director findByMovieId(int movieId);

}
