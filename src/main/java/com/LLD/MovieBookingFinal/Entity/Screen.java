package com.LLD.MovieBookingFinal.Entity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Screen extends Entity{
    private String name;
    Set<Seat> seats = new HashSet<>();

    public Screen(String name, Set<Seat> seats) {
        super(UUID.randomUUID().toString());
        this.seats = seats;
        this.name = name;
    }

    public void setSeats(Set<Seat> seats) {
        this.seats = seats;
    }

    public Set<Seat> getSeats() {
        return seats;
    }

    @Override
    public String toString(){
        return "Screen name : "+name;
    }
}
