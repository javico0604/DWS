package com.example.example.domain.service;

import com.example.example.domain.entity.Movie;

import java.util.List;
import java.util.Map;

public interface MovieService {
    List<Movie> getAll(Integer page, Integer pageSize);
    List<Movie> getAll();
    Movie find(int id);
    long getTotalNumberOfRecords();
    int create(Movie movie, int directorId, Map<Integer, String> characters);
    void update(Movie movie, int directorId, Map<Integer, String> characters);

    void delete(int id);
}
