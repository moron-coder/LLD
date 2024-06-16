package com.LLD.MovieBookingFinal.Entity;

import org.springframework.lang.NonNull;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class CinemaHall extends Entity{
    String name;

    public String getName() {
        return name;
    }

    public Set<Screen> getScreens() {
        return screens;
    }

    Set<Screen> screens = new HashSet<>();

    public CinemaHall(@NonNull String name, @NonNull Set<Screen> screens){
        super(UUID.randomUUID().toString());
        this.name = name;
        this.screens = screens;
    }

    public void setScreens(Set<Screen> screens) {
        this.screens = screens;
    }

    @Override
    public String toString(){
        return "Cinamahall name : "+name;
    }
}
