package com.vladcarcu.modules.domain.services;

import com.vladcarcu.modules.base.external.MessagePrinter;

import java.util.Optional;
import java.util.ServiceLoader;

public class ServiceLocator {

    private static ServiceLocator serviceLocator = new ServiceLocator();

    private ServiceLoader<MessagePrinter> messagePrinters;

    private ServiceLocator() {
        this.messagePrinters = ServiceLoader.load(MessagePrinter.class);
    }

    public static Optional<MessagePrinter> findMessagePrinter(String type) {
        return serviceLocator.messagePrinters.stream()
                .map(ServiceLoader.Provider::get)
                .filter(printer -> printer.isApplicable(type))
                .findFirst();
    }

}
