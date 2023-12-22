package com.example.example.mapper;


import com.example.example.controller.model.actor.ActorCreateWeb;
import com.example.example.controller.model.actor.ActorDetailWeb;
import com.example.example.controller.model.actor.ActorListWeb;
import com.example.example.controller.model.actor.ActorUpdateWeb;
import com.example.example.domain.entity.Actor;
import com.example.example.domain.entity.Actor;
import com.example.example.domain.entity.Director;
import com.example.example.persistence.model.ActorEntity;
import com.example.example.persistence.model.ActorEntity;
import com.example.example.persistence.model.DirectorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ActorMapper {
    ActorMapper mapper = Mappers.getMapper(ActorMapper.class);

    Actor toActor(ActorCreateWeb actorCreateWeb);

    Actor toActor(ActorUpdateWeb actorUpdateWeb);
    ActorDetailWeb toActorDetailWeb(Actor actor);

    ActorListWeb toActorListWeb(Actor actor);

    ActorEntity toActorEntity(Actor actor);

    @Mapping(target = "id", expression = "java(resultSet.getInt(\"id\"))")
    @Mapping(target = "name", expression = "java(resultSet.getString(\"name\"))")
    @Mapping(target = "birthYear", expression = "java(resultSet.getInt(\"birthYear\"))")
    @Mapping(target = "deathYear", expression = "java(resultSet.getInt(\"deathYear\"))")
    ActorEntity toActorEntity(ResultSet resultSet) throws SQLException;

    Actor toActor(ActorEntity actorEntity);
    List<Actor> toActorList(List<ActorEntity> actorEntity);
}
