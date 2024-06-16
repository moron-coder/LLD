package com.LLD.MovieBookingFinal.Entity;

public class Entity {
    public Entity(String id) {
        this.id = id;
    }

    private final String id;

    public String getId() {
        return id;
    }

    @Override
    public String toString(){
        return "id : "+id;
    }
}
