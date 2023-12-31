package com.example.example.persistence.impl;

import com.example.example.domain.entity.CharacterMovie;
import com.example.example.domain.repository.CharacterMovieRepository;
import com.example.example.mapper.CharacterMovieMapper;
import com.example.example.persistence.dao.ActorDAO;
import com.example.example.persistence.dao.CharacterMovieDAO;
import com.example.example.persistence.model.CharacterMovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterMovieRepositoryImpl implements CharacterMovieRepository {

    @Autowired
    CharacterMovieDAO characterMovieDAO;

    @Autowired
    ActorDAO actorDAO;

    @Override
    public List<CharacterMovie> findByMovieId(int movieId) {
        List<CharacterMovieEntity> characterMovieEntities = characterMovieDAO.findByMovieId(movieId);
        List<CharacterMovie> characterMovies = new ArrayList<>();
        characterMovieEntities.forEach(characterMovieEntity -> characterMovies.add(CharacterMovieMapper.mapper.toCharacterMovie(characterMovieEntity)));
        return characterMovies;
    }
}
