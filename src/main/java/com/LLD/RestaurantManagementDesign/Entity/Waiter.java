package com.LLD.RestaurantManagementDesign.Entity;

import java.util.HashSet;
import java.util.Set;

public class Waiter extends Person{
    private Set<Table> tables;
    private Set<Order> orders;

    public Waiter(String id, String name) {
        super(id, name);
        tables = new HashSet<>();
    }

    public void takeOrder(Order order){
        orders.add(order);
    }

    public void addTable(Table table){
        tables.add(table);
        table.setWaiter(this);
    }
}
