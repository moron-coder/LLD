package com.LLD.RestaurantManagementDesign.Entity;

import java.util.HashSet;
import java.util.Set;

public class Waiter extends Person{
    public static int waiterCount = 0;
    private Set<Table> tables = new HashSet<>();
    private Set<Order> orders = new HashSet<>();

    public Waiter(String name) {
        super(String.valueOf(waiterCount), name);
        waiterCount = waiterCount+1;
        tables = new HashSet<>();
    }

    public void takeOrder(Order order){
        orders.add(order);
    }

    public void addTable(Table table){
        tables.add(table);
        table.setWaiter(this);
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Waiter){
            return ((Waiter)obj).getId().equals(this.getId());
        }
        return false;
    }
}
