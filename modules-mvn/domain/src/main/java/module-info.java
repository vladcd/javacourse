module com.vladcarcu.domain {
    // TODO 3: uncomment to require transitive
//    requires transitive com.vladcarcu.base;
    requires com.vladcarcu.base;

    // TODO 4: uncomment to demonstrate use
//    uses com.vladcarcu.modules.base.external.MessagePrinter;

    // TODO 2: demonstrate how exports to limits the access for a specific module
//    exports com.vladcarcu.modules.domain to com.vladcarcu.rest.controller;
//    exports com.vladcarcu.modules.domain.entities to com.vladcarcu.rest.controller;
    exports com.vladcarcu.modules.domain;
    exports com.vladcarcu.modules.domain.entities;
}