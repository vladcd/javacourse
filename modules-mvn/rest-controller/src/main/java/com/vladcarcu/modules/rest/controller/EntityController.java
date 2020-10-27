package com.vladcarcu.modules.rest.controller;

import com.vladcarcu.modules.base.external.MessagePrinter;
import com.vladcarcu.modules.domain.EntityService;
import com.vladcarcu.modules.domain.entities.Entity;

public class EntityController<T> {

    private EntityService<T> entityService;
    // TODO 3: uncomment to demonstrate requires transitive
//     private MessagePrinter messagePrinter;

    public EntityController() {
        this.entityService = new EntityService<>();
        // TODO 3: uncomment to demonstrate requires transitive
//        this.messagePrinter = new ConsolePrinter();
    }

    public Entity<T> getEntity(T id) {
//        this.messagePrinter.print("Called the getEntity with id {}", id);
        return entityService.get(id);
    }
}
