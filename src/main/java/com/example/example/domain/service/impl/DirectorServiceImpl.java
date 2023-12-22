package com.example.example.domain.service.impl;

import com.example.example.domain.entity.Director;
import com.example.example.domain.service.DirectorService;
import com.example.example.exception.ResourceNotFoundException;
import com.example.example.domain.repository.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorServiceImpl implements DirectorService {
    @Autowired
    private DirectorRepository directorRepository;

    public int create(Director director){
        return directorRepository.insert(director);
    }

    @Override
    public void update(int id, Director director) {
        directorRepository.find(id).orElseThrow(() -> new ResourceNotFoundException("Director no encontrado con id: " + id));
        directorRepository.update(director);
    }

    @Override
    public void delete(int id) {
        directorRepository.find(id).orElseThrow(() -> new ResourceNotFoundException("Director no encontrado con id: " + id));
        directorRepository.delete(id);
    }

    @Override
    public Director find(int id) {
        Director director = directorRepository.find(id).orElseThrow(() -> new ResourceNotFoundException("Director not found with id: " + id));
        return director;
    }
}
