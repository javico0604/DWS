package com.example.example.domain.service;

import com.example.example.domain.entity.Director;

public interface DirectorService {
    int create(Director director);

    void update(int id, Director director);

    void delete(int id);

    Director find(int id);
}
