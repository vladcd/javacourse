package com.example.modules.repo.services.impl;

import com.example.modules.domain.entities.Actor;
import com.example.modules.domain.services.ActorService;
import com.example.modules.repo.mapper.ActorEntityToActorMapper;
import com.example.modules.repo.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private ActorEntityToActorMapper actorMapper;

    @Override
    public Optional<Actor> getById(Integer id) {
        return actorMapper.toActorOptional(actorRepository.findById(id));
    }
}
