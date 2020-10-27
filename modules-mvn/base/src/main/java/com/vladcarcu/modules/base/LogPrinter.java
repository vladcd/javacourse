package com.vladcarcu.modules.base;

import com.vladcarcu.modules.base.external.MessagePrinter;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LogPrinter implements MessagePrinter {

    private static final Logger LOGGER = Logger.getGlobal();

    @Override
    public void print(String message, Object... arguments) {
        LOGGER.log(Level.INFO, message, arguments);
    }

    @Override
    public boolean isApplicable(String type) {
        return isEquals(type);
    }

    private boolean isEquals(String type) {
        return "LOG".equals(type);
    }

}
