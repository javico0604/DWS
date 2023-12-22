package com.example.example.controller;

import com.example.example.controller.model.director.DirectorCreateWeb;
import com.example.example.controller.model.director.DirectorDetailWeb;
import com.example.example.controller.model.director.DirectorUpdateWeb;
import com.example.example.domain.service.DirectorService;
import com.example.example.http_response.Response;
import com.example.example.mapper.DirectorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/directors")
    @RestController
    public class DirectorController {

        @Autowired
        DirectorService directorService;

        @ResponseStatus(HttpStatus.CREATED)
        @PostMapping("")
        public Response create(@RequestBody DirectorCreateWeb directorCreateWeb){
            int id = directorService.create(DirectorMapper.mapper.toDirector(directorCreateWeb));
            DirectorDetailWeb directorDetailWeb = new DirectorDetailWeb(
                    id,
                    directorCreateWeb.getName(),
                    directorCreateWeb.getBirthYear(),
                    directorCreateWeb.getDeathYear()
            );
            return new Response(directorDetailWeb);
        }

        @ResponseStatus(HttpStatus.NO_CONTENT)
        @PutMapping("/{id}")
        public void update(@PathVariable("id") int id, @RequestBody DirectorUpdateWeb directorUpdateWeb){
            directorUpdateWeb.setId(id);
            directorService.update(id, DirectorMapper.mapper.toDirector(directorUpdateWeb));
        }

        @ResponseStatus(HttpStatus.OK)
        @GetMapping("/{id}")
        public Response find(@PathVariable("id") int id) {
            return new Response(DirectorMapper.mapper.toDirectorDetailWeb(directorService.find(id)));
        }

        @ResponseStatus(HttpStatus.NO_CONTENT)
        @DeleteMapping("/{id}")
        public void delete(@PathVariable("id") int id){
            directorService.delete(id);
        }
    }
