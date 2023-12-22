package com.example.example.controller;

import com.example.example.controller.model.actor.ActorCreateWeb;
import com.example.example.controller.model.actor.ActorDetailWeb;
import com.example.example.controller.model.actor.ActorUpdateWeb;
import com.example.example.domain.service.ActorService;
import com.example.example.http_response.Response;
import com.example.example.mapper.ActorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/actors")
@RestController
public class ActorController {


    @Autowired
    ActorService actorService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Response create(@RequestBody ActorCreateWeb actorCreateWeb){
        int id = actorService.create(ActorMapper.mapper.toActor(actorCreateWeb));
        ActorDetailWeb actorDetailWeb = new ActorDetailWeb(
                id,
                actorCreateWeb.getName(),
                actorCreateWeb.getBirthYear(),
                actorCreateWeb.getDeathYear()
        );
        return new Response(actorDetailWeb);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")    
    public void update(@PathVariable("id") int id, @RequestBody ActorUpdateWeb actorUpdateWeb){
        actorUpdateWeb.setId(id);
        actorService.update(id, ActorMapper.mapper.toActor(actorUpdateWeb));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Response find(@PathVariable("id") int id) {
        return new Response(ActorMapper.mapper.toActorDetailWeb(actorService.find(id)));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        actorService.delete(id);
    }
}
