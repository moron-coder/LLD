package com.LLD.RestaurantManagementDesign.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;

@AllArgsConstructor
@Data
public class Restaurant {
    private String id;
    private String name;
    HashSet<Chef> chefs;
    HashSet<Waiter> waiters;

    public Restaurant(String id, String name){
        this.id=id;
        this.name=name;
        chefs = new HashSet<>();
        waiters = new HashSet<>();
    }
}
