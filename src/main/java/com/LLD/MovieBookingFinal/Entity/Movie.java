package com.LLD.MovieBookingFinal.Entity;

import java.util.UUID;

public class Movie extends Entity{
    String name;
    int durationInMinutes;

    public Movie(String name, int durationInMinutes) {
        super(UUID.randomUUID().toString());
        this.name = name;
        this.durationInMinutes = durationInMinutes;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    @Override
    public final boolean equals(Object other){
        Movie m = (Movie) other;
        if(this.getId()==null){
            return m.getId()==null;
        }
        return this.getId().equals(m.getId());
    }

    @Override
    public int hashCode(){
        if(this.getId()==null){
            return 0;   //  not possible as id is not nullable
        }
        return this.getId().hashCode();
    }

    @Override
    public String toString(){
        return "Movie : "+this.name;
    }
}
