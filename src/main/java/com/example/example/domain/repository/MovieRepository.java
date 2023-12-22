package com.example.example.domain.repository;

import com.example.example.domain.entity.CharacterMovie;
import com.example.example.domain.entity.Movie;
import com.example.example.persistence.dao.CharacterMovieDAO;
import com.example.example.persistence.dao.MovieDAO;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface MovieRepository {

    List<Movie> getAll(Integer page, Integer pageSize);
    Optional<Movie> find(int id);
    long getTotalNumberOfRecords();
    int insert(Movie movie);
    void update(Movie movie);
    List<Movie> findByDirectorId(int directorId);

    void delete(Movie movie);
}
