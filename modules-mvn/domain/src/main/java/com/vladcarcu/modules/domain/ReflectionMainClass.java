package com.vladcarcu.modules.domain;

public class ReflectionMainClass {

    public static void main(String[] args) throws Exception {
        var logPrinterClass = Class.forName("com.vladcarcu.modules.base.LogPrinter");

        // try to instantiate by reflection
        var constructors = logPrinterClass.getConstructors();
        for (var constructor : constructors) {
            System.out.println(constructor.getName());
        }

        // display the methods of a class
        var methods = logPrinterClass.getMethods();
        for (var method : methods) {
            System.out.println(method.getName());
        }

        // try to instantiate by reflection
        Object newInstance = null;
        try {
            var constructor = logPrinterClass.getConstructor();
            newInstance = constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // access a private method
            var privateMethod = logPrinterClass.getDeclaredMethod("isEquals", String.class);
            privateMethod.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
