package com.example.modules.domain.services;

import com.example.modules.domain.entities.Actor;

import java.util.Optional;

public interface ActorService {

    Optional<Actor> getById(Integer id);
}
