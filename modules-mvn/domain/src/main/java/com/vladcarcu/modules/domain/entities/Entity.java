package com.vladcarcu.modules.domain.entities;

public class Entity<T> {

    private T id;
    private String name;

    private Entity() {
    }

    private void setId(T id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    public static class EntityBuilder<T> {
        private T id;
        private String name;

        public EntityBuilder<T> id(T id) {
            this.id = id;
            return this;
        }

        public EntityBuilder<T> name(String name) {
            this.name = name;
            return this;
        }

        public Entity<T> build() {
            var entity = new Entity<T>();
            entity.setId(id);
            entity.setName(name);
            return entity;
        }
    }
}
