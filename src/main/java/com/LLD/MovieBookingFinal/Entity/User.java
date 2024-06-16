package com.LLD.MovieBookingFinal.Entity;

import java.util.UUID;

public class User extends Entity{
    private String name;
    private String email;

    public User(String name, String email) {
        super(UUID.randomUUID().toString());
        this.name = name;
        this.email = email;
    }
}
