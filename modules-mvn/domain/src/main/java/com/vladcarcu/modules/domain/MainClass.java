package com.vladcarcu.modules.domain;

public class MainClass {

    public static void main(String[] args) {
        var entityService = new EntityService<Integer>();
        entityService.get(1);
    }
}
