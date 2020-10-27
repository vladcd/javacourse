package com.example.modules.rest.controller;

import com.example.modules.domain.entities.Actor;
import com.example.modules.domain.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping
    public ResponseEntity<Actor> getActor() {
        return ResponseEntity.of(actorService.getById(1));
    }
}
