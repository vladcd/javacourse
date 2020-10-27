package com.vladcarcu.modules.base.external;

import com.vladcarcu.modules.base.external.MessagePrinter;

public class ConsolePrinter implements MessagePrinter {

    @Override
    public void print(String message, Object... arguments) {
        System.out.println(String.format(message, arguments));
    }

    @Override
    public boolean isApplicable(String type) {
        return "CONSOLE".equals(type);
    }
}
