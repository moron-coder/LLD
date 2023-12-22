package com.LLD.RestaurantManagementDesign.Entity;

import java.util.HashSet;

public class Chef extends Person{
    HashSet<OrderItem> orderItems;

    public Chef(String id, String name) {
        super(id, name);
        orderItems = new HashSet<>();
    }

    public Chef(String id, String name, HashSet<OrderItem> orderItems) {
        super(id, name);
        this.orderItems = orderItems;
    }

    public void addOrderItem(OrderItem item){
        this.orderItems.add(item);
        item.setChef(this);
    }
}
