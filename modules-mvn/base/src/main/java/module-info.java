// TODO 5: add open to module
module com.vladcarcu.base {
    requires java.logging;

    // TODO 1: uncomment row below to make classes visible between packages
    exports com.vladcarcu.modules.base.external;

    // TODO 4: uncomment to demonstrate service provider
//    provides MessagePrinter with LogPrinter, ConsolePrinter;

    // TODO 6: uncomment open declaration
//    opens com.vladcarcu.modules.base;
}