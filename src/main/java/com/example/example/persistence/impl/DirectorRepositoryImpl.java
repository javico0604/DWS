package com.example.example.persistence.impl;

import com.example.example.db.DBUtil;
import com.example.example.exception.DBConnectionException;
import com.example.example.domain.entity.Director;
import com.example.example.exception.ResourceNotFoundException;
import com.example.example.domain.repository.DirectorRepository;
import com.example.example.exception.SQLStatementException;
import com.example.example.mapper.ActorMapper;
import com.example.example.mapper.DirectorMapper;
import com.example.example.persistence.dao.DirectorDAO;
import com.example.example.persistence.model.ActorEntity;
import com.example.example.persistence.model.DirectorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DirectorRepositoryImpl implements DirectorRepository {
    @Autowired
    DirectorDAO directorDAO;

    @Override
    public int insert(Director director) {
        return director.getId();
    }

    @Override
    public Optional<Director> find(int id) {
        DirectorEntity directorEntity = directorDAO.findById(id).orElse(null);
        if(directorEntity == null) {
            return Optional.empty();
        }
        return Optional.of(DirectorMapper.mapper.toDirector(directorEntity));
    }

    @Override
    public void update(Director director) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Director findByMovieId(int movieId) {
        return DirectorMapper.mapper.toDirector(directorDAO.findByMovieId(movieId));
    }
}
