package com.vladcarcu.modules.base.external;

public interface MessagePrinter {

    void print(String message, Object... arguments);

    boolean isApplicable(String type);
}
