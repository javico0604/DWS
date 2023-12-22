package com.example.example.persistence.dao;

import com.example.example.db.DBUtil;
import com.example.example.domain.entity.Director;
import com.example.example.mapper.DirectorMapper;
import com.example.example.persistence.model.DirectorEntity;
import com.example.example.persistence.model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface DirectorDAO extends JpaRepository<DirectorEntity, Integer> {

    @Query(value = "select d.id, d.name, d.birthYear, d.deathYear from directors d join movies m on d.id = m.director_id where m.id = :movieId", nativeQuery = true)
    DirectorEntity findByMovieId(@Param("movieId") int movieId);
}
