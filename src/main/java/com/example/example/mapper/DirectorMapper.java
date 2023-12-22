package com.example.example.mapper;

import com.example.example.controller.model.director.DirectorCreateWeb;
import com.example.example.controller.model.director.DirectorDetailWeb;
import com.example.example.controller.model.director.DirectorListWeb;
import com.example.example.controller.model.director.DirectorUpdateWeb;
import com.example.example.domain.entity.Director;
import com.example.example.persistence.model.DirectorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

@Mapper(componentModel = "spring")
public interface DirectorMapper {

    DirectorMapper mapper = Mappers.getMapper(DirectorMapper.class);

    Director toDirector(DirectorCreateWeb directorCreateWeb);
    Director toDirector(DirectorUpdateWeb directorUpdateWeb);
    DirectorDetailWeb toDirectorDetailWeb(Director director);

    DirectorListWeb toDirectorListWeb(Director director);

    DirectorEntity toDirectorEntity(Director director);

    @Mapping(target = "id", expression = "java(resultSet.getInt(\"id\"))")
    @Mapping(target = "name", expression = "java(resultSet.getString(\"name\"))")
    @Mapping(target = "birthYear", expression = "java(resultSet.getInt(\"birthYear\"))")
    @Mapping(target = "deathYear", expression = "java(resultSet.getInt(\"deathYear\"))")
    DirectorEntity toDirectorEntity(ResultSet resultSet) throws SQLException;

    Director toDirector(DirectorEntity DirectorEntity);
}
