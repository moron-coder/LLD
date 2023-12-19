package com.LLD.RestaurantManagementDesign.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@AllArgsConstructor
@Data
public class Restaurant {
    private String id;
    private String name;
    HashSet<Chef> chefs;
    HashSet<Waitor> waitors;

    public Restaurant(String id, String name){
        this.id=id;
        this.name=name;
        chefs = new HashSet<>();
        waitors = new HashSet<>();
    }
}
