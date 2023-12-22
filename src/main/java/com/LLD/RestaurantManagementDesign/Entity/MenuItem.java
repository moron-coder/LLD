package com.LLD.RestaurantManagementDesign.Entity;

import lombok.Getter;

@Getter
public class MenuItem {
    private String name;
    private double price;

    @Override
    public boolean equals(Object obj){
        if(obj instanceof MenuItem) {
            return this.name.equals(((MenuItem) obj).name);
        }
        return false;
    }
}
