package com.example.example.persistence.impl;

import com.example.example.domain.entity.Movie;
import com.example.example.domain.repository.MovieRepository;
import com.example.example.mapper.MovieMapper;
import com.example.example.persistence.dao.CharacterMovieDAO;
import com.example.example.persistence.dao.MovieDAO;
import com.example.example.persistence.model.MovieEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

@Component
public class MovieRepositoryImpl implements MovieRepository {

    private final MovieDAO movieDAO;
    private final CharacterMovieDAO characterMovieDAO;

    @Autowired
    public MovieRepositoryImpl(MovieDAO movieDAO, CharacterMovieDAO characterMovieDAO) {
        this.movieDAO = movieDAO;
        this.characterMovieDAO = characterMovieDAO;
    }
    @Override
    public List<Movie> getAll(Integer page, Integer pageSize) {
        List<MovieEntity> movieEntities;
        if(page != null && page > 0) {
            Pageable pageable = PageRequest.of(page - 1, pageSize);
            movieEntities = movieDAO.findAll(pageable).stream().toList();
        } else {
            movieEntities = movieDAO.findAll();
        }
        return MovieMapper.mapper.toMovieList(movieEntities);
    }

    @Override
    public Optional<Movie> find(int id) {
        MovieEntity movieEntity = movieDAO.findById(id).orElse(null);
        if(movieEntity == null) {
            return Optional.empty();
        }
        return Optional.of(MovieMapper.mapper.toMovieWithDirectorAndCharacterMovies(movieEntity));
    }

    @Override
    public long getTotalNumberOfRecords() {
        return movieDAO.count();
    }

    @Override
    @Transactional
    public int insert(Movie movie) {
        MovieEntity movieEntity = movieDAO.save(MovieMapper.mapper.toMovieEntity(movie));
        return movieEntity.getId();
    }

    @Override
    @Transactional
    public void update(Movie movie) {
        MovieEntity movieEntity = movieDAO.save(MovieMapper.mapper.toMovieEntity(movie));
    }

    @Override
    public List<Movie> findByDirectorId(int directorId) {
        return MovieMapper.mapper.toMovieList(movieDAO.findByDirectorEntityId(directorId));
    }

    @Override
    @Transactional
    public void delete(Movie movie) {
        movieDAO.delete(MovieMapper.mapper.toMovieEntity(movie));
    }
}
