package com.example.example.domain.repository;

import com.example.example.domain.entity.Actor;
import com.example.example.domain.entity.CharacterMovie;

import java.util.List;

public interface CharacterMovieRepository {
    List<CharacterMovie> findByMovieId(int movieId);
}
