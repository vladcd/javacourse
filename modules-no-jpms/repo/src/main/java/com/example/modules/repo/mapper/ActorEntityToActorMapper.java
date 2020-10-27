package com.example.modules.repo.mapper;

import com.example.modules.domain.entities.Actor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ActorEntityToActorMapper {

    public Actor toActor(com.example.modules.repo.entities.Actor actorEntity) {
        if (actorEntity == null) {
            return null;
        }
        Actor actor = new Actor();
        actor.setName(actorEntity.getName());
        return actor;
    }

    public Optional<Actor> toActorOptional(Optional<com.example.modules.repo.entities.Actor> actorOptional) {
        return Optional.ofNullable(toActor(actorOptional.orElse(null)));
    }
}
