package com.LLD.RestaurantManagementDesign.Entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Chef extends Person{
    public static int chefCount=0;
    HashSet<OrderItem> orderItems;
    HashSet<MenuItem> menuItems;

    public Chef(){}
    public Chef(String id, String name) {
        super(id, name);
        orderItems = new HashSet<>();
        menuItems = new HashSet<>();
    }

    public void addMenuItems(Set<MenuItem> menuItems){
        this.menuItems.addAll(menuItems);
    }
    public void removeMenuItems(Set<MenuItem> menuItems){
        this.menuItems.removeAll(menuItems);
    }

    public void addOrderItem(OrderItem item){
        this.orderItems.add(item);
        item.setChef(this);
    }
}
