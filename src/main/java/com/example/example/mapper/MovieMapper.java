package com.example.example.mapper;

import com.example.example.controller.model.characterMovie.CharacterMovieListWeb;
import com.example.example.controller.model.movie.MovieCreateWeb;
import com.example.example.controller.model.movie.MovieDetailWeb;
import com.example.example.controller.model.movie.MovieListWeb;
import com.example.example.controller.model.movie.MovieUpdateWeb;
import com.example.example.domain.entity.CharacterMovie;
import com.example.example.domain.entity.Movie;
import com.example.example.persistence.model.CharacterMovieEntity;
import com.example.example.persistence.model.MovieEntity;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieMapper mapper = Mappers.getMapper(MovieMapper.class);


    MovieListWeb toMovieListWeb(Movie movie);

    @Mapping(target = "directorListWeb", expression = "java(DirectorMapper.mapper.toDirectorListWeb(movie.getDirector()))")
    @Mapping(target = "characterMovieListWeb", expression = "java(mapCharacterMoviesToCharacterMovieListWeb(movie.getCharacterMovie()))")
    MovieDetailWeb toMovieDetailWeb(Movie movie);
    @Named("characterMoviesToCharacterMovieListWeb")
    default List<CharacterMovieListWeb> mapCharacterMoviesToCharacterMovieListWeb(List<CharacterMovie> characterMovies) {
        return characterMovies.stream()
                .map(CharacterMovieMapper.mapper::toCharacterMovieListWeb)
                .toList();
    }

    @Mapping(target = "id", expression = "java(resultSet.getInt(\"id\"))")
    @Mapping(target = "title", expression = "java(resultSet.getString(\"title\"))")
    @Mapping(target = "year", expression = "java(resultSet.getInt(\"year\"))")
    @Mapping(target = "runtime", expression = "java(resultSet.getInt(\"runtime\"))")
    MovieEntity toMovieEntity(ResultSet resultSet) throws SQLException;

    @Mapping(target = "director", expression = "java(DirectorMapper.mapper.toDirector(movieEntity.getDirectorEntity()))")
    @Mapping(target = "characterMovie", expression = "java(CharacterMovieMapper.mapper.toCharacterMovie(movieEntity.getCharacterMovieEntities()))")
    @Named("toMovie")
    Movie toMovieWithDirectorAndCharacter(MovieEntity movieEntity);

    @Mapping(target = "director", ignore = true)
    @Mapping(target = "characterMovie", ignore = true)
    Movie toMovie(MovieEntity movieEntity);

    @Mapping(target = "director", ignore = true)
    @Mapping(target = "characterMovie", ignore = true)
    Movie toMovie(MovieCreateWeb movieCreateWeb);

    @Mapping(target = "director", ignore = true)
    @Mapping(target = "characterMovie", ignore = true)
    Movie toMovie(MovieUpdateWeb movieUpdateWeb);

    @Mapping(target = "directorEntity", expression = "java(DirectorMapper.mapper.toDirectorEntity(movie.getDirector()))")
    @Mapping(target = "characterMovieEntities", expression = "java(mapCharacterMovieToCharacterMovieEntity(movie.getCharacterMovie()))")
    MovieEntity toMovieEntity(Movie movie);

    @Mapping(target = "director", ignore = true)
    @Mapping(target = "characterMovies", ignore = true)
    List<Movie> toMovieList(List<MovieEntity> movieEntities);

    @Mapping(target = "director", expression = "java(DirectorMapper.mapper.toDirector(movieEntity.getDirectorEntity()))")
    @Mapping(target = "characterMovie", expression = "java(CharacterMovieMapper.mapper.toCharacterMovie(movieEntity.getCharacterMovieEntities()))")
    @Named("toMovieWithDirectorAndCharacterMovies")
    Movie toMovieWithDirectorAndCharacterMovies(MovieEntity movieEntity);
    @Named("characterToCharacterIds")
    default HashMap<Integer, String> mapCharacterToCharacterIds(List<CharacterMovie> characterMovies){
        return characterMovies.stream()
                .collect(Collectors.toMap(
                        characterMovie -> characterMovie.getActor().getId(),
                        CharacterMovie::getCharacterActor,
                        (existing, replacement) -> existing, // Manejar duplicados (en este caso, mantener el valor existente)
                        HashMap::new // Especificar el tipo de Map (en este caso, HashMap)
                ));
    }

    /*@Named("actorToActorIds")
    default List<Integer> mapActorsToActorIds(List<Actor> actors) {
        return actors.stream()
                .map(actor -> actor.getId())
                .toList();
    }*/

    @Named("characterMovieToCharacterMovieEntity")
    default List<CharacterMovieEntity> mapCharacterMovieToCharacterMovieEntity(List<CharacterMovie> characterMovies){
        return characterMovies.stream()
                .map(characterMovie -> CharacterMovieMapper.mapper.toCharacterMovieEntity(characterMovie))
                .collect(Collectors.toList());
    }


}
