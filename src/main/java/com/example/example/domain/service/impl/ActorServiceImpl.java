package com.example.example.domain.service.impl;

import com.example.example.domain.entity.Actor;
import com.example.example.domain.entity.Director;
import com.example.example.domain.service.ActorService;
import com.example.example.exception.ResourceNotFoundException;
import com.example.example.domain.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public int create(Actor actor){
        return actorRepository.insert(actor);
    }

    @Override
    public void update(int id, Actor actor) {
        actorRepository.find(id).orElseThrow(()->new ResourceNotFoundException("Actor no encontrado con id: " + id));
        actorRepository.update(actor);
    }

    @Override
    public void delete(int id) {
        actorRepository.find(id).orElseThrow(()->new ResourceNotFoundException("Actor no encontrado con id: " + id));
        actorRepository.delete(id);
    }

    @Override
    public Actor find(int id) {
        return actorRepository.find(id).orElseThrow(()->new ResourceNotFoundException("Actor no encontrado con id: " + id));
    }
}
