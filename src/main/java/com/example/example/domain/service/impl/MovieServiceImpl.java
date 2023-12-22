package com.example.example.domain.service.impl;

import com.example.example.domain.entity.CharacterMovie;
import com.example.example.domain.entity.Director;
import com.example.example.domain.entity.Movie;
import com.example.example.domain.repository.ActorRepository;
import com.example.example.domain.repository.CharacterMovieRepository;
import com.example.example.domain.repository.DirectorRepository;
import com.example.example.domain.service.MovieService;
import com.example.example.exception.ResourceNotFoundException;
import com.example.example.domain.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private DirectorRepository directorRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private CharacterMovieRepository characterMovieRepository;

    @Override
    public List<Movie> getAll(Integer page, Integer pageSize) {
        return movieRepository.getAll(page, pageSize);
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.getAll(null, null);
    }

    @Override
    public Movie find(int movieId) {
        Movie movie =  movieRepository.find(movieId).orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + movieId));;

        Director director = directorRepository.findByMovieId(movieId);
        movie.setDirector(director);

        //List<Actor> actors = actorRepository.findByMovieId(id);
        //movie.setActors(actors);

        List<CharacterMovie> characterMovieList = characterMovieRepository.findByMovieId(movieId);
        characterMovieList.forEach(characterMovie -> characterMovie.setActor(actorRepository.find(characterMovie.getActor().getId()).orElse(null)));
        movie.setCharacterMovie(characterMovieList);

        return movie;    }

    @Override
    public long getTotalNumberOfRecords() {
        return movieRepository.getTotalNumberOfRecords();
    }

    @Override
    public int create(Movie movie, int directorId, Map<Integer, String> characters) {
        Director director = directorRepository.find(directorId)
                .orElseThrow(() -> new ResourceNotFoundException("Director not found with id: " + directorId));

        movie.setDirector(director);
        List<CharacterMovie> characterMovies = new ArrayList<>();

        characters.forEach((actorId, character) -> {
           CharacterMovie characterMovie =  new CharacterMovie();
           characterMovie.setActor(actorRepository.find(actorId).orElse(null));
           characterMovie.setcharacterActor(character);
           characterMovies.add(characterMovie);
        });
        movie.setCharacterMovie(characterMovies);
        return movieRepository.insert(movie);
    }

    @Override
    public void update(Movie movie, int directorId, Map<Integer, String> characters) {
        Director director = directorRepository.find(directorId)
                .orElseThrow(() -> new ResourceNotFoundException("Director not found with id: " + directorId));

        movie.setDirector(director);
        List<CharacterMovie> characterMovies = new ArrayList<>();

        characters.forEach((actorId, character) -> {
            CharacterMovie characterMovie =  new CharacterMovie();
            characterMovie.setActor(actorRepository.find(actorId).orElse(null));
            characterMovie.setcharacterActor(character);
            characterMovies.add(characterMovie);
        });
        movie.setCharacterMovie(characterMovies);
        movieRepository.update(movie);
    }

    @Override
    public void delete(int id){
        movieRepository.delete(movieRepository.find(id).orElse(null));
    }
}