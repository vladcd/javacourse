package com.vladcarcu.modules.graphql;

import com.vladcarcu.modules.domain.EntityService;
import com.vladcarcu.modules.domain.entities.Entity;

// TODO 2: see the error message in this controller
public class EntityController<T> {

    private EntityService<T> entityService;

    public EntityController() {
        this.entityService = new EntityService<>();
    }

    public Entity<T> getEntity(T id) {
        return entityService.get(id);
    }
}
