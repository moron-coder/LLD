package com.LLD.RestaurantManagementDesign.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
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

    @Override
    public String toString(){
        return "MenuItemName : "+this.name;
    }
}
