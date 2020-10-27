package com.vladcarcu.modules.domain;

import com.vladcarcu.modules.base.external.ConsolePrinter;
import com.vladcarcu.modules.base.external.MessagePrinter;
import com.vladcarcu.modules.domain.services.ServiceLocator;
import com.vladcarcu.modules.domain.entities.Entity;

public class EntityService<T> {

    private MessagePrinter messagePrinter;

    public EntityService() {
        this.messagePrinter = new ConsolePrinter();
        // TODO 4: import the log printer through the service locator
//        this.messagePrinter = ServiceLocator.findMessagePrinter("LOG").orElseThrow();
    }

    public Entity<T> get(T id) {
        // TODO 1: try to import console printer; import it and log something
        this.messagePrinter.print("Retrieving entity with id %s", id);
        return new Entity.EntityBuilder<T>()
                .id(id)
                .build();
    }

}
