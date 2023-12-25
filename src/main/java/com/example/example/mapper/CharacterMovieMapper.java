package com.example.example.mapper;

import com.example.example.controller.model.characterMovie.CharacterMovieCreateWeb;
import com.example.example.controller.model.characterMovie.CharacterMovieListWeb;
import com.example.example.domain.entity.Actor;
import com.example.example.domain.entity.CharacterMovie;
import com.example.example.persistence.model.ActorEntity;
import com.example.example.persistence.model.CharacterMovieEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Mapper(componentModel = "spring")
public interface CharacterMovieMapper {
    CharacterMovieMapper mapper = Mappers.getMapper(CharacterMovieMapper.class);

    @Mapping(target = "id", expression = "java(resultSet.getInt(\"id\"))")
    @Mapping(target = "characterActor", expression = "java(resultSet.getString(\"characters\"))")
    CharacterMovieEntity toCharacterMovieEntity(ResultSet resultSet) throws SQLException;

    @Mapping(target = "actorEntity", expression = "java(ActorMapper.mapper.toActorEntity(characterMovie.getActor()))")
    CharacterMovieEntity toCharacterMovieEntity(CharacterMovie characterMovie);

    List<CharacterMovie> toCharacterMovieList(List<CharacterMovieEntity> characterMovieEntity);

    @Mapping(target = "actor", expression = "java(ActorMapper.mapper.toActor(characterMovieEntity.getActorEntity()))")
    CharacterMovie toCharacterMovie(CharacterMovieEntity characterMovieEntity);


    @Mapping(target = "actor", ignore = true)
    CharacterMovie toCharacterMovie(CharacterMovieCreateWeb characterMovieCreateWeb);
    @Mapping(target = "actorListWeb", expression="java(ActorMapper.mapper.toActorListWeb(characterMovie.getActor()))")
    CharacterMovieListWeb toCharacterMovieListWeb(CharacterMovie characterMovie);

    @Mapping(target = "actor", expression = "java(ActorMapper.mapper.toActor(characterMovieEntity.getActorEntity()))")
    List<CharacterMovie> toCharacterMovie(List<CharacterMovieEntity> characterMovieEntity);
}
