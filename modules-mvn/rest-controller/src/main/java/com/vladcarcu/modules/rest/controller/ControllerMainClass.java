package com.vladcarcu.modules.rest.controller;

public class ControllerMainClass {

    public static void main(String[] args) {
        var entityController = new EntityController<Integer>();
        entityController.getEntity(1);
    }
}
